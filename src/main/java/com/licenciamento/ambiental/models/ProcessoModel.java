package com.licenciamento.ambiental.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "processos")
public class ProcessoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer procId;
	@Column(nullable = false,length = 100)
	private String procNome;
	
	@ManyToOne
	@JoinColumn(name = "secId")
	private SecretariaModel secretaria;

	public Integer getProcId() {
		return procId;
	}

	public void setProcId(Integer procId) {
		this.procId = procId;
	}

	public String getProcNome() {
		return procNome;
	}

	public void setProcNome(String procNome) {
		this.procNome = procNome;
	}

	public SecretariaModel getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(SecretariaModel secretaria) {
		this.secretaria = secretaria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
