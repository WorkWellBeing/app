package com.esprit.pidev.repos;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Participation;
import com.esprit.pidev.entities.User;
@Repository
public interface IEventRepository extends CrudRepository<Event, Integer>{
	
	
	@Query("SELECT e FROM Event e WHERE CONCAT(e.EventName, e.eventDate, e.location) LIKE %?1%")
	public List<Event> search(String keyword);

	@Query("SELECT e FROM Event e WHERE e.EventName LIKE %:name%")
	Optional<Event> findByName(String name);
	
	
	

	

}
