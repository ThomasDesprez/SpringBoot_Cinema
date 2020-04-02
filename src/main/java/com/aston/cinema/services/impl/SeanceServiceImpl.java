package com.aston.cinema.services.impl;

import java.time.LocalDateTime;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aston.cinema.dto.CinemaDTO;
import com.aston.cinema.models.Assister;
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
	private CinemaServiceImpl cinemaService;
	@Autowired
	private AssisterServiceImpl assisterService;

	@Autowired
	private FilmServiceImpl filmService;

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
		return this.save(seance);
	}

	@Override
	public void delete(String id) {
		this.seancerepo.deleteById(id);
	}

	@Override
	public Seance save(Seance seance) {
		CinemaDTO cinemaDTO = new CinemaDTO();
		cinemaDTO.setCinema(seance.getSalle().getCinema());
		cinemaDTO.getSalles().add(seance.getSalle());
		this.cinemaService.save(cinemaDTO);
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
	public int findRecetteBySeance(Seance seance) {
		int recetteSeance = 0;
		for (Assister client : seance.getClients()) {
			recetteSeance += client.getPrix();
		}
		return recetteSeance;
	}

	@Override
	public int findPlacesById(String id) {
		return 0;
	}

	@Override
	public List<Seance> findAllByHoraires(LocalDateTime début, LocalDateTime fin) {
		return this.seancerepo.findAllByDateBetween(début, fin);
	}

	@Override
	public List<Seance> findAllByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seance saveAssister(String id, String uid) {
		Optional<Seance> Optseance = this.findById(id);
		if (Optseance.isPresent()) {
			Seance seance = Optseance.get();
			Assister client = this.assisterService.createAssister(seance.getType(), uid);
			seance.getClients().add(client);
			this.seancerepo.save(seance);
			return seance;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La séance n'existe pas !");
		}
	}

	@Override
	public int findRecetteById(String id) {
		Optional<Seance> Optseance = this.findById(id);
		if (Optseance.isPresent()) {
			return this.findRecetteBySeance(Optseance.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le film n'existe pas !");
		}
	}

	@Override
	public List<Seance> findAllByFilmId(String id) {
		return this.seancerepo.findAllByFilmId(id);
	}
}
