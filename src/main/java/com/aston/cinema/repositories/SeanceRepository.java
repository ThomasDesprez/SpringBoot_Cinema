package com.aston.cinema.repositories;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Film;
import com.aston.cinema.models.Salle;
import com.aston.cinema.models.Seance;


public interface SeanceRepository extends MongoRepository<Seance, String> {


	public List<Seance> findAllByType(String type);

	public List<Seance> findAll();
	
	public Seance findByFilm(Film film);
	
	public Seance findByDate(LocalDateTime date);
	
	public Seance findBySalle(Salle salle);
	
	public List<Seance> findAllByDateBetween(LocalDateTime début,LocalDateTime fin);
	
	public List<Seance> findAllByFilm(Film film); 
	
	public List<Seance> findAllByFilmId(String id); 
	
	public int findBySallePlace(Salle salle);
	
}
