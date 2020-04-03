package com.aston.cinema.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDTO {

	private String genreFilm;
	private LocalDateTime début, fin;
	private int age;
	private List<String> typeSeance;

}