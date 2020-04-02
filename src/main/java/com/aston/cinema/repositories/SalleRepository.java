package com.aston.cinema.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Salle;

public interface SalleRepository extends MongoRepository<Salle, String>{

}
