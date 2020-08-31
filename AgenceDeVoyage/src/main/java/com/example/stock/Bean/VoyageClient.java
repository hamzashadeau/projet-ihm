package com.example.stock.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VoyageClient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private String gender;
	private String telephone;
	private String codeClient;
	@ManyToOne
	private Voyage voyage;
	private String nomVoyage;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public VoyageClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNomVoyage() {
		return nomVoyage;
	}

	public void setNomVoyage(String nomVoyage) {
		this.nomVoyage = nomVoyage;
	}

	public VoyageClient(Long id, String nom, String prenom, String email, int age, String gender, String telephone,
			String codeClient, Voyage voyage, String nomVoyage, Date date) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.codeClient = codeClient;
		this.voyage = voyage;
		this.nomVoyage = nomVoyage;
		this.date = date;
	}

	@Override
	public String toString() {
		return "VoyageClient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", telephone=" + telephone + ", codeClient=" + codeClient + ", voyage="
				+ voyage + ", nomVoyage=" + nomVoyage + ", date=" + date + "]";
	}



	
	

}
