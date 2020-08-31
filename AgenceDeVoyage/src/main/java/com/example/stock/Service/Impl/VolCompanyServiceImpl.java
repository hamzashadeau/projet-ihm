package com.example.stock.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.VolCompany;
import com.example.stock.Service.Facade.VolCompanyService;
import com.example.stock.dao.VolCompanyDao;
@Service
public class VolCompanyServiceImpl implements VolCompanyService {

	@Autowired
	VolCompanyDao VolCompanyDao;

	@Override
	public Optional<VolCompany> findById(long id) {
		return VolCompanyDao.findById(id);
	}

	@Override
	public List<VolCompany> findByNom(String nom) {
		return VolCompanyDao.findByNom(nom);
	}

	@Override
	public void save(VolCompany volCompany) {
		VolCompanyDao.save(volCompany);
	}

	@Override
	public List<VolCompany> findAll() {
		return VolCompanyDao.findAll();
	}


	@Override
	public void deleteById(Long id) {
		 VolCompanyDao.deleteById(id);;

	}

	
	
}
