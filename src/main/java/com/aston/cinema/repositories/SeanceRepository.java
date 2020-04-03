package com.aston.cinema.repositories;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Salle;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.custom.SeanceRepositoryCustom;


public interface SeanceRepository extends MongoRepository<Seance, String>, SeanceRepositoryCustom {


	public List<Seance> findAllByType(String type);

	public List<Seance> findAll();
	
	public Seance findByFilm(Film film);
	
	public Seance findByDate(LocalDateTime date);
	
	public Seance findBySalle(Salle salle);
	
	public List<Seance> findAllByDateBetween(LocalDateTime début,LocalDateTime fin);
	
	public List<Seance> findAllByFilm(Film film); 
	
	public List<Seance> findAllByFilmId(String id); 
	
	public int findBySallePlace(Salle salle);
	
	public List<Assister> findByClients();

	public int findSallePlaceById(String id);

	public List<Seance> findByFilmTitreLike(String nom);
	
}
