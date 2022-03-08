package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Trophee;
import com.esprit.pidev.services.ITropheeService;

@RestController
@RequestMapping("/trophee")
public class TropheeRestController {
	@Autowired
	ITropheeService tropheeService;
	
	@PostMapping("/addTrophee")
	@ResponseBody
	public void addTrophee(@RequestBody Trophee trophee){
		tropheeService.ajouterTrophee(trophee);
	}
	
	@PutMapping("/updateTrophee/{idTrophee}")
	@ResponseBody
	public void updateTrophee(@RequestBody Trophee trophee,@PathVariable("idTrophee") int idTrophee){
		tropheeService.updateTrophee(trophee, idTrophee);
	}
	
	@PutMapping("/likeTrophee/{idTrophee}/{idUser}")
	@ResponseBody
	public void likeTrophee(@PathVariable("idTrophee") int idTrophee ,@PathVariable("idUser") int idUser ){
		tropheeService.likeTrophee(idTrophee, idUser);
	}
	
	@PutMapping("/dislikeTrophee/{idTrophee}/{idUser}")
	@ResponseBody
	public void dislikeTrophee(@PathVariable("idTrophee") int idTrophee ,@PathVariable("idUser") int idUser ){
		tropheeService.dislikeTrophee(idTrophee, idUser);
	}
	
	@GetMapping("/getAllTrophees")
	@ResponseBody
	public List<Trophee> getAllTrophees(){
		List<Trophee> listTrophees = tropheeService.retrieveAllTrophee();
		return listTrophees;
	}
	
	@GetMapping("/getTrophee/{idTrophee}")
	@ResponseBody
	public Trophee getTrophee(@PathVariable("idTrophee") int idTrophee){
		Trophee trophee = tropheeService.retrieveTrophee(idTrophee);
		return trophee;
	}
	
	@GetMapping("/getTopTrophee")
	@ResponseBody
	public Trophee getTopTrophee(){
		Trophee trophee = tropheeService.findTopTrophee();
		return trophee;
	}
}
