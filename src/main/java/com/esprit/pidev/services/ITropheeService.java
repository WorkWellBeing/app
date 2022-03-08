package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Trophee;

public interface ITropheeService {

	void ajouterTrophee(Trophee trophee);

	void updateTrophee(Trophee trophee, int idTrophee);

	void likeTrophee(int idTrophee, long idUser);

	void dislikeTrophee(int idTrophee, long idUser);

	List<Trophee> retrieveAllTrophee();

	Trophee retrieveTrophee(int idTrophee);

	Trophee findTopTrophee();

}
