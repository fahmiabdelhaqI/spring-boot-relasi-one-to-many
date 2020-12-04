package com.crud.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.model.Siswa;
import com.crud.example.repositoy.SiswaRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/siswa/v1")
public class SiswaController {

	@Autowired
	private SiswaRepository siswaRepository;
	
	@GetMapping("/siswas")
	public List<Siswa> getAllSiswas() {
		return siswaRepository.findAll();
	}
	
	@PostMapping("/addSiswas")
	public Siswa createSiswa(@Validated @RequestBody Siswa siswa) {
		return siswaRepository.save(siswa);
	}
	
	@PutMapping("/editSiswa/{id}")
	public ResponseEntity<Siswa> updateSiswa(@PathVariable(value = "id") Long SiswaId,
			@Validated @RequestBody Siswa siswaDetails) throws NotFoundException{
		Siswa siswa = siswaRepository.findById(SiswaId)
				.orElseThrow(() -> new  NotFoundException("Siswa not found for this id :: " + SiswaId));
		siswa.setNama_depan(siswaDetails.getNama_depan());
		siswa.setNama_belakang(siswaDetails.getNama_belakang());
		siswa.setAlamat(siswaDetails.getAlamat());
		final Siswa updateSiswa = siswaRepository.save(siswa);
		return ResponseEntity.ok(updateSiswa);
	}
	
	@DeleteMapping("/deleteSiswa/{id}")
	public Map<String, Boolean> deleteSiswa(@PathVariable(value = "id")Long siswaId)
		throws NotFoundException {
		Siswa siswa = siswaRepository.findById(siswaId)
				.orElseThrow(() -> new NotFoundException("Siswa not found for this id ::" + siswaId));
		siswaRepository.delete(siswa);
		Map<String, Boolean> response = new HashMap<>();
		return response;
	}
		
}
