package com.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.model.MataPelajaran;
import com.crud.example.repositoy.MataPelajaranRepository;

@RestController
@RequestMapping("/mataPelajaran/v1")
public class MataPelajaranController {

	@Autowired
	private MataPelajaranRepository matapelajaranRepository;
	
	@GetMapping("/pelajaran")
	public List<MataPelajaran> getAllPelajaran() {
		return matapelajaranRepository.findAll();
	}
}
