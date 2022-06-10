package com.field.apiacademiafield.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.field.apiacademiafield.models.EvidenciaSwitch;

@Repository
public interface EvidenciaSwitchRepository extends JpaRepository<EvidenciaSwitch, Integer>{}
