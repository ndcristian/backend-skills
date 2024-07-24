package com.etixapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etixapp.models.manyToManyBidirectional.RoomModel;
import com.etixapp.repository.RoomRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class RoomController {

	@Autowired
	RoomRepository repository;

	@GetMapping("/room")
	public ResponseEntity<List<RoomModel>> getAll(){
		List<RoomModel> RoomModelList = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(RoomModelList);
	}

	@PostMapping("/room")
	public ResponseEntity<RoomModel> save(@RequestBody RoomModel RoomModel){
		RoomModel room = repository.save(RoomModel);
		return ResponseEntity.status(HttpStatus.OK).body(room);
	}

	@DeleteMapping("/room/{id}")
	public ResponseEntity<Long> delete(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
}
