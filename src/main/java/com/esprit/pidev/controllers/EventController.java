package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Event;
import com.esprit.pidev.repos.*;
import com.esprit.pidev.services.*;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	IEventService eventService;
	@Autowired
    private IEventRepository eventRepository;
	
	@DeleteMapping("/delete-event/{event_id}")
	@ResponseBody
	public void deleteEvent(@PathVariable("event_id") Integer event_id){
		eventService.deleteEvent(event_id);
	}
	

    @GetMapping("/search/{keyword}") 
    public List<Event> listAll(@PathVariable("keyword") String keyword) {
        if (keyword != null) {
            return eventRepository.search(keyword);
        }
        return (List<Event>) eventRepository.findAll();
    }

}
