package com.example.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Employe;

import javafx.collections.ObservableList;
@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {
	Optional<Employe> findById(Long id);
	List<Employe> findByNom(String nom);
	List<Employe> findByPrenom(String prenom);
	Employe findByEmail(String email);
	Employe findByCodeEmploye(String codeEmploye);
//	List<Client> findByVoyageId(Long id);
	List<Employe> findByCin(String cin);
	List<Employe> findByGender(String gender);
}
