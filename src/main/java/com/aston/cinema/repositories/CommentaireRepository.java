package com.aston.cinema.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Commentaire;

public interface CommentaireRepository extends MongoRepository<Commentaire, String>{

	public List<Commentaire> findAllByFilmId(String id);
}
