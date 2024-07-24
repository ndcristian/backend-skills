package com.etixapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etixapp.models.oneToManyBidirectional.QuestionModel;
import com.etixapp.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	private ModelMapper modelMapper = new ModelMapper();
	public List<QuestionModel> getAll(){
		return questionRepository.findAll();
	}
//	@Transactional
	public QuestionModel save(QuestionModel question){
		return questionRepository.save(question);
	}

	public void delete(Long id) {
		 questionRepository.deleteById(id);
	}
}
