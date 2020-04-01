package com.example.stock.Service.Facade;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Voyage;

public interface VoyageService {
	Optional<Voyage> findById(Long id);
	Voyage findByNomVoyage(String nomVoyage);
	Voyage findByVolCompanyNom(String nom);
	List<Voyage> findByHotelNom(String nom);
	void save(Voyage voyage);
	List<Voyage> findAll();
	List<Voyage> findByDestination(String destination);
    List<Voyage> findByDestinationAndDeteDebutAndDateFin(String destination,LocalDate datedebut,LocalDate datefin);	
	void deleteById(Long id);

}
