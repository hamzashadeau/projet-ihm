package com.example.stock.Service.Facade;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Vol;

public interface VolService {
	List<Vol> findByDestination(String destination);
	void deleteById(Long id);
	Optional<Vol> findById(Long id);
	Vol findByDestinationAndId(String destination , Long id);
	List<Vol> findAll();
	void save(Vol vol);
	public List<Vol> findByDateDebut(LocalDate dateDebut);
	List<Vol> findByPrix(Double prix);
}
