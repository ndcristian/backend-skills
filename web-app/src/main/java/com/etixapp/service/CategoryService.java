package com.etixapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etixapp.models.CategoryModel;
import com.etixapp.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public CategoryModel saveCategories(CategoryModel categoryModel) {
		return categoryRepository.save(categoryModel);

	}

	public List<CategoryModel> getAllCategories() {
		return categoryRepository.findAll();
	}

}
