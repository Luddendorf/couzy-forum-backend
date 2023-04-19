package com.breeze.summer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breeze.summer.repository.CategoryRepository;

import dto.Category;

@Service
public class CategoryService {
	@Autowired
	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
}
