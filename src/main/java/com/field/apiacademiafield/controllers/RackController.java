package com.field.apiacademiafield.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.field.apiacademiafield.dtos.RackDTO;
import com.field.apiacademiafield.models.Rack;
import com.field.apiacademiafield.models.Unidade;
import com.field.apiacademiafield.repositories.RackRepository;
import com.field.apiacademiafield.repositories.UnidadeRepository;

@RestController
@RequestMapping("/rack")
public class RackController {

	@Autowired
	private RackRepository rackRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	
	@GetMapping
	public List<Rack> findAll(){
		return rackRepository.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody RackDTO rackDTO){
			
			Optional<Unidade> unidadeOptional = unidadeRepository.findById(rackDTO.getId_unidade());
			
			if(!unidadeOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade Not Found!");
			}
			
			Unidade unidade = unidadeOptional.get();	
			
			var rack = new Rack();
			
			BeanUtils.copyProperties(rackDTO, rack);
			
			rack.setUnidade(unidade);
			
			return ResponseEntity.status(HttpStatus.OK).body(rackRepository.save(rack));
		
		}
	
}
