package com.aston.cinema.services.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aston.cinema.models.Assister;
import com.aston.cinema.models.Client;
import com.aston.cinema.repositories.AssisterRepository;
import com.aston.cinema.models.TypeSeance;

@Service
public class AssisterServiceImpl {

	@Autowired
	private AssisterRepository assisterRepo;

	@Autowired
	private ClientServiceImpl serviceClient;

	private float prix_ticket = 10;

	/**
	 * 
	 * @param type Type de séance à laquelle le client assiste
	 * @param clientid ID du client qui assiste à la séance
	 * @return Assister contenant le prix du ticket et le client
	 */
	public Assister createAssister(String type, String clientid) {
		float remise = 0;
		Client c = this.findByClient(clientid);
		if(Period.between(LocalDate.now(), c.getNaissance()).getYears() < 10)
			remise = 4;
		else if(c.isEtudiant()) {
			remise = 2;
		}
		Assister assister = new Assister(null,prix_ticket-remise,c);
		for(TypeSeance seance : TypeSeance.values()) {
			if(seance.getType().equalsIgnoreCase(type))
				assister.setPrix(assister.getPrix() + seance.getPrix());
		}

		return this.assisterRepo.insert(assister);
	}

	public Client findByClient(String id) {
		Optional<Client> OptC = this.serviceClient.findById(id);
		if (OptC.isPresent()) {
			return OptC.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pas trouvé de client d'id " + id);
		}
	}
}
