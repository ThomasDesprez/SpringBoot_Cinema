package com.aston.cinema.services.impl;

import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Commentaire;
import com.aston.cinema.models.Film;
import com.aston.cinema.models.Seance;
import com.aston.cinema.repositories.FilmRepository;
import com.aston.cinema.services.FilmService;
import com.aston.cinema.services.impl.SeanceServiceImpl;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepo;

	@Autowired
	private SeanceServiceImpl serviceSeance;

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

	@Override
	public List<Film> findAllByGenre(String genre) {
		return this.filmRepo.findAllByGenre(genre);
	}

	@Override
	public int findRecetteById(String id) {
		int recette = 0;
		Optional<Film> optFilm = this.findById(id);
		if (optFilm.isPresent()) {
			Film film = optFilm.get();
			Stream<Seance> seances = serviceSeance.findAllByFilmId(film.getId()).stream();
			recette = seances.mapToInt(seance -> this.serviceSeance.findRecetteBySeance(seance)).sum();
		}
		return recette;
	}

	@Override
	public List<Film> findByTitreLike(String titre) {
		return this.filmRepo.findByTitreLike(titre);
	}

	@Override
	public float getNote(String id) {
		Optional<Film> f = this.findById(id);
		double note = 0;
		if (f.isPresent()) {
			Film film = f.get();
			Stream<Commentaire> notes = film.getCommentaires().stream();
			note = notes.filter(n -> n.getNote() > -1).mapToDouble(n -> n.getNote()).average().orElse(-1);
		}
		return (float) note;
	}

	@Override
	public Commentaire addCommentaire(String id, Commentaire commentaire) {
		Optional<Film> f = this.findById(id);
		if (f.isPresent()) {
			Film film = f.get();
			Stream<Commentaire> notes = film.getCommentaires().stream();
			// filter(distinctByKey(Commentaire::getAuteurId));
			if (notes.anyMatch(t -> t.getClient().getId().equals(commentaire.getClient().getId()))) {
				commentaire.setNote(-1);
			}
			film.getCommentaires().add(commentaire);
			this.update(film);
		}

		return commentaire;
	}
}
