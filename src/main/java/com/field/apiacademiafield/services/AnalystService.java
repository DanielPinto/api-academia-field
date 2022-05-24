package com.field.apiacademiafield.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.field.apiacademiafield.models.Analyst;
import com.field.apiacademiafield.repositories.AnalystRepository;

@Service
public class AnalystService {

	
	final AnalystRepository repository;

	public AnalystService(AnalystRepository repository) {
		this.repository = repository;
	}
	
	
	@Transactional
	public Analyst save(Analyst analyst) {
		return repository.save(analyst);
	}
	
	
	
}
