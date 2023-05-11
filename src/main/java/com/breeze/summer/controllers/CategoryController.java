package com.breeze.summer.controllers;

import static com.breeze.summer.utils.ControllerUtil.getIpFromRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breeze.summer.dto.Category;
import com.breeze.summer.services.CategoryService;


@RestController
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
    @PostMapping("save")
    public Category createCategory(HttpServletRequest request, @RequestBody Category category) {
    	return categoryService.saveCategory(category, getIpFromRequest(request));
    }
    
    @PostMapping("update")
    public Category updateCategory(HttpServletRequest request, @RequestBody Category category) {
    	return categoryService.updateCategory(category, getIpFromRequest(request));
    }
}

