package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.oneToManyBidirectional.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
}
