package com.etixapp.controller;

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

import com.etixapp.models.OneToMany.ProductModel;
import com.etixapp.repository.ProductRepository;
import com.etixapp.service.QuestionService;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping("/product")
	public ResponseEntity<List<ProductModel>> getAll(){
		List<ProductModel> productModelList = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(productModelList);
	}
	@PostMapping("/product")
	public ResponseEntity<ProductModel> save(@RequestBody  ProductModel productModel){
		ProductModel product = repository.save(productModel);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
}
