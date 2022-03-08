package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Offre;





public interface IOffreService {

	 public void ajouOffre(Offre offre);
	 void deleteOffre(int id);

	public int countOffrePartner(int idPartner);
	 /*List<Offre> retrieveAllOffres();*/

	 List<Offre> retrieveAllOffres();
	

	 void ajouterEtaffecterListeoffre (List<Offre> lb, int idPartner);
	 
		List<Offre> listedeOffres(int idPartner);

}
