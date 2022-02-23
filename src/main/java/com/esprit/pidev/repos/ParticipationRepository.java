package com.esprit.pidev.repos;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Participation;
@Repository
public interface ParticipationRepository extends CrudRepository<Participation, Date> {

}
