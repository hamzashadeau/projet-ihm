package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Vol;

public interface VolService {
	List<Vol> findByDestination(String destination);
	void deleteById(Long id);
	Optional<Vol> findById(Long id);
	Vol findByDestinationAndId(String destination , Long id);
}
