package com.field.apiacademiafield.controllers;

import java.time.LocalDateTime;
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

import com.field.apiacademiafield.dtos.SwitchDTO;
import com.field.apiacademiafield.models.Rack;
import com.field.apiacademiafield.models.Switch;
import com.field.apiacademiafield.repositories.RackRepository;
import com.field.apiacademiafield.repositories.SwitchRepository;

@RestController
@RequestMapping("/switch")
public class SwitchController {

	@Autowired
	private SwitchRepository switchRepository;
	
	@Autowired
	private RackRepository rackRepository;
	
	
	@GetMapping
	public List<Switch> findAll(){
		return switchRepository.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody SwitchDTO switchDTO){
			
		
		Optional<Rack> rackOptional = rackRepository.findById(switchDTO.getRack_id());
		
		if(!rackOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade Not Found!");
		}
		
		Rack rack = rackOptional.get();	

		var mySwitch = new Switch();
		
		BeanUtils.copyProperties(switchDTO, mySwitch);
		
		mySwitch.setRack(rack);
		
		mySwitch.setData_vistoria(LocalDateTime.now());
			
		
		
		return ResponseEntity.status(HttpStatus.OK).body(switchRepository.save(mySwitch));
		
		}
}
