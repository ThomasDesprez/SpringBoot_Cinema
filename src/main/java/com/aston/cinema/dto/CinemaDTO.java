package com.aston.cinema.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.aston.cinema.models.Cinema;
import com.aston.cinema.models.Salle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {

	private Cinema cinema;
	private List<Salle> salles = new ArrayList<>();

}
