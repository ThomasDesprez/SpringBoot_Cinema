package com.aston.cinema.services;

import java.util.List;
import java.util.Optional;

import com.aston.cinema.models.Film;

public interface FilmService {

	public List<Film> findAll();

	public Optional<Film> findById(String id);

	public Film update(Film film);

	public void delete(String id);

	public Film save(Film film);
	
	public Film findByTitre(String titre);
	
	public List<Film> findAllByGenre(String genre);

	public int findRecetteById(String id);
	
}
