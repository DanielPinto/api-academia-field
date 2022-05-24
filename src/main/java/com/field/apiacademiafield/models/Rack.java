package com.field.apiacademiafield.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rack")
public class Rack {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String etiqueta;
	
	@Column(nullable = false)
	private String local;
	
	@Column(nullable = false)
	private Boolean trancado;
	
	@Column(nullable = false)
	private Boolean etiquetado;
	
	@Column(nullable = false)
	private Boolean organizado;
	
	@Column(nullable = false)
	private Boolean equipamento_identificado;
	
	@Column(nullable = false)
	private Boolean pachcord_identificado;
	
	@Column
	private Integer quantidade_equipamentos;

	@ManyToOne
	private Unidade unidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	

}

