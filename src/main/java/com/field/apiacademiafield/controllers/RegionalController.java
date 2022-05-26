package com.field.apiacademiafield.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.field.apiacademiafield.models.Regional;
import com.field.apiacademiafield.repositories.RegionalRepository;

@RestController
@RequestMapping("/")
public class RegionalController {

	@Autowired
	private RegionalRepository repository;
	
	@GetMapping
	public List<Regional> findAll(){
		
		return repository.findAll();
	}
}
