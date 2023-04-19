package com.breeze.summer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.breeze.summer.service.CategoryService;

import dto.Category;
import dto.Pupil;

@RestController
public class CategoryController {
	@Autowired
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
    @PostMapping(value="/pupil/update")
    public Category createCategory(@RequestBody Category category) {
    	return categoryService.saveCategory(category);
    }
}
