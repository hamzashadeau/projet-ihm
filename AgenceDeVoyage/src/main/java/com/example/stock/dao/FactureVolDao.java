package com.example.stock.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.FactureVol;
@Repository
public interface FactureVolDao extends JpaRepository<FactureVol, Long> {
	Optional<FactureVol> findById(Long id);
	FactureVol findByNom(String nom);
	FactureVol findByPrenom(String prenom);
	FactureVol findByEmail(String email);
	public void deleteById(Long id);
	List<FactureVol> findByCodeClient(String codeClient);
	List<FactureVol> findByDate(LocalDate date);
	List<FactureVol> findByNumeroFacture(String numeroFacture);
}
