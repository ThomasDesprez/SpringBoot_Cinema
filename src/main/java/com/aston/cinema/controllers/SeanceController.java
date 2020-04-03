package com.aston.cinema.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.cinema.dto.SeanceDTO;
import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Seance;
import com.aston.cinema.models.SeanceLight;
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
		return this.seanceService.findNombrePlacesById(id);
	}

	@GetMapping("horaire/{début}/{fin}")
	public List<Seance> findAllByHoraires(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime début
			, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
		return this.seanceService.findAllByHoraires(début, fin);
	}

	@PostMapping("{id}/assister/{uid}")
	public SeanceLight saveAssister(@PathVariable String id, @PathVariable String uid) {
		return this.seanceService.saveAssister(id,uid);
	}
	
	@GetMapping("film/{id}")
	public List<Seance> findAllByFilmId(@PathVariable String id) {
		return this.seanceService.findAllByFilmId(id);
	}
	
	@GetMapping("clients")
	public List<Assister> findAllClients() {
		return this.seanceService.findAllClients();
	}
	
	@GetMapping("criteres")
	public List<Seance> findAllByCriterias(@RequestBody SeanceDTO criteres) {
		return this.seanceService.findAllByCriterias(criteres);
	}
}
