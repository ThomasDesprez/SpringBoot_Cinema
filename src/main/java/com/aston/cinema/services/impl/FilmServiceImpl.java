package com.aston.cinema.services.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Film;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.FilmRepository;
import com.aston.cinema.services.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepo;

	@Autowired
	private SeanceServiceImpl serviceSeance;

	@Override
	public List<Film> findAll() {
		return this.filmRepo.findAll();
	}

	@Override
	public Optional<Film> findById(String id) {
		return this.filmRepo.findById(id);
	}

	@Override
	public Film update(Film film) {
		return this.filmRepo.save(film);
	}

	@Override
	public void delete(String id) {
		this.filmRepo.deleteById(id);
	}

	@Override
	public Film save(Film film) {
		return this.filmRepo.save(film);
	}

	@Override
	public Film findByTitre(String titre) {
		return this.filmRepo.findByTitre(titre);
	}

	@Override
	public List<Film> findAllByGenre(String genre) {
		return this.filmRepo.findAllByGenre(genre);
	}

	@Override
	public int findRecetteById(String id) {
		int recette = 0;
		Optional<Film> optFilm = this.findById(id);
		if (optFilm.isPresent()) {
			Film film = optFilm.get();
			Stream<Seance> seances = serviceSeance.findAllByFilmId(film.getId()).stream();
			recette = seances.mapToInt(seance -> this.serviceSeance.findRecetteBySeance(seance)).sum();
		}
		return recette;
	}
}
