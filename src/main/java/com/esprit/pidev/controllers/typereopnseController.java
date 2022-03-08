package com.esprit.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.typereopnse;
import com.esprit.pidev.services.QuestionService;
import com.esprit.pidev.services.TypeReponseImpl;
import com.esprit.pidev.services.TypeReponseService;




@RestController
@RequestMapping("/reponse")
public class typereopnseController {

	@Autowired
	TypeReponseService typeserv;
	@Autowired
	QuestionService questionserv;
	@Autowired
	TypeReponseImpl type;
	@PostMapping("/add-reponse/{id}")
	@ResponseBody
	public typereopnse  addrep (@RequestBody  typereopnse q,@PathVariable ("id") Long id) {
		typereopnse listques =typeserv.addrep(q, id);
		return  listques ;
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String getNbrreponse()
	{
		return type.getNbrreponse();
	}
}
