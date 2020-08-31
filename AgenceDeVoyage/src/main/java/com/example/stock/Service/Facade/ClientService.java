package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Voyage;

public interface ClientService {
	Optional<Client> findById(Long id);
	Client findByNom(String nom);
	Client findByPrenom(String prenom);
	Client findByEmail(String email);
//	List<Client> findByVoyageId(Long id);
	int save(Client client);
	Client findByCodeClient(String codeClient);
}
