package com.breeze.summer.repository;

import org.springframework.data.repository.CrudRepository;

import dto.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category save(Category category);
}
