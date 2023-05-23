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

	@Query(value = "SELECT * FROM post WHERE updated_datetime > ?1 AND updated_datetime <= ?2 "
			+ "AND title = ?3 AND user_id = ?4",
		   countQuery = "SELECT COUNT(id) FROM post WHERE updated_datetime > ?1 AND updated_datetime <= ?2 "
			+ "AND title = ?3 AND user_id = ?4", nativeQuery = true)
	List<Post> findAllByFilterWithTitleAndUserId(ZonedDateTime fromDatetime, ZonedDateTime toDatetime,
		String title, Long userId, Pageable pageable);
	
	@Query(value = "SELECT * FROM post WHERE updated_datetime > ?1 AND updated_datetime <= ?2 "
			+ "AND title LIKE CONCAT('%',?3,'%')",
		   countQuery = "SELECT COUNT(id) FROM post WHERE updated_datetime > ?1 AND updated_datetime <= ?2 "
			+ "AND title LIKE CONCAT('%',?3,'%')",
			nativeQuery = true)
	List<Post> findAllByFilterWithTitle(ZonedDateTime fromDatetime, ZonedDateTime toDatetime,
		String title, Pageable pageable);
	
	@Query(value = "SELECT * FROM post WHERE updated_datetime > ?1 AND updated_datetime <= ?2 "
			+ "AND user_id = ?4",
		   countQuery = "SELECT COUNT(id) FROM post WHERE updated_datetime > ?1 AND updated_datetime <= ?2 "
			+ "AND user_id = ?4", nativeQuery = true)
	List<Post> findAllByFilterWithUserId(ZonedDateTime fromDatetime, ZonedDateTime toDatetime,
		Long userId, Pageable pageable);
}
