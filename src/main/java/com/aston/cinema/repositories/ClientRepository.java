package com.aston.cinema.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aston.cinema.models.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

	public List<Client> findAllByNom(String nom);
	
	public List<Client> findAll();
	
	public	List<Client> findByEtudiantIsTrue();
	
	public List<Client> findByNaissance(LocalDateTime naissance);
}