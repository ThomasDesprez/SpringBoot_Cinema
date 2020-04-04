/**
 * 
 */
package com.aston.cinema.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Commentaire;
import com.aston.cinema.repositories.CommentaireRepository;

/**
 * @author Thomas
 *
 */
@Service
public class CommentaireServiceImpl {

	@Autowired
	private CommentaireRepository repo;

	public List<Commentaire> findAll() {
		return this.repo.findAll();
	}

	public Optional<Commentaire> findById(String id) {
		return this.repo.findById(id);
	}

	public Commentaire update(Commentaire Commentaire) {
		return this.repo.save(Commentaire);
	}

	public void delete(String id) {
		this.repo.deleteById(id);
	}

	public Commentaire save(Commentaire Commentaire) {
		return this.repo.save(Commentaire);
	}

	public List<Commentaire> findAllByFilmId(String id) {
		return this.repo.findAllByFilmId(id);
	}

}
