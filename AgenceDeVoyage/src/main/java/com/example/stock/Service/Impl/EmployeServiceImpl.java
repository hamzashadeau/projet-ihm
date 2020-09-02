package com.example.stock.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Employe;
import com.example.stock.Service.Facade.EmployeService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.dao.EmployeDao;

import javafx.collections.ObservableList;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeDao employeDao;
	private VoyageService voyageService;

	@Override
	public Optional<Employe> findById(Long id) {
		return employeDao.findById(id);
	}

	@Override
	public List<Employe> findByNom(String nom) {
		return employeDao.findByNom(nom);
	}

	@Override
	public List<Employe> findByPrenom(String prenom) {
		return employeDao.findByPrenom(prenom);
	}

	@Override
	public Employe findByEmail(String email) {
		return employeDao.findByEmail(email);
	}

	/*@Override
	public List<Client> findByVoyageId(Long id) {
		return clientDao.findByVoyageId(id);
	}*/

	@Override
	public int save(Employe employe) {
employeDao.save(employe);
		return 1;
	}

	@Override
	public Employe findByCodeEmploye(String codeEmploye) {
		return employeDao.findByCodeEmploye(codeEmploye);
	}

	@Override
	public List<Employe> findAll() {
		return employeDao.findAll();
	}


	@Override
	public List<Employe> findByCin(String cin) {
		return employeDao.findByCin(cin);
	}
	}

