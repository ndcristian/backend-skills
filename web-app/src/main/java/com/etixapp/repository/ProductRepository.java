package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.OneToMany.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
