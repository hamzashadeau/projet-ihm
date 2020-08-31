package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.VolCompany;

public interface VolCompanyService {
	List<VolCompany> findByNom(String nom);
	void save(VolCompany volCompany);
	List<VolCompany> findAll();
    void deleteById(Long id);
	Optional<VolCompany> findById(long id);

	
}
