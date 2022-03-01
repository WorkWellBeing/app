package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.repository.*;

import lombok.extern.slf4j.Slf4j;

import com.example.BadWordFilter;
import com.example.entitie.Commentaire;
import com.example.entitie.Likee;
import com.example.entitie.User;
import com.example.entitie.publication;




@Slf4j

@Service
public class UserService  implements IUserService {

	@Autowired
	 UserInterface UserInterface;
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
	@Override
	public List<publication> retrieveAllPublications() {
		 return (List<publication>)PublicationInterface.findAll();
	}
	
	
	
	
	@Override
	public void ajouterEtaffecterListePublications(publication publication, Long iduser,Long idLike) {
		  User User = UserInterface.findById(iduser).orElse(null);
		  Likee Like = LikeeInterface.findById(idLike).orElse(null);
          publication.setUser(User);
          publication.setLike(Like);
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
	public int getNbrLikee() {
	
		return  LikeeInterface.getNbrLikee();
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
	
	public int publicationLike(Long idpublication)
	{
		return LikeeInterface.publicationLike(idpublication);
	}

public List<publication> getpublicationByName(String pubname) {
	// TODO Auto-generated method stub
	return  (List<publication>) PublicationInterface.getpublicationByName(pubname);}
}
	
	
	



