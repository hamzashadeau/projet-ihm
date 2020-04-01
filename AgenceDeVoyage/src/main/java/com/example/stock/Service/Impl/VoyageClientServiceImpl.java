package com.example.stock.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Voyage;
import com.example.stock.Bean.VoyageClient;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.VoyageClientService;
import com.example.stock.Service.Facade.VoyageService;
import com.example.stock.dao.ClientDao;
import com.example.stock.dao.VoyageClientdao;

@Service
public class VoyageClientServiceImpl implements VoyageClientService {

	@Autowired
	private VoyageClientdao voyageClientDao;
	@Autowired
	private ClientDao clientDao;

	@Override
	public Optional<VoyageClient> findById(Long id) {
		return voyageClientDao.findById(id);
	}

	@Override
	public VoyageClient findByVoyageNomVoyage(String nom) {
		return voyageClientDao.findByVoyageNomVoyage(nom);
	}

	

	@Override
	public void save(VoyageClient voyageClient) {
	//	clientDao.save(voyageClient.getClient());
		voyageClientDao.save(voyageClient);
	}

	@Override
	public List<VoyageClient> findAll() {
		return voyageClientDao.findAll();
	}
	@Override
	public void deleteById(Long id) {
		voyageClientDao.deleteById(id);
		}
}
