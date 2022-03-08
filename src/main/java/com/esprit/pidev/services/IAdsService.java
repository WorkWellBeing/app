package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Ads;



public interface IAdsService {

	void deleteAds(int id);



	 public Ads updateAds(Ads c);
	
	
	 void ajouterEtaffecterListeads (List<Ads> lb, int idPartner);
	 
		List<Ads> listedeAdss(int idPartner);

	
	

}
