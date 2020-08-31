package com.example.stock.Service.Facade;

import java.util.List;
import java.util.Optional;

import com.example.stock.Bean.Hotel;

public interface HotelService {
	List<Hotel> findByNom(String nom);
	void save(Hotel hotel);
	List<Hotel> findAll();
    void deleteById(Long id);
	Optional<Hotel> findById(long id);
}
