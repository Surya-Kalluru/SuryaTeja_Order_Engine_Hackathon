package com.vcube.smsapp01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.smsapp01.model.Category;
import com.vcube.smsapp01.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	 private final CategoryService categoryService;

	    // Create Category
	    @PostMapping("/insertCategory")
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }

	    // Get All Categories
	    @GetMapping("/getAllCategories")
	    public List<Category> getAllCategories() {
	        return categoryService.getAllCategories();
	    }

	    // Get Category By Id
	    @GetMapping("getCategoryById/{id}")
	    public Category getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id);
	    }
	    
	    
}
