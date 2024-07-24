package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.OneToMany.ColorModel;

@Repository
public interface ColorRepository extends JpaRepository<ColorModel, Long> {
}
