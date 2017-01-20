package net.isfce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lieu implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String nom;

	public Lieu() {
		super();
	}

	public Lieu(String nom) {
		super();
		this.nom = nom;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
