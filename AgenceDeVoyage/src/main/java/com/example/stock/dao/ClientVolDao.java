package com.example.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.ClientVol;
@Repository
public interface ClientVolDao extends JpaRepository<ClientVol, Long> {
	Optional<ClientVol> findById(Long id);
	ClientVol findByNom(String nom);
	ClientVol findByPrenom(String prenom);
	ClientVol findByEmail(String email);
	List<ClientVol> findByVolId(Long id);
	public void deleteById(Long id);

}
