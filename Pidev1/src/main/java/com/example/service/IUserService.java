package com.example.service;

import java.util.List;

import com.example.entitie.Commentaire;
import com.example.entitie.Likee;
import com.example.entitie.User;
import com.example.entitie.publication;



public interface IUserService {
	
	   public void supprimerCommentaire(long id);
	   public List<Commentaire> retrieveAllCommentaires(); 
	   public publication ajouterPublication(publication Publication);
	   public void supprimerPublication(long id);
	   public List<publication> retrieveAllPublications(); 
		public void ajouterEtaffecterListePublications(publication publication, Long iduser,Long Likee);
	  public void ajouterEtaffecterListeCommentaires(Commentaire Commentaire, Long idpublication,Long idUser);	 
	  public void ajouterEtaffecterListeLike(Likee Likee, Long idpublication,Long idUser);	 

}
