package com.etixapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etixapp.models.CategoryModel;
import com.etixapp.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public ResponseEntity<List<CategoryModel>> getAll() {
		List<CategoryModel> categoryList = new ArrayList<>();
		categoryList = categoryService.getAllCategories();
		return ResponseEntity.status(HttpStatus.OK).body(categoryList);
	}

	@PostMapping("/category")
	public ResponseEntity<CategoryModel> saveCategory(@RequestBody CategoryModel category) {
		CategoryModel savedCategory = categoryService.saveCategories(category);
		return ResponseEntity.status(HttpStatus.OK).body(savedCategory);
	}
}
