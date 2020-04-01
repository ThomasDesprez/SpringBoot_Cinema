package com.aston.cinema.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aston.cinema.models.Client;


public interface ClientService {

	public List<Client> findAll();
	
	public Optional<Client> findById(String id);

	public Client update(Client client);

	public void delete(String id);

	public Client save(Client client);
	
	public List<Client> findByEtudiantIsTrue();
	
	public List<Client> findByNaissance(LocalDateTime naissance);

	public List<Client> findAllByNom(String nom);

}
