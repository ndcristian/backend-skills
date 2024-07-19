package com.etixapp.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etixapp.dto.QuestionDto;
import com.etixapp.models.QuestionModel;
import com.etixapp.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	private ModelMapper modelMapper = new ModelMapper();
	public List<QuestionModel> getAll(){
		List<QuestionModel> list = questionRepository.findAll();
		List<QuestionDto> listDto = new ArrayList<>();
		list.forEach((q)->{
			QuestionDto qDto = modelMapper.map(q, QuestionDto.class);
			listDto.add(qDto);
		});

		return questionRepository.findAll();
	}
//	@Transactional
	public QuestionModel save(QuestionModel question){
		return questionRepository.save(question);
	}
}
