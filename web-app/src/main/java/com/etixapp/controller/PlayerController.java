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

import com.etixapp.models.manyToManyBidirectional.PlayerModel;
import com.etixapp.repository.PlayerRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class PlayerController {

	@Autowired
	PlayerRepository repository;

	@GetMapping("/player")
	public ResponseEntity<List<PlayerModel>> getAll(){
		List<PlayerModel> PlayerModelList = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(PlayerModelList);
	}

	@PostMapping("/player")
	public ResponseEntity<PlayerModel> save(@RequestBody PlayerModel PlayerModel){
		PlayerModel player = repository.save(PlayerModel);
		return ResponseEntity.status(HttpStatus.OK).body(player);
	}

	@DeleteMapping("/player/{id}")
	public ResponseEntity<Long> delete(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
}
