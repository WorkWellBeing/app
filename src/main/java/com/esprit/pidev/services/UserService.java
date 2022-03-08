package com.esprit.pidev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

import com.esprit.pidev.BadWordFilter;


import com.esprit.pidev.repos.*;

import com.esprit.pidev.entities.*;

@Slf4j

@Service
public class UserService  implements IUserService {

	@Autowired
	 IUserRepository UserInterface;
	@Autowired
	 CommetaireInterface CommentaireInterface;
	@Autowired
	 PublicationInterface PublicationInterface;
	@Autowired
	 LikeeInterface LikeeInterface;

	@Override
	public void supprimerCommentaire(long id) {
		 	 CommentaireInterface.deleteById(id);;
	}
	@Override
	public List<Commentaire> retrieveAllCommentaires() {
		 return (List<Commentaire>)CommentaireInterface.findAll();
	
	}
	@Override
	public publication ajouterPublication(publication P) {
		return PublicationInterface.save(P);
	}
	@Override
	public void supprimerPublication(long id) {
		PublicationInterface.deleteById(id);
		
	}
	public void supprimerUser(long id) {
		UserInterface.deleteById(id);
		
	}
	@Override
	public List<publication> retrieveAllPublications() {
		 return (List<publication>)PublicationInterface.findAll();
	}
	
	public String Resultat(long idPublication){
		long millis1 = System.currentTimeMillis();
	
		
		return "l'évenement peut acquérir"+" " +LikeeInterface.getNbrLikee4(idPublication)*LikeeInterface.getNbrLikee5(idPublication)+" " +"DT ";
	}
	
	
	@Override
	public void ajouterEtaffecterListePublications(publication publication, Long iduser) {
		  User User = UserInterface.findById(iduser).orElse(null);
          publication.setUser(User);
        
          PublicationInterface.save(publication);
	
		}
	@Override
	public void ajouterEtaffecterListeCommentaires(Commentaire Commentaire, Long idpublication,Long idUser) {
		 publication publication = PublicationInterface.findById(idpublication).orElse(null);
         User User = UserInterface.findById(idUser).orElse(null);
         Commentaire.setPublication(publication);
         Commentaire.setUser(User);
         CommentaireInterface.save((Commentaire));	
     
	}
	@Override
	public void ajouterEtaffecterListeLike(Likee Likee, Long idpublication, Long idUser) {
		 publication publication = PublicationInterface.findById(idpublication).orElse(null);
         User User = UserInterface.findById(idUser).orElse(null);
         Likee.setPublication(publication);
         Likee.setUser(User);
         LikeeInterface.save(Likee);				
		
	}
	
	public String getNbrLikee4() {
	
		 String x="";
		 if (LikeeInterface.getNbrLikee3()>LikeeInterface.getNbrLikee2()){
			 x="Users are not satisfied";
		 }else {
			 x="Users are satisfied";
		 }
		return  x;
	}
	
	public String publicationLike(Long idpublication)
	{
		String x="";String x1="";
		if  (LikeeInterface.getNbrLikee(idpublication)==1){
	x="le";x1="a";
			
		}else {x="les"; x1="ont";}
		return x +" "+ LikeeInterface.getNbrLikee(idpublication) + " Interactions" +" "+ x1 +" " +"fait une moyenne de  "+  LikeeInterface.publicationLike(idpublication)/LikeeInterface.getNbrLikee(idpublication) + " stars";
		}
	public List<publication> search(String keyword) {
		// TODO Auto-generated method stub
		 	return PublicationInterface.search(keyword);
	}
	public List<publication> findAll() {
		
		return (List<publication>) PublicationInterface.findAll();
	}
	@Override
	public void ajouterEtaffecterListePublications(publication publication, Long iduser, Long Likee) {
		// TODO Auto-generated method stub
		
	}
	
		
	
	}
	
	

	
	
	



