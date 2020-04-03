package com.aston.cinema.repositories;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Film;


public interface FilmRepository extends MongoRepository<Film, String> {

	public List<Film> findAllByTitre(String titre);
	
	public Film findByTitre(String titre);

	public List<Film> findAllByGenre(String genre);
	
	public Film findByVisa(String visa);
	
	public List<Film> findByTitreLike(String titre);
	

}
