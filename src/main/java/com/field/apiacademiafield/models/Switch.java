package com.field.apiacademiafield.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="switch")
public class Switch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String etiqueta;
	
	@Column
	private String serial;
	
	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	@Column
	private Integer quantidade_portas;
	
	@Column
	private String nome_responsavel;
	
	@Column
	private String id_responsavel;
	
	@Column
	private String nome_vistoriador;
	
	@Column
	private String local;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column
	private LocalDateTime data_vistoria;
	
	@ManyToOne
	private Rack rack;
	
	@OneToMany(mappedBy = "myswitch")
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

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getQuantidade_portas() {
		return quantidade_portas;
	}

	public void setQuantidade_portas(Integer quantidade_portas) {
		this.quantidade_portas = quantidade_portas;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public String getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(String id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNome_vistoriador() {
		return nome_vistoriador;
	}

	public void setNome_vistoriador(String nome_vistoriador) {
		this.nome_vistoriador = nome_vistoriador;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalDateTime getData_vistoria() {
		return data_vistoria;
	}

	public void setData_vistoria(LocalDateTime data_vistoria) {
		this.data_vistoria = data_vistoria;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}
	
	
	
public static List<EvidenciaSwitch> converter(List<EvidenciaSwitch> evidenciaSwitchs) {
        
		List<EvidenciaSwitch> switchOnlytEvidencia = new ArrayList<EvidenciaSwitch>();
        
        for (EvidenciaSwitch evidenciaSwitch : evidenciaSwitchs) {
			
        	EvidenciaSwitch evidenciSwitchProvisorio = new EvidenciaSwitch();
        	evidenciSwitchProvisorio.setId(evidenciaSwitch.getId());        	
        
        	switchOnlytEvidencia.add(evidenciSwitchProvisorio);
        	
		}
        
        return switchOnlytEvidencia;
		
    }
	
	
}
