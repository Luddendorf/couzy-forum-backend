package com.breeze.summer.services;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.FoundPosts;
import com.breeze.summer.dto.Post;
import com.breeze.summer.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static com.breeze.summer.utils.CriteriaUtil.createPostSearchCriteria;
import static com.breeze.summer.utils.CriteriaUtil.createPostTotalCountCriteria;

@Slf4j
@Service
public class PostService {
	@Autowired
	private final PostRepository postRepository;

	@Autowired
	private final EntityManager entityManager;

	@Autowired
	public PostService(PostRepository postRepository, EntityManager entityManager) {
		this.postRepository = postRepository;
		this.entityManager = entityManager;
	}

	public Post addPost(Post newPost, String authorIp) {
		newPost.setIp(authorIp);
		return postRepository.save(newPost);
	}

	public Post updatePost(Post updatedPost, String authorIp) {
		updatedPost.setIp(authorIp);
		return postRepository.save(updatedPost);
	}

	public FoundPosts findPostsByFilter(FilterPost filter) {
		TypedQuery<Post> findPosts = entityManager.createQuery(createPostSearchCriteria(filter, entityManager))
				.setFirstResult((filter.getCurrentPageNumber() - 1) * filter.getPostsPerPage())
				.setMaxResults(filter.getPostsPerPage());

		String rawQueryString = findPosts.unwrap(org.hibernate.Query.class).getQueryString();

		System.out.println(rawQueryString);

		List<Post> foundPosts = entityManager.createQuery(createPostSearchCriteria(filter, entityManager))
				.setFirstResult((filter.getCurrentPageNumber() - 1) * filter.getPostsPerPage())
				.setMaxResults(filter.getPostsPerPage()).getResultList();

		// String sql = SQLExtractor.from(foundPosts);

		Long totalPosts = findTotalPosts(filter);
		return new FoundPosts(foundPosts, totalPosts);
	}

	public Long findTotalPosts(FilterPost filter) {
		return entityManager.createQuery(createPostTotalCountCriteria(filter, entityManager))
				.getSingleResult();
	}
	/*
	 * public List<Post> findPostsByFilter(FilterPost filter) throws
	 * CouzyForumException {
	 * String title = filter.getTitle();
	 * Long userId = filter.getUserId();
	 * if (title.length() < 3) {
	 * // throw new CouzyForumException("Title cannot be shorter than 3 symbols.");
	 * return null;
	 * }
	 * 
	 * Pageable postPageable =
	 * PageRequest.of(filter.getCurrentPageNumber(), filter.getPostsPerPage(),
	 * Sort.by(filter.getSortDirection(), filter.getSortBy())
	 * .and(Sort.by("title")));
	 * 
	 * if (StringUtils.isNotBlank(title) && Objects.nonNull(userId)) {
	 * return
	 * postRepository.findAllByFilterWithTitleAndUserId(filter.getFromDatetime(),
	 * filter.getToDatetime(), title, userId, postPageable);
	 * }
	 * if (StringUtils.isNotBlank(title)) {
	 * return postRepository.findAllByFilterWithTitle(filter.getFromDatetime(),
	 * filter.getToDatetime(), title, postPageable);
	 * }
	 * if (Objects.nonNull(userId)) {
	 * return postRepository.findAllByFilterWithUserId(filter.getFromDatetime(),
	 * filter.getToDatetime(), userId, postPageable);
	 * }
	 * return null;
	 * }
	 */
}
