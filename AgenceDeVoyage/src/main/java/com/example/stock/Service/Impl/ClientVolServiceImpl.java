package com.example.stock.Service.Impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientVolService;
import com.example.stock.dao.ClientVolDao;

@Service
public class ClientVolServiceImpl implements ClientVolService {

	@Autowired
	private ClientVolDao clientVolDao;
	@Override
	public Optional<ClientVol> findById(Long id) {
		return clientVolDao.findById(id);
	}
	@Override
	public ClientVol findByNom(String nom) {
		return clientVolDao.findByNom(nom);
	}
	@Override
	public ClientVol findByPrenom(String prenom) {
		return clientVolDao.findByPrenom(prenom);
	}
	@Override
	public ClientVol findByEmail(String email) {
		return clientVolDao.findByEmail(email);
	}
	
	@Override
	public int save(ClientVol client) {
		clientVolDao.save(client);
		return 0;
	}
	@Override
	public List<ClientVol> findAll() {
		return clientVolDao.findAll();
	}
	@Override
	public void deleteById(Long id) {
		clientVolDao.deleteById(id);
		}
	@Override
	public List<ClientVol> findByMonth(int month) {
		List<ClientVol> clients = findAll();
		List<ClientVol> resultats = new ArrayList<ClientVol>();
		for (ClientVol clientVol : clients) {
			if((clientVol.getDate().getMonth()+1) == month)
				resultats.add(clientVol);
		}
		return resultats;
	}
	@Override
	public List<ClientVol> findByCodeClient(String codeClient) {
		return clientVolDao.findByCodeClient(codeClient);
	}
	@Override
	public List<ClientVol> findByVolId(Long id) {
		return clientVolDao.findByVolId(id);
	}
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	@Override
	public List<ClientVol> findByDate(LocalDate date) {
		List<ClientVol> clients = findAll();
		List<ClientVol> resulatats = new ArrayList<ClientVol>();
		for (ClientVol voyageClient : clients) {
			if(voyageClient.getDate()!= null) {
				System.out.println(date);
				System.out.println(convertToLocalDateViaMilisecond(voyageClient.getDate()));
					if(convertToLocalDateViaMilisecond(voyageClient.getDate()).equals(date))
							resulatats.add(voyageClient);
			}
			System.out.println(resulatats);
		}
		return resulatats;
	}
	
	

	}

