package com.field.apiacademiafield.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.field.apiacademiafield.models.Analyst;

public interface AnalystRepository extends JpaRepository<Analyst, Integer> {
	
	Analyst findByIdCorporate(String idCorporate);

}
