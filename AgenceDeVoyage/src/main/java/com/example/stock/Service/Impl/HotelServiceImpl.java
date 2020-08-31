package com.example.stock.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Hotel;
import com.example.stock.Bean.User;
import com.example.stock.Service.Facade.HotelService;
import com.example.stock.Service.Facade.UserService;
import com.example.stock.dao.HotelDao;
import com.example.stock.dao.UserDao;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDao hotelDao;

	@Override
	public List<Hotel> findByNom(String nom) {
		return hotelDao.findByNom(nom);
	}

	@Override
	public void save(Hotel hotel) {
		hotelDao.save(hotel);
	}

	@Override
	public List<Hotel> findAll() {
		return hotelDao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		hotelDao.deleteById(id);
	}

	@Override
	public Optional<Hotel> findById(long id) {
		return hotelDao.findById(id);
	}

	
	
	
	}

