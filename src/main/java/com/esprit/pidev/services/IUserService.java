package com.esprit.pidev.services;

import java.util.List;


import com.esprit.pidev.entities.Commentaire;
import com.esprit.pidev.entities.publication;
import com.esprit.pidev.entities.Likee;




public interface IUserService {
	
	   public void supprimerCommentaire(long id);
	   public List<Commentaire> retrieveAllCommentaires(); 
	   public publication ajouterPublication(publication Publication);
	   public void supprimerPublication(long id);
	   public List<publication> retrieveAllPublications(); 
		public void ajouterEtaffecterListePublications(publication publication, Long iduser,Long Likee);
	  public void ajouterEtaffecterListeCommentaires(Commentaire Commentaire, Long idpublication,Long idUser);	 
	     void ajouterEtaffecterListePublications(publication publication, Long iduser);
		void ajouterEtaffecterListeLike(Likee Likee, Long idpublication, Long idUser);


}
