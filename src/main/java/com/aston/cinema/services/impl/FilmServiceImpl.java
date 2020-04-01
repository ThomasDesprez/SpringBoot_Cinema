package com.aston.cinema.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Film;
import com.aston.cinema.repositories.FilmRepository;
import com.aston.cinema.services.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepo;

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
		// TODO Auto-generated method stub
		return 0;
	}

}
