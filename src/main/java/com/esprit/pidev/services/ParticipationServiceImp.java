package com.esprit.pidev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Activity;
import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Participation;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.*;

@Service
public class ParticipationServiceImp implements IParticipationService {
	@Autowired
	IUserRepository userRepository;
@Autowired
	IParticipationRepository participationRepository;
@Autowired
IEventRepository eventRepository;

	
	@Override
	public void ajouterEtaffecterPartToEvent(Participation part, String name) {
		Event event=eventRepository.findByName(name).orElse(null);
		part.setEvent(event);
		participationRepository.save(part);
		
	}


	@Override
	public void ajouterEtaffecterListeParts(Participation part, Long id_user, Integer event_id) {
		User user=userRepository.findById(id_user).orElse(null);
		Event event=eventRepository.findById(event_id).orElse(null);
		part.setUser(user);
		part.setEvent(event);
		participationRepository.save(part);
	}

	
	
	

}
