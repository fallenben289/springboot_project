package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.validation.valid;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Timbua;
import com.example.demo.repository.TimbuaRepository;

@RestController
@RequestMapping("/api/v1")

public class TimbuaController {

	@Autowired
	private TimbuaRepository timbuaRepository;
	
	//Get Timbua 
	@GetMapping("student")
	public List<Timbua> getAllTimbua(){
		return this.timbuaRepository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Timbua> getTimbuaById(@PathVariable(value = "id") Long timbuaId)
			throws ResourceNotFoundException {
		Timbua timbua = timbuaRepository.findById(timbuaId)
				.orElseThrow(() -> new ResourceNotFoundException("Timbua not found for this id :: " + timbuaId));
		return ResponseEntity.ok().body(timbua);
	}
	
	@PostMapping("student")
	public Timbua createTimbua(@Validated @RequestBody Timbua timbua) {
		return this.timbuaRepository.save(timbua);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Timbua> updateTimbua(@PathVariable(value = "id") Long  timbuaId,
			@Validated @RequestBody Timbua timbuaDetails) throws ResourceNotFoundException{
			
			Timbua timbua = timbuaRepository.findById(timbuaId)
					.orElseThrow(() -> new ResourceNotFoundException("Timbua not found for this ID:"+timbuaId));

			timbua.setEmail(timbuaDetails.getEmail());
			timbua.setfName(timbuaDetails.getfName());
			timbua.setlName(timbuaDetails.getlName());
			
			return ResponseEntity.ok(this.timbuaRepository.save(timbua));
		}
	
	@DeleteMapping("/student/{id}")
	public Map<String, Boolean> deleteTimbua(@PathVariable(value = "id") Long timbuaId)
			throws ResourceNotFoundException {
		Timbua timbua = timbuaRepository.findById(timbuaId)
				.orElseThrow(() -> new ResourceNotFoundException("Timbua not found for this id :: " + timbuaId));

		timbuaRepository.delete(timbua);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
