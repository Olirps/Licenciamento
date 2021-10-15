package com.licenciamento.ambiental.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "secretaria")
public class SecretariaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer secId;

	@Column(nullable = false, length = 100)
	private String secNome;
	
	@OneToMany(mappedBy = "secretaria")
	private List<ProcessoModel> processo = new ArrayList<>();
	
	public Integer getSecId() {
		return secId;
	}

	public void setSecId(Integer secId) {
		this.secId = secId;
	}

	public String getSecNome() {
		return secNome;
	}

	public void setSecNome(String secNome) {
		this.secNome = secNome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
