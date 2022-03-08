package com.esprit.pidev.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Event;
import com.esprit.pidev.repos.*;


@Service
public class EventServiceImpl implements IEventService {
@Autowired
IEventRepository eventRepository;
	@Override
	public void deleteById(Integer event_id) {
		
		eventRepository.deleteById(event_id);
	}
	@Override
	@Transactional
	public List<Event>getAllEvents() {
		 List<Event> liste =(List<Event>)eventRepository.findAll();
		return liste;
	}
	public void deleteEvent(Integer event_id) {
		eventRepository.deleteById(event_id);
		
	}
	
	
	
	
}
