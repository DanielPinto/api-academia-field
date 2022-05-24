package com.field.apiacademiafield.dtos;

import com.field.apiacademiafield.models.Analyst;

public class AnalystDTO {
	
	private Integer id;

	private String name;
	
	private String idCorporate;

	
	
	
	public AnalystDTO(Analyst analyst) {
		
		this.id = analyst.getId();
		this.name = analyst.getName();
		this.idCorporate = analyst.getIdCorporate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCorporate() {
		return idCorporate;
	}

	public void setIdCorporate(String idCorporate) {
		this.idCorporate = idCorporate;
	}
	
	
	
	
	

}
