package com.example.stock.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
@Entity
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nomVoyage;
@ManyToOne
private Hotel hotel;
@ManyToOne
private VolCompany volCompany;
@Temporal(TemporalType.DATE)
@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
private Date deteDebut;
@Temporal(TemporalType.DATE)
@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
private Date detefin;
private String Description;
private String destination;
private String Url;
private Double prix;
private String etat;


public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}
public String getUrl() {
	return Url;
}
public void setUrl(String url) {
	Url = url;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNomVoyage() {
	return nomVoyage;
}
public void setNomVoyage(String nomVoyage) {
	this.nomVoyage = nomVoyage;
}
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
public VolCompany getVolCompany() {
	return volCompany;
}
public void setVolCompany(VolCompany volCompany) {
	this.volCompany = volCompany;
}
public Date getDeteDebut() {
	return deteDebut;
}
public void setDeteDebut(Date detaDebut) {
	this.deteDebut = detaDebut;
}
public Date getDetefin() {
	return detefin;
}
public void setDetefin(Date detafin) {
	this.detefin = detafin;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}



@Override
public String toString() {
	return "Voyage [id=" + id + ", nomVoyage=" + nomVoyage + ", hotel=" + hotel + ", volCompany=" + volCompany
			+ ", deteDebut=" + deteDebut + ", detefin=" + detefin + ", Description=" + Description + ", destination="
			+ destination + ", Url=" + Url + ", prix=" + prix + "]";
}

public Voyage(Long id, String nomVoyage, Hotel hotel, VolCompany volCompany, Date deteDebut, Date detefin,
		String description, String destination, String url, Double prix, String etat) {
	super();
	this.id = id;
	this.nomVoyage = nomVoyage;
	this.hotel = hotel;
	this.volCompany = volCompany;
	this.deteDebut = deteDebut;
	this.detefin = detefin;
	Description = description;
	this.destination = destination;
	Url = url;
	this.prix = prix;
	this.etat = etat;
}
public Voyage() {
	super();
	// TODO Auto-generated constructor stub
}

}

