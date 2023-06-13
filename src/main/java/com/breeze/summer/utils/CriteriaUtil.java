package com.breeze.summer.utils;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.Post;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class CriteriaUtil {

	private static final EnumMap<SortField, Function<Root<Post>, Path<Object>>> ORDER_BY;
	private static final String UPDATED_DATETIME = "updatedDatetime";
	private static final String TITLE = "title";
	private static final String TEXT = "text";
	private static final String USER_NAME = "userName";

	static {
		ORDER_BY = new EnumMap<>(SortField.class);
		ORDER_BY.put(SortField.DATE, postRoot -> postRoot.get(UPDATED_DATETIME));
		ORDER_BY.put(SortField.TITLE, postRoot -> postRoot.get(TITLE));
		ORDER_BY.put(SortField.TEXT, postRoot -> postRoot.get(TEXT));
		ORDER_BY.put(SortField.USER_NAME, postRoot -> postRoot.get(USER_NAME));
	}

	public static CriteriaQuery<Long> createPostTotalCountCriteria(FilterPost filter,
			EntityManager entityManager) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Post> postRoot = criteriaQuery.from(Post.class);

		Predicate finalPredicate = createFinalPredicate(filter, criteriaBuilder, postRoot);
		return criteriaQuery.select(criteriaBuilder.count(postRoot)).where(finalPredicate);
	}

	public static CriteriaQuery<Post> createPostSearchCriteria(FilterPost filter,
			EntityManager entityManager) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> postCriteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> postRoot = postCriteriaQuery.from(Post.class);
		postCriteriaQuery.select(postRoot);

		setFilterParams(filter, criteriaBuilder, postCriteriaQuery, postRoot);
		setOrderParams(filter, criteriaBuilder, postCriteriaQuery, postRoot);

		return postCriteriaQuery;
	}

	private static void addUpdateDatetimePredicate(List<Predicate> predicates, FilterPost filter,
			CriteriaBuilder criteriaBuilder, Root<Post> postRoot) {
		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime from = filter.getFromDatetime();
		ZonedDateTime to = filter.getToDatetime();

		if (from.isEqual(now) || from.isAfter(now)) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "From date cannot be the same or greater than now");
		}
		if (Objects.isNull(from)) {
			from = now.minusMonths(3);
		}

		if (Objects.isNull(to) || to.isAfter(now)) {
			to = now;
		}

		Predicate betweenDatePredicate = criteriaBuilder.between(postRoot.get(UPDATED_DATETIME),
				filter.getFromDatetime(), filter.getToDatetime());
		predicates.add(betweenDatePredicate);
	}

	private static void addUserNamePredicate(List<Predicate> predicates, FilterPost filter,
			CriteriaBuilder criteriaBuilder, Root<Post> postRoot) {

		if (StringUtils.isBlank(filter.getUserName())) {
			return;
		}

		if (filter.getUserName().length() < 3) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "User name must have at least 3 characters.");
		}

		Predicate userNamePredicate = criteriaBuilder
				.like(postRoot.get("userName"), "%" + filter.getUserName() + "%");

		predicates.add(userNamePredicate);
	}

	private static void addTitlePredicate(List<Predicate> predicates, FilterPost filter,
			CriteriaBuilder criteriaBuilder, Root<Post> postRoot) {

		if (StringUtils.isBlank(filter.getTitle())) {
			return;
		}

		if (filter.getTitle().length() < 3) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Title must have at least 3 characters.");
		}

		Predicate titlePredicate = criteriaBuilder
				.like(postRoot.get("title"), "%" + filter.getTitle() + "%");
		predicates.add(titlePredicate);
	}

	private static Predicate createFinalPredicate(FilterPost filter,
			CriteriaBuilder criteriaBuilder, Root<Post> postRoot) {
		List<Predicate> predicates = new ArrayList<>();

		addUpdateDatetimePredicate(predicates, filter, criteriaBuilder, postRoot);
		addUserNamePredicate(predicates, filter, criteriaBuilder, postRoot);
		addTitlePredicate(predicates, filter, criteriaBuilder, postRoot);

		return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
	}

	private static void setFilterParams(
			FilterPost filter,
			CriteriaBuilder criteriaBuilder,
			CriteriaQuery<?> criteriaQuery,
			Root<Post> postRoot) {
		Predicate finalPredicate = createFinalPredicate(filter, criteriaBuilder, postRoot);
		criteriaQuery.where(finalPredicate);
	}

	private static void setOrderParams(
			FilterPost filter,
			CriteriaBuilder criteriaBuilder,
			CriteriaQuery<Post> criteriaQuery,
			Root<Post> postRoot) {
		if (Objects.nonNull(filter.getSortBy())) {
			SortField sortField = SortField.convertFromValue(filter.getSortBy());
			Function<Root<Post>, Path<Object>> sortPath = ORDER_BY.get(sortField);
			Optional.ofNullable(sortPath)
					.ifPresent(setSortBy(criteriaBuilder, criteriaQuery,
							postRoot, filter, sortPath));
		}
	}

	private static Consumer<Function<Root<Post>, Path<Object>>> setSortBy(
			CriteriaBuilder criteriaBuilder,
			CriteriaQuery<Post> criteriaQuery,
			Root<Post> postRoot,
			FilterPost filter,
			Function<Root<Post>, Path<Object>> sortPath) {
		return path -> criteriaQuery.orderBy(
				filter.getSortDirection().equals(Sort.Direction.ASC)
						? criteriaBuilder.asc(sortPath.apply(postRoot))
						: criteriaBuilder.desc(sortPath.apply(postRoot)));
	}
}
