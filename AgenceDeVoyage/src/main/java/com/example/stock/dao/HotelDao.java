package com.example.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Hotel;
@Repository
public interface HotelDao extends JpaRepository<Hotel, Long> {
	Optional<Hotel> findById(Long id);
	List<Hotel> findByNom(String nom);
	List<Hotel> findAll();
}
