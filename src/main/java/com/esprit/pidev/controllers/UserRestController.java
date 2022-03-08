package com.esprit.pidev.controllers;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esprit.pidev.entities.Evaluation;
import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.services.IEventService;
import com.esprit.pidev.services.ServiceIUser;
import com.esprit.pidev.services.ServiceImpIUser;

import lombok.Data;


@RestController
@RequestMapping("/user")

public class UserRestController {
	@Autowired
	ServiceIUser userService ; 
	@Autowired
	ServiceImpIUser userService1 ; 

	
	@Autowired(required=true)
	public IEventService eventService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return  ResponseEntity.ok().body(userService.getUsers()) ; 
	}
	
	@PostMapping("/registration")
	public String createNewUser( @RequestBody User user) {
	String msg="";
	User userExists = userService.findUserByUserName(user.getUserName());
	if (userExists != null) {
	msg="There is already a user registered with the user name provided";
	} else {
	userService.saveUser(user);
	msg="OK"; }
	return msg; 
	}
	


	@PostMapping("/add-event/{id-user}")
	public void addEvent(@RequestBody Event event,@PathVariable(value = "id-user") Long id_user ) 
	{
		userService1.ajouterEtaffecterListeEvents(event, id_user);

	}
	
	@GetMapping("/retrieve_events")
	@ResponseBody
	public List<Event> getEvents() {
	List<Event> listEvents =  userService1.retrieveAllEvents();
	return  listEvents;
	}
	
	@DeleteMapping("/delete-event/{event_id}")
	public void deleteEvents( @PathParam(value="event_id")Integer event_id) {
		if (event_id!=null) {
		eventService.deleteById(event_id);}
		
	}
	@GetMapping("/afficher-events")
	@ResponseBody
	public List<Event>getAllEvents(){
		List<Event>listeEvents=eventService.getAllEvents();
		return listeEvents;
	}
	
	@GetMapping("/getEvaluation/{idUser}")
	@ResponseBody
	public Evaluation getEvaluationByUser(@PathVariable("idUser") long idUser){
		return userService.getEvaluationByUser(idUser);
	}
	
	@GetMapping("/getAllUserClasse")
	@ResponseBody
	public List<User> getAllUserClass(){
		return userService.getAllUserClasse();
	}
}
