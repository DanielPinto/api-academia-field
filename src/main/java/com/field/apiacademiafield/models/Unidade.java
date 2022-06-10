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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="unidade")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;
	
	@Column
	private String sigla;
	
	@ManyToOne
	private Regional regional;
	
	@OneToMany
	@JoinColumn(name="unidade_id")
	private List<Rack> racks;
	
	@ManyToMany(mappedBy = "unidades",cascade = CascadeType.ALL)
	private List<Analyst> analysts;
	
	
	
	
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

	public List<Analyst> getAnalysts() {
		
		return converter(analysts);
	}

	public void setAnalysts(List<Analyst> analysts) {
		this.analysts = analysts;
	}
	
	public List<Rack> getRacks() {
		return racks;
	}

	public void setRacks(List<Rack> racks) {
		this.racks = racks;
	}

	
	
	public static List<Analyst> converter(List<Analyst> analysts) {
        
		List<Analyst> analystsWithOutUnidade = new ArrayList<Analyst>();
        
        for (Analyst analyst : analysts) {
			
        	Analyst analystProvisorio = new Analyst();
        	analystProvisorio.setId(analyst.getId());
        	analystProvisorio.setIdCorporate(analyst.getIdCorporate());
        	analystProvisorio.setName(analyst.getName());
        	
        	analystsWithOutUnidade.add(analystProvisorio);
        	
        	
		}
        
        return analystsWithOutUnidade;
		
    }

	
	
	
}
