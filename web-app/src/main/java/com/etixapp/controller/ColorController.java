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

import com.etixapp.models.OneToMany.ColorModel;
import com.etixapp.repository.ColorRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class ColorController {

	@Autowired
	ColorRepository repository;

	@GetMapping("/color")
	public ResponseEntity<List<ColorModel>> getAll(){
		List<ColorModel> ColorModelList = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(ColorModelList);
	}
	@PostMapping("/color")
	public ResponseEntity<ColorModel> save(@RequestBody ColorModel ColorModel){
		ColorModel product = repository.save(ColorModel);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
}
