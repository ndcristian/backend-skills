package com.etixapp.dto;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
	private long id;
	private String title;
	private String answer;
	private List<AnswerDto> options;
}
