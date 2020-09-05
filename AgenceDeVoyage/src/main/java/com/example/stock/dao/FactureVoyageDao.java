package com.example.stock.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.FactureVol;
import com.example.stock.Bean.FactureVoyage;
@Repository
public interface FactureVoyageDao extends JpaRepository<FactureVoyage, Long> {
	Optional<FactureVoyage> findById(Long id);
	FactureVoyage findByNom(String nom);
	FactureVoyage findByPrenom(String prenom);
	FactureVoyage findByEmail(String email);
	public void deleteById(Long id);
	List<FactureVoyage> findByCodeClient(String codeClient);
	List<FactureVoyage> findByDate(LocalDate date);
	List<FactureVoyage> findByNumeroFacture(String numeroFacture);
}
