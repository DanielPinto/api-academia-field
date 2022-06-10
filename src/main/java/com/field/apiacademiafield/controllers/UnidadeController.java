package com.field.apiacademiafield.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Integer id){


		Optional<Unidade> optional = repository.findById(id);


		if(!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade Not Found!");
		}

		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	}
}
