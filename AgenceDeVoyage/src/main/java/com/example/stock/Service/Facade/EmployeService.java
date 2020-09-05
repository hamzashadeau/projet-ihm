package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Employe;

import javafx.collections.ObservableList;

public interface EmployeService {
	List<Employe> findAll();
	Optional<Employe> findById(Long id);
	List<Employe> findByNom(String nom);
	List<Employe> findByPrenom(String prenom);
	Employe findByEmail(String email);
//	List<Client> findByVoyageId(Long id);
	int save(Employe client);
	Employe findByCodeEmploye(String codeEmploye);
	List<Employe> findByCin(String cin);
	List<Employe> findByGender(String gender);

}
