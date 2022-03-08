package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Formulaire;



@Repository

public interface FormulaireRepository extends CrudRepository<Formulaire,Long> {

}
