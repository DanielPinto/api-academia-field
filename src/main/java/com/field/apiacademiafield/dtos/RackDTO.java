package com.field.apiacademiafield.dtos;

import javax.validation.constraints.NotBlank;

public class RackDTO {

	private String etiqueta;
	
	@NotBlank
	private String local;
	
	@NotBlank
	private Boolean trancado;
	
	@NotBlank
	private Boolean etiquetado;
	
	@NotBlank
	private Boolean organizado;
	
	@NotBlank
	private Boolean equipamento_identificado;
	
	@NotBlank
	private Boolean pachcord_identificado;
	
	@NotBlank
	private Integer quantidade_equipamentos;
	
	@NotBlank
	private Integer id_unidade;

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Boolean getTrancado() {
		return trancado;
	}

	public void setTrancado(Boolean trancado) {
		this.trancado = trancado;
	}

	public Boolean getEtiquetado() {
		return etiquetado;
	}

	public void setEtiquetado(Boolean etiquetado) {
		this.etiquetado = etiquetado;
	}

	public Boolean getOrganizado() {
		return organizado;
	}

	public void setOrganizado(Boolean organizado) {
		this.organizado = organizado;
	}

	public Boolean getEquipamento_identificado() {
		return equipamento_identificado;
	}

	public void setEquipamento_identificado(Boolean equipamento_identificado) {
		this.equipamento_identificado = equipamento_identificado;
	}

	public Boolean getPachcord_identificado() {
		return pachcord_identificado;
	}

	public void setPachcord_identificado(Boolean pachcord_identificado) {
		this.pachcord_identificado = pachcord_identificado;
	}

	public Integer getQuantidade_equipamentos() {
		return quantidade_equipamentos;
	}

	public void setQuantidade_equipamentos(Integer quantidade_equipamentos) {
		this.quantidade_equipamentos = quantidade_equipamentos;
	}

	public Integer getId_unidade() {
		return id_unidade;
	}

	public void setId_unidade(Integer id_unidade) {
		this.id_unidade = id_unidade;
	}
	
	
	
}
