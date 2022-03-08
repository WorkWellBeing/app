package com.esprit.pidev.controllers;

import com.esprit.pidev.repos.*;
import com.esprit.pidev.BadWordFilter;
import com.esprit.pidev.entities.*;
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



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import com.esprit.pidev.services.*;
import com.esprit.pidev.repos.*;

@RestController
@RequestMapping("/User")
public class employeecontrolleur 
{
	@Autowired
	UserService UserService;
	@Autowired
	PublicationInterface pubInt;	
	@Autowired
	CommetaireInterface CommInt;
	@Autowired 
	IUserRepository UserInt;
	@Autowired 
	LikeeInterface LikeeInt;
	
	
	
     // http://localhost:8081/Centre/User/AllCommentaire
     	@GetMapping("/AllCommentaire")
		@ResponseBody
		@Transactional
		@JsonIgnore
		public 	List<Commentaire> retrieveContracts (){
     		return  UserService.retrieveAllCommentaires();
			}
     	int nb=0;
     
     	//http://localhost:8081/Centre/User/Add-Commentaire/1/1
     	@PostMapping("/add-Commentaire/{id-user}/{id-pub}")
    	public void ajouterEtAffecteruserPub(@RequestBody Commentaire Commentaire,@PathVariable ("id-user") Long iduser,@PathVariable ("id-pub") Long idpub) throws InterruptedException{
     			
     		Commentaire.setContenu( BadWordFilter.getCensoredText(Commentaire.getContenu())); 
     		
     		  if(CommInt.CommentaireTest1(iduser).contains("*"));{
 			 System.out.print("****************vous serez bloqué***********");
     		  }
     		  if(nb==3){
     			  UserService.supprimerUser(iduser);
     		  }
       	
     		UserService.ajouterEtaffecterListeCommentaires(Commentaire,iduser,idpub);
     		  }
 
     		
     	
       	@PostMapping("/add-Publication/{id-user}")
    	public void addPublication(@RequestBody publication publication,@PathVariable(value = "id-user") Long id_user ) 
    	{
    		UserService.ajouterEtaffecterListePublications(publication, id_user);

    	}
       //http://localhost:8081/Centre/User/add-Publication/1
    	@PostMapping("/add-Likee/{id-user}/{id-pub}")
    	
    	public void ajouterEtaffecterListeLike(@RequestBody Likee Likee,@PathVariable ("id-user") Long iduser,@PathVariable ("id-pub") Long idpub){
    		if(Likee.getEtatlike()==0 ||Likee.getEtatlike()==1||Likee.getEtatlike()==2||Likee.getEtatlike()==3||Likee.getEtatlike()==4||Likee.getEtatlike()==5){
     		UserService.ajouterEtaffecterListeLike(Likee,iduser,idpub) ;
    		}
     			
     		}
    	
    	
    	 //http://localhost:8081/Centre/User/remove-Commentaire/1
    	@DeleteMapping("/remove-Commentaire/{Commentaire-id}")
    	@ResponseBody
    	public void removeUsine(@PathVariable("Commentaire-id") Long Commentaireid) {
    		UserService.supprimerCommentaire(Commentaireid);
    	}	
    	
    	
    	 //http://localhost:8081/Centre/User/getNbrLikee2
    	@GetMapping("/getNbrLikee2")
    	public String  tariftotale1(){
    		 return UserService.getNbrLikee4();
    	}
    	
   	 //http://localhost:8081/Centre/User/publicationLike/1
    	@GetMapping("/publicationLike/{pub-id}")
    	public String  publicationLike(@PathVariable("pub-id") Long pubid){
    		 return UserService.publicationLike(pubid);
    	}
     	//@GetMapping("/getpublicationByName/{pub-name}")
    	//public List<publication>  getpublicationByName(@PathVariable("pub-name") String pubname){
    		// return (List<publication>)UserService.getpublicationByName(pubname);
    	//}
    	   // 	http://localhost:8081/Centre/User/publicationLike/1
    	@GetMapping("/search/{keyword}") 
        public List<publication> listAll(@PathVariable("keyword") String keyword) {
            if (keyword != null) {
                return pubInt.search(keyword);
            }
            return (List<publication>) pubInt.findAll();
        }
    	@GetMapping("/CommentaireTest/{User-id}")
    	public int  CommentaireTest(@PathVariable("User-id") Long idUser){
    		 return CommInt.CommentaireTest(idUser);
    	}
    	@GetMapping("/CommentaireTest1/{User-id}")
    	public List<String>  CommentaireTest1(@PathVariable("User-id") Long idUser){
    		 return CommInt.CommentaireTest1(idUser);
    	}
    	@GetMapping("/getNbrLikee4/{Pub-id}")
    	public String Somme(@PathVariable("Pub-id") Long idPub){
    		return UserService.Resultat(idPub);
    	}
    	@GetMapping("/Date")
    	public String Date(){
    		return pubInt.Date();
    	}
    	
    	// @GetMapping("/exportexcel")
    	  //  public void exportToExcel(HttpServletResponse response) throws IOException {
    	    //    response.setContentType("application/octet-stream");
    	      //  DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    	       // String currentDateTime = dateFormatter.format(new Date());
    	         
    	       // String headerKey = "Content-Disposition";
    	        //String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
    	        //response.setHeader(headerKey, headerValue);
    	         
    	        //List<Commentaire> listUsers = UserService.retrieveAllCommentaires();
    	         
    	       // CommentExcelTransport excelExporter = new CommentExcelTransport(listUsers);
    	         
    	        //excelExporter.export(response);    
    	    //}  
		}
		

	


