package com.vcube.smsapp01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.smsapp01.model.Category;
import com.vcube.smsapp01.repo.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
	}
}
