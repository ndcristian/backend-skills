package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.planning.AppointmentModel;

@Repository
public interface IntervalRepository extends JpaRepository<AppointmentModel, Long> {
}
