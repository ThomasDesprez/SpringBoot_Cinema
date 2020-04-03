package com.aston.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.cinema.dto.CinemaDTO;
import com.aston.cinema.services.impl.CinemaServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("cinemas")
public class CinemaController {

	@Autowired
	private CinemaServiceImpl cineService;

	@PostMapping("")
	public CinemaDTO save(@RequestBody CinemaDTO cinemaDTO) {
		return this.cineService.save(cinemaDTO);
	}
}
