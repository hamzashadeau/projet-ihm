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

import com.example.stock.Bean.Vol;
import com.example.stock.Bean.Voyage;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.dao.VoyageDao;
@Service
public class VoyageServiceImpl implements VoyageService {

	@Autowired
	VoyageDao voyageDao;


	@Override
	public Voyage findByNomVoyage(String nomVoyage) {
		return voyageDao.findByNomVoyage(nomVoyage);
	}

	

	@Override
	public Voyage findByVolCompanyNom(String nom) {
		return voyageDao.findByVolCompanyNom(nom);
	}

	@Override
	public List<Voyage> findByHotelNom(String nom) {
		return voyageDao.findByHotelNom(nom);
	}

	@Override
	public void save(Voyage voyage) {
		voyageDao.save(voyage);		
	}

	@Override
	public List<Voyage> findAll() {
		return voyageDao.findAll();
	}

	@Override
	public List<Voyage> findByDestination(String destination) {
		return voyageDao.findByDestination(destination);
	}

	@Override
	public List<Voyage> findByDestinationAndDeteDebutAndDateFin(String destination, LocalDate debut, LocalDate fin) {
		return voyageDao.findByDestinationAndDeteDebutAndDetefin(destination, debut, fin);
	}

	@Override
	public Optional<Voyage> findById(Long id) {
		return voyageDao.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 voyageDao.deleteById(id);
	}



	@Override
	public List<Voyage> findByPrix(Double prix) {
		return voyageDao.findByPrix(prix);
	}

	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	@Override
	public List<Voyage> findByDateDebut(LocalDate dateDebut) {
		List<Voyage> clients = findAll();
		List<Voyage> resulatats = new ArrayList<Voyage>();
		for (Voyage voyageClient : clients) {
			if(voyageClient.getDeteDebut()!= null) {
					if(convertToLocalDateViaMilisecond(voyageClient.getDeteDebut()).equals(dateDebut))
							resulatats.add(voyageClient);
			}
		}
		return resulatats;
	//	return volDao.findByDateDebut(dateDebut);
	}
	
}
