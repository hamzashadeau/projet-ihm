package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;

public interface ClientVolService {
	Optional<ClientVol> findById(Long id);
	ClientVol findByNom(String nom);
	ClientVol findByPrenom(String prenom);
	ClientVol findByEmail(String email);
	List<ClientVol> findByVolId(Long id);
	int save(ClientVol client);
	List<ClientVol> findAll();
	public void deleteById(Long id);

}
