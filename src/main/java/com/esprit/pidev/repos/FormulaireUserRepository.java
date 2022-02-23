package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Formulaire_User;


@Repository
public interface FormulaireUserRepository extends CrudRepository<Formulaire_User,Integer>{

}
