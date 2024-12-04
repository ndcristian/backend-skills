package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.planning.BranchModel;

@Repository
public interface BranchRepository extends JpaRepository<BranchModel, Long> {
}
