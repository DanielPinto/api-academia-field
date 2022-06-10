package com.field.apiacademiafield.dtos;



import com.field.apiacademiafield.models.Evidencia;
import com.field.apiacademiafield.models.Switch;

public class EvidenciaSwitchDTO {
	
private Integer id;
	
	private String name;
	
	private String type;

	private String uriFoto;
	
    private Switch myswitch;

    private Evidencia evidencia;
    
    private Integer myswitch_id;

    private Integer evidencia_id;

    
    
    public Integer getMyswitch_id() {
		return myswitch_id;
	}

	public void setMyswitch_id(Integer myswitch_id) {
		this.myswitch_id = myswitch_id;
	}

	public Integer getEvidencia_id() {
		return evidencia_id;
	}

	public void setEvidencia_id(Integer evidencia_id) {
		this.evidencia_id = evidencia_id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUriFoto() {
		return uriFoto;
	}

	public void setUriFoto(String uriFoto) {
		this.uriFoto = uriFoto;
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
