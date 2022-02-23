package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Offre;


@Repository
public interface OffreRepository extends CrudRepository <Offre,Integer>{

}
