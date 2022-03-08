package com.esprit.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.BadWordFilter;
import com.esprit.pidev.entities.Comment;
import com.esprit.pidev.services.CommentService;
import com.esprit.pidev.services.PostService;




@RestController
@RequestMapping("/com")
public class CommentController {

	@Autowired
	CommentService comservice;
	@Autowired
	PostService postservice;
	
	// http://localhost:8089/SpringMVC/client/add-client
		@PostMapping("/add")
		@ResponseBody
		public Comment addcomment(@RequestBody Comment co)
		{
		Comment f =comservice.addcomment(co);
		return f;
		}
		
		// http://localhost:8089/SpringMVC/Fournisseur/remove-comment/{comment-id}
		@DeleteMapping("/remove-comment/{idc}")
		@ResponseBody
		public void deletecomment(@PathVariable("idc") Long idc) {
			comservice.deletecomment(idc);
		}
		
		//http://localhost:8089/SpringMVC/add-comment/{id-post}

	
		@PostMapping("/add-comment/{id-post}")
		@ResponseBody
		public Comment  addc (@RequestBody Comment c,@PathVariable ("id-post") Long idp) {
			Comment listcom =comservice.addc(c, idp);
			return listcom;
		}

		// http://localhost:8089/SpringMVC/Fournisseur/modify-Fournisseur
		@PutMapping("/modify-Comment")
		@ResponseBody
		public Comment modifyFournisseur(@RequestBody Comment c) {
		return comservice.updateComment(c);
		}

		
		//http://localhost:8081/SpringMVC/Centre/User/Add-comment/1
     	@PostMapping("/add-Comment/{id-user}/{id-post}")
    	public void ajouterEtaffecterListeComment(@RequestBody Comment comment,@PathVariable ("id-user") Long iduser,@PathVariable ("id-post") Long idp){
     		comment.setCommenta( BadWordFilter.getCensoredText(comment.getCommenta() ));
     		       comservice.ajouterEtaffecterListeComment(comment, idp, iduser);
     			
     		}


}
