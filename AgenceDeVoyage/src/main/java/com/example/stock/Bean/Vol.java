package com.example.stock.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String destination;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	private Date dateDeRetour;
	private double prix;
	private String etat;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateDeRetour() {
		return dateDeRetour;
	}
	public void setDateDeRetour(Date dateDeRetour) {
		this.dateDeRetour = dateDeRetour;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public Vol(Long id, String destination, Date dateDebut, Date dateDeRetour, double prix, String etat) {
		super();
		this.id = id;
		this.destination = destination;
		this.dateDebut = dateDebut;
		this.dateDeRetour = dateDeRetour;
		this.prix = prix;
		this.etat = etat;
	}
	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
