package com.example.stock.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lasName;
	private String adress;
	private String gender;
	private int age;
	private String login;
	private String motDePass;
	
	@OneToMany
	private List<Voyage> voyages = new ArrayList<Voyage>();
	@OneToMany
	private List<Vol> vols = new ArrayList<Vol>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasName() {
		return lasName;
	}

	public void setLasName(String lasName) {
		this.lasName = lasName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Voyage> getVoyages() {
		return voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePass() {
		return motDePass;
	}
	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public User(Long id, String firstName, String lasName, String adress, String gender, int age, String login,
			String motDePass, List<Voyage> voyages, List<Vol> vols) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasName = lasName;
		this.adress = adress;
		this.gender = gender;
		this.age = age;
		this.login = login;
		this.motDePass = motDePass;
		this.voyages = voyages;
		this.vols = vols;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lasName=" + lasName + ", adress=" + adress
				+ ", gender=" + gender + ", age=" + age + ", login=" + login + ", motDePass=" + motDePass + ", voyages="
				+ voyages + ", vols=" + vols + "]";
	}
	

}
