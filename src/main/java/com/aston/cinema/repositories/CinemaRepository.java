package com.aston.cinema.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Cinema;

public interface CinemaRepository  extends MongoRepository<Cinema, String> {

}
