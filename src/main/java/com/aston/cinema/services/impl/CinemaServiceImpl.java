package com.aston.cinema.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.dto.CinemaDTO;
import com.aston.cinema.models.Cinema;
import com.aston.cinema.repositories.CinemaRepository;
import com.aston.cinema.repositories.SalleRepository;
import com.aston.cinema.services.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinerepo;

	@Autowired
	private SalleRepository sallerepo;

	/**
	 * Sauvegarde un cinéma et ses salles
	 * 
	 * @param cinemadto Cinema et salles a sauvegarder
	 * @return Cinema et salles sauvegardés
	 */
	@Override
	public CinemaDTO save(CinemaDTO cinemadto) {
		Cinema cine = cinemadto.getCinema();
		this.cinerepo.save(cine);
		cinemadto.getSalles().forEach(salle -> {
			salle.setCinema(cine);
			this.sallerepo.save(salle);
		});
		return cinemadto;
	}
}
