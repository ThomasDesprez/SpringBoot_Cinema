package com.aston.cinema.repositories.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.aston.cinema.dto.SeanceDTO;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.custom.SeanceRepositoryCustom;

public class SeanceRepositoryCustomImpl implements SeanceRepositoryCustom {

	@Autowired
	private MongoTemplate template;

	@Override
	public List<Seance> findAllByCriterias(SeanceDTO criteres) {
		System.out.println("TEST\n" + criteres.getGenreFilm() + ": " + criteres.getAgeLimite());
		Query getFilms = new Query();
		if (criteres.getGenreFilm() != null) {
			getFilms.addCriteria(Criteria.where("genre").is(criteres.getGenreFilm()));
		}
		if (criteres.getAgeLimite() > 2) {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			getFilms.addCriteria(Criteria.where("ageLimite").lte(criteres.getAgeLimite()));
		}
		List<Film> films = new ArrayList<Film>();
		films = this.template.find(getFilms, Film.class);

		Query query = new Query();
		if (!criteres.getTypeSeance().isEmpty()) {
			query.addCriteria(Criteria.where("type").in(criteres.getTypeSeance()));
		}
		if (!films.isEmpty()) {
			query.addCriteria(Criteria.where("film").in(films));
		}
		if (criteres.getDébut() != null && criteres.getFin() != null) {
			query.addCriteria(Criteria.where("date").gte(criteres.getDébut()).and("date").lt(criteres.getFin()));
		}
		return this.template.find(query, Seance.class);
	}
}