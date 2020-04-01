package com.example.stock.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Voyage;
@Repository
public interface VoyageDao extends JpaRepository<Voyage, Long> {
Voyage findByNomVoyage(String nomVoyage);
Voyage findByVolCompanyNom(String nom);
List<Voyage> findByHotelNom(String nom);
List<Voyage> findByDestination(String destination);
List<Voyage> findByDestinationAndDeteDebutAndDetefin(String destination,LocalDate debut,LocalDate fin);	
void deleteById(Long id);
Optional<Voyage> findById(Long id);

}
