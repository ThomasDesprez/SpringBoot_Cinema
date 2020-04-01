package com.aston.cinema.controllers;

import java.time.LocalDateTime;
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

import com.aston.cinema.models.Seance;
import com.aston.cinema.services.SeanceService;

@RestController
@CrossOrigin
@RequestMapping("seances")
public class SeanceController {

	@Autowired
	private SeanceService seanceService;

	@GetMapping("")
	public List<Seance> findAll() {
		return this.seanceService.findAll();
	}

	@PostMapping("")
	public Seance save(@RequestBody Seance Seance) {
		return this.seanceService.save(Seance);
	}

	@PutMapping("")
	public Seance update(@RequestBody Seance Seance) {
		return this.seanceService.update(Seance);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.seanceService.delete(id);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Seance Seance) {
		this.deleteById(Seance.getId());
	}

	@GetMapping("{id}")
	public Optional<Seance> findById(@PathVariable String id) {
		return this.seanceService.findById(id);
	}

	@GetMapping("{id}/recette")
	public int findRecetteById(@PathVariable String id) {
		return this.seanceService.findRecetteById(id);
	}

	@GetMapping("{id}/places")
	public int findPlacesById(@PathVariable String id) {
		return this.seanceService.findPlacesById(id);
	}

	@GetMapping("horaire/{min}/{max}")
	public List<Seance> findAllByHoraires(@PathVariable LocalDateTime début, @PathVariable LocalDateTime fin) {
		return this.seanceService.findAllByHoraires(début, fin);
	}

	@GetMapping("film/{nom}")
	public List<Seance> findAllByNom(String nom) {
		return this.seanceService.findAllByNom(nom);
	}

	@PostMapping("{id}/assister/{uid}")
	public void saveAssister(@PathVariable String id, @PathVariable String uid) {
		this.seanceService.saveAssister(id,uid);
	}
}
