package com.breeze.summer.services;

import static com.breeze.summer.utils.TimeUtilsService.getDateTimeNow;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.breeze.summer.dto.Category;
import com.breeze.summer.repositories.CategoryRepository;
import com.breeze.summer.utils.exception.CouzyForumException;


@Service
public class CategoryService {
	
	private Category newCategory;
	@Autowired
	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category saveCategory(Category category, String requestIp) {
		category.setIp(requestIp);
		return (Category) categoryRepository.save(category);
	}
	
	@Transactional
	public Category updateCategory(Category category, String requestIp) {
		if (category.getCategoryId() == null) {
			throw new CouzyForumException("Category ID is required when updating a category.");
		}
		Optional<Category> oldCategory = categoryRepository.findById(category.getCategoryId());
		
		oldCategory.ifPresentOrElse(
			(oldCat) -> { categoryRepository.update(category.getTitle(),
					category.getDescription(), requestIp, getDateTimeNow(),
					oldCat.getCategoryId());
			category.setUpdatedDateTime(getDateTimeNow());
			category.setCreatedDateTime(oldCat.getCreatedDateTime());
			},
			() -> {throw new CouzyForumException("Failed to updated a category");}
			);
		// category.setUpdatedDateTime(getDateTimeNow());
		return category;		
	}

	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(Category newCategory) {
		this.newCategory = newCategory;
	}
}
