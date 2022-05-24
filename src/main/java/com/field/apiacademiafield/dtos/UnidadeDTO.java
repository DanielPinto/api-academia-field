package com.field.apiacademiafield.dtos;


import com.field.apiacademiafield.models.Regional;

public class UnidadeDTO {
	private Integer id;

	private String name;
	
	private String sigla;
	
	private Regional regional;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	
}
