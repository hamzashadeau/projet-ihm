package com.example.stock.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.VolCompany;
@Repository
public interface VolCompanyDao extends JpaRepository<VolCompany, Long> {
	Optional<VolCompany> findById(Long id);
	VolCompany findByNom(String nom);
}
