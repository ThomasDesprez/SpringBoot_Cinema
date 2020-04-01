package com.aston.cinema.services.impl;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Client;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Salle;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.SeanceRepository;
import com.aston.cinema.services.SeanceService;

@Service
public class SeanceServiceImpl implements SeanceService {

	@Autowired
	private SeanceRepository seancerepo;
	
	@Autowired
	private AssisterServiceImpl assisterService;

	@Override
	public List<Seance> findAll() {
		return this.seancerepo.findAll();
	}

	@Override
	public Optional<Seance> findById(String id) {
		return this.seancerepo.findById(id);
	}

	@Override
	public Seance update(Seance seance) {
		return this.seancerepo.save(seance);
	}

	@Override
	public void delete(String id) {
		this.seancerepo.deleteById(id);
	}

	@Override
	public Seance save(Seance seance) {
		return this.seancerepo.save(seance);
	}

	@Override
	public Seance findByFilm(Film film) {
		return this.seancerepo.findByFilm(film);
	}

	@Override
	public Seance findByDate(LocalDateTime date) {
		return this.seancerepo.findByDate(date);
	}

	@Override
	public List<Assister> findAllClients() {
		return null;
	}

	@Override
	public Seance findBySalle(Salle salle) {
		return this.seancerepo.findBySalle(salle);
	}

	@Override
	public List<Seance> findAllByType(String type) {
		return this.seancerepo.findAllByType(type);
	}

	@Override
	public int findRecetteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findPlacesById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Seance> findAllByHoraires(LocalDateTime début, LocalDateTime fin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seance> findAllByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAssister(String id, String uid) {
			Client c = this.assisterService.findByClient(uid);
			
			
	}

}
