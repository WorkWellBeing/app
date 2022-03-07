package com.esprit.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Dislike;
import com.esprit.pidev.repos.DislikeRepository;
import com.esprit.pidev.services.DislikeServiceImpl;


@RestController
@RequestMapping("/Dislike")
public class DislikeController {
	@Autowired
	DislikeRepository DislikeRepo;
	@Autowired
	DislikeServiceImpl DislikeSeRV;
	
	
	@PostMapping("/add/{id_user}/{id-post}")
	@ResponseBody
	public void adddislike(@RequestBody Dislike c,@PathVariable ("id_user") Long idUser,@PathVariable ("id-post") Long idp)
	{
		if(c.getEtatdislike()==0 ||c.getEtatdislike()==1 ){
			DislikeSeRV.dislikeservice(c,idUser,idp);
		}
	
	}
	@GetMapping("/test")
	@ResponseBody
	public String adddislike1()
	{
		
			return DislikeSeRV.getNbrLikee4();
	
	
	}
	
	}

