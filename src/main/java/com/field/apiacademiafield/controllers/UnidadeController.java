package com.field.apiacademiafield.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.field.apiacademiafield.models.Unidade;

import com.field.apiacademiafield.repositories.UnidadeRepository;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {
	
	@Autowired
	private UnidadeRepository repository;
	
	@GetMapping
	public List<Unidade> findAll(){
		
		return repository.findAll();
	}
	
}
