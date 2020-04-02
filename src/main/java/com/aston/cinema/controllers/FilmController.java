package com.aston.cinema.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.cinema.models.Film;
import com.aston.cinema.services.FilmService;

@RestController
@CrossOrigin
@RequestMapping("films")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping("")
	public List<Film> findAll(@RequestBody String s) {
		return this.filmService.findAll();
	}

	@PostMapping("")
	public Film save(@RequestBody Film film) {
		return this.filmService.save(film);
	}

	@PutMapping("")
	public Film update(@RequestBody Film film) {
		return this.filmService.update(film);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.filmService.delete(id);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Film film) {
		this.deleteById(film.getId());
	}
	
	@GetMapping("{id}")
	public Optional<Film> findById(@PathVariable String id) {
		return this.filmService.findById(id);
	}

	@GetMapping("{id}/recette")
	public int findRecetteById(@PathVariable String id) {
		return this.filmService.findRecetteById(id);
	}
	
	@GetMapping("genre/{genre}")
	public List<Film> findAllByGenre(@PathVariable String genre) {
		return this.filmService.findAllByGenre(genre);

	}

	@GetMapping("titre/{titre}")
	public Film findByTitre(@PathVariable String titre) {
		return this.filmService.findByTitre(titre);

	}

}
