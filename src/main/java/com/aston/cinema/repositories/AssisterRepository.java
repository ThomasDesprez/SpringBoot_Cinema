package com.aston.cinema.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Assister;

public interface AssisterRepository extends MongoRepository<Assister, String> {

}