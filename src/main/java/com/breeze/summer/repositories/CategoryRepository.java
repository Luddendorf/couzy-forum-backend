package com.breeze.summer.repositories;

import java.time.ZonedDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.breeze.summer.dto.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category save(Category category);
	
	@Modifying
	@Query("UPDATE Category category SET category.title = ?1, category.description = ?2, "
			+ "category.ip = ?3, category.updatedDatetime = ?4 WHERE category.categoryId = ?5")
	void update(String title, String desc, String ip, ZonedDateTime updateDateTime, 
			Long categoryId);
}
