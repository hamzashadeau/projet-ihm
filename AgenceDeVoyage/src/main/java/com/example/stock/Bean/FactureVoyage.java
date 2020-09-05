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
public class FactureVoyage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numeroFacture;
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private String nomVolCompany;
	private String nomHotel;
	private String gender;
	private String telephone;
	private String codeClient;
	private String destination;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	private Date dateDeRetour;
	private Double prix;
	private Double autre;
	private Double prixNourriture;
	private Double prixHotel;
	private String userfirstName;
	private String userlasName;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Long iDVol;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public FactureVoyage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public Long getiDVol() {
		return iDVol;
	}
	public void setiDVol(Long iDVol) {
		this.iDVol = iDVol;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}
	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
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
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getUserfirstName() {
		return userfirstName;
	}
	public void setUserfirstName(String userfirstName) {
		this.userfirstName = userfirstName;
	}
	public String getUserlasName() {
		return userlasName;
	}
	public void setUserlasName(String userlasName) {
		this.userlasName = userlasName;
	}
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
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public void setVolCompany(String nomVolCompany) {
		this.nomVolCompany = nomVolCompany;
	}
	public FactureVoyage(Long id, String numeroFacture, String nom, String prenom, String email, int age,
			String nomVolCompany, String nomHotel, String gender, String telephone, String codeClient, String destination,
			Date dateDebut, Date dateDeRetour, Double prix, Double autre, Double prixNourriture, Double prixHotel,
			String userfirstName, String userlasName, Date date, Long iDVol) {
		super();
		this.id = id;
		this.numeroFacture = numeroFacture;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.nomVolCompany = nomVolCompany;
		this.nomHotel = nomHotel;
		this.gender = gender;
		this.telephone = telephone;
		this.codeClient = codeClient;
		this.destination = destination;
		this.dateDebut = dateDebut;
		this.dateDeRetour = dateDeRetour;
		this.prix = prix;
		this.autre = autre;
		this.prixNourriture = prixNourriture;
		this.prixHotel = prixHotel;
		this.userfirstName = userfirstName;
		this.userlasName = userlasName;
		this.date = date;
		this.iDVol = iDVol;
	}
	@Override
	public String toString() {
		return "FactureVoyage [id=" + id + ", numeroFacture=" + numeroFacture + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", age=" + age + ", nomVolCompany=" + nomVolCompany + ", nomHotel=" + nomHotel
				+ ", gender=" + gender + ", telephone=" + telephone + ", codeClient=" + codeClient + ", destination="
				+ destination + ", dateDebut=" + dateDebut + ", dateDeRetour=" + dateDeRetour + ", prix=" + prix
				+ ", autre=" + autre + ", prixNourriture=" + prixNourriture + ", prixHotel=" + prixHotel
				+ ", userfirstName=" + userfirstName + ", userlasName=" + userlasName + ", date=" + date + ", iDVol="
				+ iDVol + "]";
	}
	public String getNomVolCompany() {
		return nomVolCompany;
	}
	public void setNomVolCompany(String nomVolCompany) {
		this.nomVolCompany = nomVolCompany;
	}
	

	


	
	

	
	
	
	
	

	
}
