package com.esprit.pidev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Formulaire;
import com.esprit.pidev.services.FormulaireService;




@RestController
@RequestMapping("/form")

public class FormulaireController {
	
	
	@Autowired
	FormulaireService formservice;
	// http://localhost:8089/SpringMVC/client/add-client
		@PostMapping("/add")
		@ResponseBody
		public Formulaire addform(@RequestBody Formulaire c)
		{
		Formulaire f =formservice.addfrom(c);
		return f;
		}
		
		@PostMapping("/add-formulaire/{id}")
		@ResponseBody
		public Formulaire  addf (@RequestBody  Formulaire q,@PathVariable ("id") Long idf) {
			Formulaire listques =formservice.addf(q, idf);
			return  listques ;
		}
		
}
