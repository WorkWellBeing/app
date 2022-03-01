package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entitie.Commentaire;

public interface CommetaireInterface extends CrudRepository<Commentaire, Long> { 

}
