package com.field.apiacademiafield.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.field.apiacademiafield.models.Evidencia;
import com.field.apiacademiafield.repositories.EvidenciaRepository;

@RestController
@RequestMapping("/evidencia")
public class EvidenciaController {

	@Autowired
	private EvidenciaRepository repository;
	

	@GetMapping
	public List<Evidencia> findAll(){
	 return repository.findAll();	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findAll(@PathVariable("id") Integer id){
		
		 Optional<Evidencia> evidenciaOptional = repository.findById(id);
		 
		 if(!evidenciaOptional.isPresent()) {
		
			 return ResponseEntity
					 .status(HttpStatus.NOT_FOUND)
					 .body("Unidade Not Found!");
			 
		 }
		  
		 return ResponseEntity.status(HttpStatus.OK).body(evidenciaOptional.get());
	}
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Evidencia evidencia){
			
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(evidencia));		
	}

}
