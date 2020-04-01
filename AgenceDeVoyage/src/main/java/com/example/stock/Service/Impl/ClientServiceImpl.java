package com.example.stock.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.dao.ClientDao;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	private VoyageService voyageService;

	@Override
	public Optional<Client> findById(Long id) {
		return clientDao.findById(id);
	}

	@Override
	public Client findByNom(String nom) {
		return clientDao.findByNom(nom);
	}

	@Override
	public Client findByPrenom(String prenom) {
		return clientDao.findByPrenom(prenom);
	}

	@Override
	public Client findByEmail(String email) {
		return clientDao.findByEmail(email);
	}

	/*@Override
	public List<Client> findByVoyageId(Long id) {
		return clientDao.findByVoyageId(id);
	}*/

	@Override
	public int save(Client client) {
clientDao.save(client);
		return 1;
	}
	}

