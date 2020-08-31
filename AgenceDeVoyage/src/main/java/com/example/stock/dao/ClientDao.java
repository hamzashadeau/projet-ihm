package com.example.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Employe;
import com.example.stock.Bean.Hotel;
@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
	Optional<Client> findById(Long id);
	Client findByNom(String nom);
	Client findByPrenom(String prenom);
	Client findByEmail(String email);
//	List<Client> findByVoyageId(Long id);
	Client findByCodeClient(String codeClient);
}
