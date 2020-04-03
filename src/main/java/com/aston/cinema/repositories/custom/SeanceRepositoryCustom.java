package com.aston.cinema.repositories.custom;

import java.util.List;

import com.aston.cinema.dto.SeanceDTO;
import com.aston.cinema.models.Seance;

public interface SeanceRepositoryCustom {

	public List<Seance> findAllByCriterias(SeanceDTO criteres);
}
