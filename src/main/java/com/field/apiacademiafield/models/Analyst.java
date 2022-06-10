package com.field.apiacademiafield.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="analyst")
public class Analyst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;
	
	@Column
	private String idCorporate;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column 
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			  name = "analyst_unidade",
			  joinColumns = @JoinColumn(name="analyst_id"), 
			  inverseJoinColumns = @JoinColumn(name = "unidade_id"))
    private List<Unidade> unidades = new ArrayList<Unidade>();

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

	public List<Unidade> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	
	
public static List<Unidade> converter(List<Unidade> unidades) {
        
		List<Unidade> unidadesWithOutAnalyst = new ArrayList<Unidade>();
        
        for (Unidade unidade : unidades) {
        	
        	Unidade unidadeProvisorio = new Unidade();
        	
        	unidadeProvisorio.setId(unidade.getId());
        	unidadeProvisorio.setName(unidade.getName());
        	unidadeProvisorio.setRegional(unidade.getRegional());
        	unidadeProvisorio.setSigla(unidade.getSigla());
        	
        	unidadesWithOutAnalyst.add(unidadeProvisorio);
		}
        return unidadesWithOutAnalyst;
}
	
	

}
