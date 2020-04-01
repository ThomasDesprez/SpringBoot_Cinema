package com.aston.cinema.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Client;
import com.aston.cinema.repositories.AssisterRepository;

public class AssisterServiceImpl {

	@Autowired
	private AssisterRepository assisterRepo;
	
	@Autowired
	private ClientServiceImpl serviceClient;
	
	public Client findByClient(String id) {
		Optional<Assister> OptC = this.assisterRepo.findById(id);
		if(OptC.isPresent()) {
		Client c = OptC.get().getClient();
		return null;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pas trouvé de assister d'id");
		}
	}
}
