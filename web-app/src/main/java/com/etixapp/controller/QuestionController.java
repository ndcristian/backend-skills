package com.etixapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etixapp.models.QuestionModel;
import com.etixapp.service.QuestionService;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@GetMapping("/question")
	public ResponseEntity<List<QuestionModel>> getAll(){
		List<QuestionModel> questionModelList = questionService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(questionModelList);
	}

	@PostMapping("/question")
	public ResponseEntity<QuestionModel> save(@RequestBody QuestionModel questionModel){
		QuestionModel question = questionService.save(questionModel);
		return ResponseEntity.status(HttpStatus.OK).body(question);
	}
}
