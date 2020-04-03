package com.aston.cinema.repositories.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.aston.cinema.dto.SeanceDTO;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.custom.SeanceRepositoryCustom;

public class SeanceRepositoryCustomImpl implements SeanceRepositoryCustom {

	@Autowired
	private MongoTemplate template;

	@Override
	public List<Seance> findAllByCriterias(SeanceDTO criteres) {

		List<Seance> seances = new ArrayList<Seance>();
		Query query = new Query();
		// where("").in(listOfAge)
		if (criteres.getGenreFilm() != null) {
			System.out.println("GENRE FILM : " + criteres.getGenreFilm());
			// query.addCriteria(Criteria.where("film.Film.$id.genre").is(criteres.getGenreFilm()));
		}
		if (criteres.getDébut() != null && criteres.getFin() != null) {
			query.addCriteria(Criteria.where("date").gte(criteres.getDébut()).lt(criteres.getFin()));
		}
		System.out.println(query.fields().toString());
		System.out.println(query.fields().getFieldsObject().toJson());

		return this.template.find(query, Seance.class);
	}
}

//query = new Query();
//Criteria first = Criteria.where("qty").elemMatch(Criteria.where("size").is("M").and("num").gt(50));
//Criteria two = Criteria.where("qty").elemMatch(Criteria.where("num").is(100).and("color").is("green"));
//query.addCriteria(new Criteria().andOperator(first, two));