package com.esprit.pidev.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Evaluation;
import com.esprit.pidev.entities.User;


@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation,Integer>{
 
	@Query("Select e FROM Evaluation e WHERE e.user =:user")
	public Evaluation getEvaluiationByUser(@Param("user") User user);
}
