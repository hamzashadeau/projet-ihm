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
public class ClientVol {
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
	private Vol vol;
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
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	public ClientVol() {
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
	public ClientVol(Long id, String nom, String prenom, String email, int age, String gender, String telephone,
			String codeClient, Vol vol, Date date, Long iDVol) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.codeClient = codeClient;
		this.vol = vol;
		this.date = date;
		this.iDVol = iDVol;
	}
	@Override
	public String toString() {
		return "ClientVol [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", telephone=" + telephone + ", codeClient=" + codeClient + ", vol=" + vol
				+ ", date=" + date + ", iDVol=" + iDVol + "]";
	}
	
	

	
	
	
	
	

	
}
