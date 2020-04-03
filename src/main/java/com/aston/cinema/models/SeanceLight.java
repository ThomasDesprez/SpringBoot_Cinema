package com.aston.cinema.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class SeanceLight {
	
	private LocalDateTime date;
	private Film film;
	private float prix;

	public SeanceLight(Seance seance, Assister assist) {
		this.date = seance.getDate();
		this.film = seance.getFilm();
		this.prix = assist.getPrix();
	}

}
