package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Event;

public interface IEventService {

	void deleteById(Integer event_id);

	List<Event> getAllEvents();

	public void deleteEvent(Integer event_id);

	

	
	

}
