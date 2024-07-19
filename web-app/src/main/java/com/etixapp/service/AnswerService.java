package com.etixapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etixapp.models.AnswerModel;
import com.etixapp.repository.AnswerRepository;

@Service //Consider defining a bean of type 'com.etixapp.service.AnswerService' in your configuration.
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	public List<AnswerModel> getAll() {
		return answerRepository.findAll();
	}

	public AnswerModel saveAnswer(AnswerModel answer){
		return answerRepository.save(answer);
	}
}
