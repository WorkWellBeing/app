package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Rate;
import com.esprit.pidev.entities.Rate_User;

public interface IRateService {

	void ajouterRate(Rate rate);

	void updateRate(Rate rate, int idRate);

	void deleteRate(int idRate);

	List<Rate> retrieveAllRate();

	void dislikeRateUser(int idRateUser, long idUser);

	void likeRateUser(int idRateUser, long idUser);

	List<Rate_User> retrieveAllRateUserByUser(long idUser);

	List<Rate> getAllRateClasseByPourcentagePoints();

	

}
