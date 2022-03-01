package com.example.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BadWordFilter;
import com.example.entitie.Commentaire;
import com.example.entitie.Likee;
import com.example.entitie.publication;
import com.example.service.*;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

import java.util.*;


@RestController
@RequestMapping("/User")
public class employeecontrolleur 
{
	@Autowired
	UserService UserService;
	
	
	
     // http://localhost:8089/SpringMVC/Centre/User/AllCommentaire
     	@GetMapping("/AllCommentaire")
		@ResponseBody		
			
		public void retrieveContracts (){
     		UserService.retrieveAllCommentaires();
			}
     	//http://localhost:8081/SpringMVC/Centre/User/Add-Commentaire/1
     	@PostMapping("/add-Commentaire/{id-user}/{id-pub}")
    	public void ajouterEtAffecterFormationAFormateur(@RequestBody Commentaire Commentaire,@PathVariable ("id-user") Long iduser,@PathVariable ("id-pub") Long idpub){
     		Commentaire.setContenu( BadWordFilter.getCensoredText(Commentaire.getContenu() )); 
     		UserService.ajouterEtaffecterListeCommentaires(Commentaire,iduser,idpub) ;
     	
     	  
     		}
     		
     	
       	@PostMapping("/add-Publication/{id-user}/{id-like}")
    	public void addPublication(@RequestBody publication publication,@PathVariable(value = "id-user") Long id_user,@PathVariable(value = "id-like") Long idlike ) 
    	{
    		UserService.ajouterEtaffecterListePublications(publication, id_user,idlike);

    	}
       	
    	@PostMapping("/add-Likee/{id-user}/{id-pub}")
    	
    	public void ajouterEtaffecterListeLike(@RequestBody Likee Likee,@PathVariable ("id-user") Long iduser,@PathVariable ("id-pub") Long idpub){
    		if(Likee.getEtatlike()==0 ||Likee.getEtatlike()==1 ){
     		UserService.ajouterEtaffecterListeLike(Likee,iduser,idpub) ;
    		}
     			
     		}
     	
    	@DeleteMapping("/remove-Commentaire/{Commentaire-id}")
    	@ResponseBody
    	public void removeUsine(@PathVariable("Commentaire-id") Long Commentaireid) {
    		UserService.supprimerCommentaire(Commentaireid);
    	}	
    	
    	
    	@GetMapping("/getNbrLikee")
    	public int  tariftotale(){
    		 return UserService.getNbrLikee();
    	}
    	@GetMapping("/getNbrLikee2")
    	public String  tariftotale1(){
    		 return UserService.getNbrLikee4();
    	}
    	@GetMapping("/publicationLike/{pub-id}")
    	public int  publicationLike(@PathVariable("pub-id") Long pubid){
    		 return UserService.publicationLike(pubid);
    	}
     	@GetMapping("/getpublicationByName/{pub-name}")
    	public List<publication>  getpublicationByName(@PathVariable("pub-name") String pubname){
    		 return (List<publication>)UserService.getpublicationByName(pubname);
    	}
		}
		

	


