package com.example.stock.Service.Impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.ClientVol;
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

	@Override
	public List<Vol> findAll() {
		return volDao.findAll();
	}

	@Override
	public void save(Vol vol) {
		this.volDao.save(vol);		
	}
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	@Override
	public List<Vol> findByDateDebut(LocalDate dateDebut) {
		List<Vol> clients = findAll();
		List<Vol> resulatats = new ArrayList<Vol>();
		for (Vol voyageClient : clients) {
			if(voyageClient.getDateDebut()!= null) {
					if(convertToLocalDateViaMilisecond(voyageClient.getDateDebut()).equals(dateDebut))
							resulatats.add(voyageClient);
			}
			System.out.println(resulatats);
		}
		return resulatats;
	//	return volDao.findByDateDebut(dateDebut);
	}

	@Override
	public List<Vol> findByPrix(Double prix) {
		return volDao.findByPrix(prix);
	}


}
