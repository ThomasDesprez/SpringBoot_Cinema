package com.aston.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aston.cinema.models.Cinema;
import com.aston.cinema.models.Salle;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.CinemaRepository;
import com.aston.cinema.repositories.SalleRepository;
import com.aston.cinema.repositories.SeanceRepository;

@RestController
@CrossOrigin
public class testController {

	@Autowired
	private CinemaRepository cinemarepo;
	
	@Autowired
	private SalleRepository sallerepo;

	@GetMapping("test/cines")
	public List<Cinema> findAllcines() {
		System.out.println("cines");
		return cinemarepo.findAll();
	}
	
	@GetMapping("test/salles")
	public List<Salle> findAllsalles() {
		System.out.println("salles");
		return sallerepo.findAll();
	}

}
