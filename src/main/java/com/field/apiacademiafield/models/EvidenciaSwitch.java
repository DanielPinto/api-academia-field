package com.field.apiacademiafield.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evidencia_switch")
public class EvidenciaSwitch {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@Column
	private String uriPhoto;
	
	@Column
	private String viewPhoto;
	 
	@Lob
	private byte[] foto;
	
	@ManyToOne
    @JoinColumn(name = "switch_id")
    private Switch myswitch;

    @ManyToOne
    @JoinColumn(name = "evidencia_id")
    private Evidencia evidencia;
    
    
    
    
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getUriPhoto() {
		return uriPhoto;
	}

	public void setUriPhoto(String uriPhoto) {
		this.uriPhoto = uriPhoto;
	}

	public String getViewPhoto() {
		return viewPhoto;
	}

	public void setViewPhoto(String viewPhoto) {
		this.viewPhoto = viewPhoto;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Switch getMyswitch() {
		return myswitch;
	}

	public void setMyswitch(Switch myswitch) {
		this.myswitch = myswitch;
	}

	public Evidencia getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(Evidencia evidencia) {
		this.evidencia = evidencia;
	}
}
