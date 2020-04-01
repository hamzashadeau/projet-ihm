package com.example.stock.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.VoyageClient;
@Repository
public interface VoyageClientdao extends JpaRepository<VoyageClient, Long> {
	Optional<VoyageClient> findById(Long id);
	VoyageClient findByVoyageNomVoyage(String nom);
	//VoyageClient findByClientEmail(String email);
//	List<Client> findByVoyageId(Long id);
	public void deleteById(Long id);
}
