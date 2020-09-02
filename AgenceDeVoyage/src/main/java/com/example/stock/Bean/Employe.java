package com.example.stock.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codeEmploye;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private String gender;
	private String telephone;
	private String adress;
	
	public Employe(Long id, String codeEmploye, String cin, String nom, String prenom, String email, int age,
			String gender, String telephone, String adress) {
		super();
		this.id = id;
		this.codeEmploye = codeEmploye;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.telephone = telephone;
		this.adress = adress;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(String codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", codeEmploye=" + codeEmploye + ", cin=" + cin + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", age=" + age + ", gender=" + gender + ", telephone=" + telephone
				+ ", adress=" + adress + "]";
	}
	
	
}
