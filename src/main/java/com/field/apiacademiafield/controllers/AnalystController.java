package com.field.apiacademiafield.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.field.apiacademiafield.dtos.InsertUnidadeForAnalyst;
import com.field.apiacademiafield.models.Analyst;
import com.field.apiacademiafield.models.Unidade;
import com.field.apiacademiafield.repositories.AnalystRepository;
import com.field.apiacademiafield.repositories.UnidadeRepository;
import com.field.apiacademiafield.services.AnalystService;

@RestController
@RequestMapping("/analyst")
public class AnalystController {

	@Autowired
	private AnalystRepository repository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private AnalystService service;
	
	@GetMapping
	public List<Analyst> findAll(){
		
		return repository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Integer id){
		
		
		Optional<Analyst> analystOptional = repository.findById(id);
		
		//Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findId(id);
		
		if(!analystOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Analyst Not Found!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(analystOptional.get());
	}
	
	
	@PostMapping
	public ResponseEntity<Object> saveAnalyst(@RequestBody Analyst analyst){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(analyst));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> insertUnidadeForAnalyst(@PathVariable(value = "id") Integer id, @RequestBody InsertUnidadeForAnalyst unidadeForAnalyst){
			

			Optional<Unidade> unidadeOptional = unidadeRepository.findById(unidadeForAnalyst.getId_unidade());
		
			
			if(!unidadeOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade Not Found!");
			}
			
			Unidade unidade = unidadeOptional.get();
			
			
			
			Optional<Analyst> analystOptional = repository.findById(id);
			
			if(!analystOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Analyst Not Found!");
			}
			
			var analyst = analystOptional.get();
			
			analyst.getUnidades().add(unidade);
			
			return ResponseEntity.status(HttpStatus.OK).body(service.save(analyst));
			
			
		}
		
	
	
	
}
