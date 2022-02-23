package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Evaluation;


@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation,Integer>{

}
