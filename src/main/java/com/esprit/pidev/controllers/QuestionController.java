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

import com.esprit.pidev.entities.Question;
import com.esprit.pidev.services.QuestionService;


@RestController
@RequestMapping("/question")

public class QuestionController {
	

	@Autowired
	QuestionService questionservice;
	// http://localhost:8089/SpringMVC/client/add-client
		@PostMapping("/add")
		@ResponseBody
		public Question addquestion(@RequestBody Question c)
		{
		Question question =questionservice.addquestion(c);
		return question;
		}


		//http://localhost:8089/SpringMVC/add-comment/{idf}

	//ajouter question
		@PostMapping("/add-question/{idf}")
		@ResponseBody
		public Question  addc (@RequestBody  Question q,@PathVariable ("idf") Long idf) {
			Question listques =questionservice.addc(q, idf);
			return  listques ;
		}
		
		// http://localhost:8089/SpringMVC/question/remove-question/idq}
				@DeleteMapping("/remove-question/{idq}")
				@ResponseBody
				public void deletequestion(@PathVariable("idq") Long idq) {
					questionservice.deletequestion(idq);;
				}
				// http://localhost:8089/SpringMVC/post/modify-post
				@PutMapping("/modify-question")
				@ResponseBody
				public Question updateQuestion(@RequestBody Question q) {
				return questionservice.updateQuestion(q);
				}

}
