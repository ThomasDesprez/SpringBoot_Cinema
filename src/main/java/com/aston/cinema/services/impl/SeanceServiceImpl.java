package com.aston.cinema.services.impl;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aston.cinema.dto.SeanceDTO;
import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Salle;
import com.aston.cinema.models.Seance;
import com.aston.cinema.models.SeanceLight;
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
		return this.seancerepo.findByClients();
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
	public int findNombrePlacesById(String id) {
		int nbPlaces = 0;
		Optional<Seance> s = this.findById(id);
		if (s.isPresent()) {
			nbPlaces = s.get().getSalle().getPlace();
		}
		return nbPlaces;
	}

	@Override
	public List<Seance> findAllByHoraires(LocalDateTime début, LocalDateTime fin) {
		return this.seancerepo.findAllByDateBetween(début, fin);
	}


	@Override
	public SeanceLight saveAssister(String id, String uid) {
		Optional<Seance> Optseance = this.findById(id);
		if (Optseance.isPresent()) {
			Seance seance = Optseance.get();

			if (seance.getClients().size() >= seance.getSalle().getPlace())
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, "La séance n°" + id + " est pleine!");
			Assister client = this.assisterService.createAssister(seance, uid);
			seance.getClients().add(client);
			this.seancerepo.save(seance);
			return new SeanceLight(seance, client);
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

	@Override
	public List<Seance> findAllByCriterias(SeanceDTO criteres) {
		return this.seancerepo.findAllByCriterias(criteres);
	}
}
