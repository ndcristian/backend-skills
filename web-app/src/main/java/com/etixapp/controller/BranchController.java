package com.etixapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etixapp.models.planning.BranchModel;
import com.etixapp.repository.BranchRepository;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class BranchController {

	@Autowired
	BranchRepository repository;

	@PostMapping("/branch")
	public Long add(@RequestBody BranchModel branch) {
		return repository.save(branch).getId();
	}

	@GetMapping("branch")
	public List<BranchModel> get() {
		return repository.findAll();
	}

}
