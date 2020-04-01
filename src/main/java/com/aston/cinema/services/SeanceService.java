package com.aston.cinema.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Salle;
import com.aston.cinema.models.Seance;

public interface SeanceService {

	public List<Seance> findAll();

	public Optional<Seance> findById(String id);

	public Seance update(Seance seance);

	public void delete(String id);

	public Seance save(Seance seance);

	public Seance findByDate(LocalDateTime date);

	public List<Assister> findAllClients();

	public Seance findBySalle(Salle salle);

	public List<Seance> findAllByType(String type);

	public Seance findByFilm(Film film);
	
	public int findRecetteById(String id);
	
	public int findPlacesById(String id);

	public List<Seance> findAllByHoraires(LocalDateTime début, LocalDateTime fin);

	public List<Seance> findAllByNom(String nom);

	public void saveAssister(String id, String uid);
	

}
