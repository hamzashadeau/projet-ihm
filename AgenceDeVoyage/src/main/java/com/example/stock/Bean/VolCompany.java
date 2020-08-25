package com.example.stock.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VolCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String description;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "VolCompany [id=" + id + ", nom=" + nom + ", description=" + description + "]";
}


public VolCompany(Long id, String nom, String description) {
	super();
	this.id = id;
	this.nom = nom;
	this.description = description;
}
public VolCompany() {
	super();
	// TODO Auto-generated constructor stub
}

}
