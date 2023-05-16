package com.breeze.summer.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.breeze.summer.dto.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
//	@Modifying
//	@Query("UPDATE Category category SET category.title = ?1, category.description = ?2, "
//			+ "category.ip = ?3, category.updatedDatetime = ?4 WHERE category.categoryId = ?5")
//	void update(String title);
	
	@Query("SELECT Post post WHERE post.updatedDatetime > ?1, post.updatedDatetime <= ?2, "
	+ "OR post.title = ?3 OR post.userId = ?4 \n#pageable\n")
	List<Post> findAllByFilter(ZonedDateTime fromDatetime, ZonedDateTime toDatetime,
			String title, Long userId, Pageable pageable);
}
