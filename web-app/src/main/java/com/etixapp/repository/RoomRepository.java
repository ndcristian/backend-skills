package com.etixapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etixapp.models.manyToManyBidirectional.RoomModel;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {
}
