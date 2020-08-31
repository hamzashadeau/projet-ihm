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
private Double autre;
private Double prixNourriture;
private Double prixHotel;

private String etat;


public Double getAutre() {
	return autre;
}
public void setAutre(Double autre) {
	this.autre = autre;
}
public Double getPrixNourriture() {
	return prixNourriture;
}
public void setPrixNourriture(Double prixNourriture) {
	this.prixNourriture = prixNourriture;
}
public Double getPrixHotel() {
	return prixHotel;
}
public void setPrixHotel(Double prixHotel) {
	this.prixHotel = prixHotel;
}
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

public Voyage() {
	super();
	// TODO Auto-generated constructor stub
}
public Voyage(Long id, String nomVoyage, Hotel hotel, VolCompany volCompany, Date deteDebut, Date detefin,
		String description, String destination, String url, Double prix, Double autre, Double prixNourriture,
		Double prixHotel, String etat) {
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
	this.autre = autre;
	this.prixNourriture = prixNourriture;
	this.prixHotel = prixHotel;
	this.etat = etat;
}
@Override
public String toString() {
	return "Voyage [id=" + id + ", nomVoyage=" + nomVoyage + ", hotel=" + hotel + ", volCompany=" + volCompany
			+ ", deteDebut=" + deteDebut + ", detefin=" + detefin + ", Description=" + Description + ", destination="
			+ destination + ", Url=" + Url + ", prix=" + prix + ", autre=" + autre + ", prixNourriture="
			+ prixNourriture + ", prixHotel=" + prixHotel + ", etat=" + etat + "]";
}


}

