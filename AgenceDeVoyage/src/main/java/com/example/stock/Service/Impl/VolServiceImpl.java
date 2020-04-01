package com.example.stock.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Vol;
import com.example.stock.Service.Facade.VolService;
import com.example.stock.dao.VolDao;
@Service
public class VolServiceImpl implements VolService {

	@Autowired
	VolDao volDao;

	@Override
	public List<Vol> findByDestination(String destination) {
		return volDao.findByDestination(destination);
	}

	@Override
	public void deleteById(Long id) {
volDao.deleteById(id);		
	}

	@Override
	public Optional<Vol> findById(Long id) {
		return volDao.findById(id);
	}

	@Override
	public Vol findByDestinationAndId(String destination, Long id) {
		return volDao.findByDestinationAndId(destination, id);
	}


}
