package com.field.apiacademiafield.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="evidencia")
public class Evidencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String description;
	
	
	@OneToMany(mappedBy = "evidencia")
	private List<EvidenciaSwitch> evidenciaSwitchs;
	
	
	public List<EvidenciaSwitch> getEvidenciaSwitchs() {
		return converter(evidenciaSwitchs);
	}

	public void setEvidenciaSwitchs(List<EvidenciaSwitch> evidenciaSwitchs) {
		this.evidenciaSwitchs = evidenciaSwitchs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
	
	
public static List<EvidenciaSwitch> converter(List<EvidenciaSwitch> evidenciaSwitchs) {
        
		List<EvidenciaSwitch> evidenciasOnlytSwitchs = new ArrayList<EvidenciaSwitch>();
        
        for (EvidenciaSwitch evidenciaSwitch : evidenciaSwitchs) {
			
        	EvidenciaSwitch evidenciSwitchProvisorio = new EvidenciaSwitch();
        	evidenciSwitchProvisorio.setId(evidenciaSwitch.getId());
        	evidenciSwitchProvisorio.setMyswitch(evidenciaSwitch.getMyswitch());
        	
        	evidenciasOnlytSwitchs.add(evidenciSwitchProvisorio);
        	
        	
		}
        
        return evidenciasOnlytSwitchs;
		
    }
	
}
