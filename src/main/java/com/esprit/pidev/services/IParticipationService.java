package com.esprit.pidev.services;

import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Activity;
import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Participation;
import com.esprit.pidev.entities.User;

@Service


public interface IParticipationService {
	public void ajouterEtaffecterListeParts(Participation part, Long id_user,Integer event_id);
	
	public void ajouterEtaffecterPartToEvent(Participation part, String name);
		
	}





