package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.oneToManyBidirectional.AnswerModel;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerModel, Long> {
}
