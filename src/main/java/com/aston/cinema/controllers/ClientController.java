package com.aston.cinema.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aston.cinema.models.Client;
import com.aston.cinema.services.ClientService;

@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public List<Client> findAll() {
		return this.clientService.findAll();
	}

	@PostMapping("")
	public Client save(@RequestBody Client Client) {
		return this.clientService.save(Client);
	}

	@PutMapping("")
	public Client update(@RequestBody Client Client) {
		return this.clientService.update(Client);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Client Client) {
		this.deleteById(Client.getId());
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.clientService.delete(id);
	}

	@GetMapping("{id}")
	public Optional<Client> findById(@PathVariable String id) {
		return this.clientService.findById(id);
	}

	@GetMapping("nom/{nom}")
	public List<Client> findAllByNom(@PathVariable String nom) {
		return this.clientService.findAllByNom(nom);
	}
}
