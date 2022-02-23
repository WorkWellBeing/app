package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
