package com.breeze.summer.repositories;

import java.time.ZonedDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.breeze.summer.dto.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
//	@Modifying
//	@Query("UPDATE Category category SET category.title = ?1, category.description = ?2, "
//			+ "category.ip = ?3, category.updatedDatetime = ?4 WHERE category.categoryId = ?5")
//	void update(String title);
}
