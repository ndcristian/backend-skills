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

import com.etixapp.models.AnswerModel;
import com.etixapp.service.AnswerService;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class AnswerController {

	@Autowired
	AnswerService service;

	@GetMapping("/answer")
	public ResponseEntity<List<AnswerModel>> getAll(){
		List<AnswerModel> answerModelList = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(answerModelList);
	}

	@PostMapping("/answer")
	public ResponseEntity<AnswerModel> saveCategory(@RequestBody AnswerModel answer) {
		AnswerModel saved = service.saveAnswer(answer);
		return ResponseEntity.status(HttpStatus.OK).body(saved);
	}
}
