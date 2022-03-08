package com.esprit.pidev.controllers;

import java.nio.channels.AlreadyBoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.*;
import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Participation;
import com.esprit.pidev.repos.*;
import com.esprit.pidev.services.*;

@RestController
@RequestMapping("/part")
public class ParticipationController {
	
	@Autowired(required=true)
	IParticipationService participationService;
	@Autowired
	IParticipationRepository participationRepository;
	@Autowired
	IEventRepository eventRepository;
	@Autowired
	IUserRepository userRepository;
	
	
	
	@PostMapping("/add-part/{id-user}/{id-event}")
	public String addParticipation(@RequestBody Participation part,@PathVariable(value = "id-user") Long id_user,@PathVariable(value ="id-event" ) Integer event_id ) 
	{
		String x ="participation added with success!!!!";		
		
		
		
		 Event event=eventRepository.findById(event_id).orElse(null);
		 part.setEdate(event.getEventDate());
		 Date d=part.getEdate();
		if(participationRepository.existsPart(d,  id_user)==false){
			if(participationRepository.countParts(event_id)<event.getCapacity()) {
			
		participationService.ajouterEtaffecterListeParts(part, id_user,event_id);}
			else {return event.getEventName()+" is at full capacity";}
		}
		else {x="you participate at another event in this date";
		}
		return x;
		

	}
	
	@PostMapping("/adding-parts/{name}")
	public void addPartToEvent(@RequestBody Participation participation,@PathVariable String name ) {
		
		participationService.ajouterEtaffecterPartToEvent(participation, name);
		}
	
	@GetMapping("/count/{event-id}")
	public String countparts(@PathVariable(value ="event-id") Integer event_id) {
		return  "there are "+participationRepository.countParts(event_id)+" participants";
	}

}

