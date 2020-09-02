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
public class FactureVol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numeroFacture;
	private String nom;
	private String prenom;
	private String email;
	private int age;
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
	@ManyToOne
	private VolCompany volCompany;
	private double prix;
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
	
	public FactureVol() {
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
	public VolCompany getVolCompany() {
		return volCompany;
	}
	public void setVolCompany(VolCompany volCompany) {
		this.volCompany = volCompany;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
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
	public FactureVol(Long id, String numeroFacture, String nom, String prenom, String email, int age, String gender,
			String telephone, String codeClient, String destination, Date dateDebut, Date dateDeRetour,
			VolCompany volCompany, double prix, String userfirstName, String userlasName, Date date, Long iDVol) {
		super();
		this.id = id;
		this.numeroFacture = numeroFacture;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.codeClient = codeClient;
		this.destination = destination;
		this.dateDebut = dateDebut;
		this.dateDeRetour = dateDeRetour;
		this.volCompany = volCompany;
		this.prix = prix;
		this.userfirstName = userfirstName;
		this.userlasName = userlasName;
		this.date = date;
		this.iDVol = iDVol;
	}
	@Override
	public String toString() {
		return "FactureVol [id=" + id + ", numeroFacture=" + numeroFacture + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", age=" + age + ", gender=" + gender + ", telephone=" + telephone
				+ ", codeClient=" + codeClient + ", destination=" + destination + ", dateDebut=" + dateDebut
				+ ", dateDeRetour=" + dateDeRetour + ", volCompany=" + volCompany + ", prix=" + prix
				+ ", userfirstName=" + userfirstName + ", userlasName=" + userlasName + ", date=" + date + ", iDVol="
				+ iDVol + "]";
	}
	


	
	

	
	
	
	
	

	
}
