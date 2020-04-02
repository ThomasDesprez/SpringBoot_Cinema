package com.aston.cinema.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.dto.CinemaDTO;
import com.aston.cinema.repositories.CinemaRepository;
import com.aston.cinema.repositories.SalleRepository;
import com.aston.cinema.services.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinerepo;

	@Autowired
	private SalleRepository sallerepo;

	@Override
	public CinemaDTO save(CinemaDTO cinemadto) {
		this.cinerepo.save(cinemadto.getCinema());
		cinemadto.getSalles().forEach(salle -> this.sallerepo.save(salle));
		return cinemadto;
	}
}
