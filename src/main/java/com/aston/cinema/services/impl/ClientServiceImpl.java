package com.aston.cinema.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aston.cinema.models.Client;
import com.aston.cinema.repositories.ClientRepository;
import com.aston.cinema.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Override
	public List<Client> findAll() {
		return this.clientRepo.findAll();
	}

	@Override
	public Optional<Client> findById(String id) {
		return this.clientRepo.findById(id);
	}

	@Override
	public Client update(Client Client) {
		return this.clientRepo.save(Client);
	}

	@Override
	public void delete(String id) {
		this.clientRepo.deleteById(id);
	}

	@Override
	public Client save(Client Client) {
		return this.clientRepo.save(Client);
	}


	@Override
	public List<Client> findByEtudiantIsTrue() {
		return this.clientRepo.findByEtudiantIsTrue();
	}

	@Override
	public List<Client> findByNaissance(LocalDateTime naissance) {
		return this.clientRepo.findByNaissance(naissance);
	}

	@Override
	public List<Client> findAllByNom(String nom) {
		return this.clientRepo.findAllByNom(nom);
	}

}
