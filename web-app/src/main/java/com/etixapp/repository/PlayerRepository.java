package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.manyToManyBidirectional.PlayerModel;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
}
