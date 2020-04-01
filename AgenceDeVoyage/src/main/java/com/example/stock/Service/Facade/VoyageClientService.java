package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.VoyageClient;

public interface VoyageClientService {
	Optional<VoyageClient> findById(Long id);
	VoyageClient findByVoyageNomVoyage(String nom);
	//VoyageClient findByClientEmail(String email);
	void save(VoyageClient voyageClient);
	List<VoyageClient> findAll();
	public void deleteById(Long id);

}
