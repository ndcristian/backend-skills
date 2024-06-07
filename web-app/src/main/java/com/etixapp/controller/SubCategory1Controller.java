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
import com.etixapp.models.SubCategory1Model;
import com.etixapp.repository.Subcategory1Repository;
import com.etixapp.service.CategoryService;


@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class SubCategory1Controller {

	@Autowired
	Subcategory1Repository repository;

	@GetMapping("/subcategory1")
	public ResponseEntity<List<SubCategory1Model>> getAll() {
		List<SubCategory1Model> categoryList = new ArrayList<>();
		categoryList = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(categoryList);
	}

	@PostMapping("/subcategory1")
	public ResponseEntity<SubCategory1Model> saveCategory(@RequestBody SubCategory1Model category) {
		SubCategory1Model savedCategory = repository.save(category);
		return ResponseEntity.status(HttpStatus.OK).body(savedCategory);
	}
}
