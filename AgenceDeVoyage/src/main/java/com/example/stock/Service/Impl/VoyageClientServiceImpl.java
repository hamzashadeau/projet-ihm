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

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientVol;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.dao.ClientDao;
import com.example.stock.dao.VoyageClientdao;

@Service
public class VoyageClientServiceImpl implements VoyageClientService {

	@Autowired
	private VoyageClientdao voyageClientDao;
	@Autowired
	private ClientDao clientDao;

	@Override
	public Optional<VoyageClient> findById(Long id) {
		return voyageClientDao.findById(id);
	}

	@Override
	public VoyageClient findByVoyageNomVoyage(String nom) {
		return voyageClientDao.findByVoyageNomVoyage(nom);
	}

	

	@Override
	public void save(VoyageClient voyageClient) {
	//	clientDao.save(voyageClient.getClient());
		voyageClientDao.save(voyageClient);
	}

	@Override
	public List<VoyageClient> findAll() {
		return voyageClientDao.findAll();
	}
	@Override
	public void deleteById(Long id) {
		voyageClientDao.deleteById(id);
		}
	@Override
	public Double findByMonth(int month) {
		Double som = 0.0;
		List<VoyageClient> clients = findAll();
		List<VoyageClient> resultats = new ArrayList<VoyageClient>();
		for (VoyageClient clientVol : clients) {
			if((clientVol.getDate().getMonth()+1) == month) {
				som+=clientVol.getVoyage().getPrix();
				resultats.add(clientVol);
			}
		}
		return som;
	}

	@Override
	public List<VoyageClient> findByCodeClient(String codeClient) {
		List<VoyageClient> clients = findAll();
		List<VoyageClient> resulatats = new ArrayList<VoyageClient>();
		for (VoyageClient voyageClient : clients) {
			if(voyageClient.getCodeClient()!= null && voyageClient.getCodeClient().equals(codeClient))
				resulatats.add(voyageClient);
		}
		return resulatats;
	}

	@Override
	public List<VoyageClient> findByNomVoyage(String nomVoyage) {
		List<VoyageClient> clients = findAll();
		List<VoyageClient> resulatats = new ArrayList<VoyageClient>();
		for (VoyageClient voyageClient : clients) {
			if(voyageClient.getNomVoyage()!= null &&voyageClient.getNomVoyage().equals(nomVoyage))
				resulatats.add(voyageClient);
		}
		return resulatats;
	}
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	@Override
	public List<VoyageClient> findByDate(LocalDate date) {
		List<VoyageClient> clients = findAll();
		List<VoyageClient> resulatats = new ArrayList<VoyageClient>();
		for (VoyageClient voyageClient : clients) {
			if(voyageClient.getDate()!= null) {
					if(convertToLocalDateViaMilisecond(voyageClient.getDate()).equals(date))
							resulatats.add(voyageClient);
			}
			System.out.println(resulatats);
		}
		return resulatats;
	}
//		System.out.println(date);
}
