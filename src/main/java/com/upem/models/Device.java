package com.upem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {
	@Id @GeneratedValue
	private Integer id;
	private String nom;
	private String idf ;
	private String cle ;
	
	public Device() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIdf() {
		return idf;
	}

	public void setIdf(String idf) {
		this.idf = idf;
	}

	
	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", nom=" + nom + ", idf=" + idf + ", clé=" + cle + "]";
	}
	
	
	
}
