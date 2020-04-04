package com.aston.cinema.services.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Commentaire;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.FilmRepository;
import com.aston.cinema.services.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepo;

	@Autowired
	private SeanceServiceImpl serviceSeance;

	@Autowired
	private CommentaireServiceImpl serviceCommentaire;

	@Override
	public List<Film> findAll() {
		return this.filmRepo.findAll();
	}

	@Override
	public Optional<Film> findById(String id) {
		return this.filmRepo.findById(id);
	}

	@Override
	public Film update(Film film) {
		return this.filmRepo.save(film);
	}

	@Override
	public void delete(String id) {
		this.filmRepo.deleteById(id);
	}

	@Override
	public Film save(Film film) {
		return this.filmRepo.save(film);
	}

	@Override
	public Film findByTitre(String titre) {
		return this.filmRepo.findByTitre(titre);
	}

	/**
	 * Retourne tous les films correspondant à un genre donné
	 * 
	 * @param genre Genre du film
	 * @return Liste des films correspondant à ce genre
	 */
	@Override
	public List<Film> findAllByGenre(String genre) {
		return this.filmRepo.findAllByGenre(genre);
	}

	/**
	 * Retourne les recettes d'un film
	 * 
	 * @param id Id du film dont on veut les recettes
	 * @return Recettes du film
	 */
	public double findRecetteById(String id) {
		double recette = 0;
		Optional<Film> optFilm = this.findById(id);
		if (optFilm.isPresent()) {
			Film film = optFilm.get();
			Stream<Seance> seances = serviceSeance.findAllByFilmId(film.getId()).stream();
			recette = seances.mapToDouble(seance -> this.serviceSeance.findRecetteBySeance(seance)).sum();
		}
		return recette;
	}

	@Override
	public List<Film> findByTitreLike(String titre) {
		return this.filmRepo.findByTitreLike(titre);
	}

	/**
	 * Permet d'obtenir la note moyenne d'un film
	 * 
	 * @param id Id du film dont on veut la note
	 * @return Moyenne des notes du film
	 */
	public double getNote(String id) {
		double note = 0;

		Stream<Commentaire> notes = this.serviceCommentaire.findAllByFilmId(id).stream();
		note = notes.filter(n -> n.getNote() > -1).mapToDouble(n -> n.getNote()).average().orElse(-1);

		return note;
	}

	/**
	 * Permet d'ajouter un commentaire à un film, la méthode vérifie si
	 * l'utilisateur à déjà mis une note
	 * 
	 * @param id          Id du film auquel on rajoute un commentaire
	 * @param commentaire Contenu du commentaire que l'on ajoute
	 * @return Le contenu du commentaire ajouté
	 */
	public Commentaire addCommentaire(Commentaire commentaire) {

		Stream<Commentaire> notes = this.serviceCommentaire.findAllByFilmId(commentaire.getFilm().getId()).stream();
		if (notes.anyMatch(t -> t.getClient().getId().equals(commentaire.getClient().getId()))) {
			commentaire.setNote(-1);
		}
		this.serviceCommentaire.save(commentaire);

		return commentaire;
	}
}
