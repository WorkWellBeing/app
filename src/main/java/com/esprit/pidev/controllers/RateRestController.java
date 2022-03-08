package com.esprit.pidev.controllers;

import java.util.List;

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

import com.esprit.pidev.entities.Rate;
import com.esprit.pidev.entities.Rate_User;
import com.esprit.pidev.services.IRateService;

@RestController
@RequestMapping("/rate")
public class RateRestController {

	@Autowired
	IRateService rateService;
	
	@PostMapping("/addRate")
	@ResponseBody
	public void addRate(@RequestBody Rate rate){
		 rateService.ajouterRate(rate);
	}
	
	@PutMapping("/updateRate/{idRate}")
	@ResponseBody
	public void updateRate(@RequestBody Rate rate,@PathVariable("idRate") int idRate){
		rateService.updateRate(rate , idRate);
	}
	
	@GetMapping("/getAllRates")
	@ResponseBody
	public List<Rate> getAllRates(){
		List<Rate> listRate = rateService.retrieveAllRate();
		return listRate;
	}
	
	@DeleteMapping("/deleteRate/{idRate}")
	@ResponseBody
	public void deleteRate(@PathVariable("idRate") int idRate){
		rateService.deleteRate(idRate);
	}
	
	@PutMapping("/likeRateUser/{idRateUser}/{idUser}")
	@ResponseBody
	public void likeRateUser(@PathVariable("idRateUser") int idRateUser ,@PathVariable("idUser") int idUser){
		rateService.likeRateUser(idRateUser, idUser);
	}
	
	@PutMapping("/dislikeRateUser/{idRateUser}/{idUser}")
	@ResponseBody
	public void dislikeRateUser(@PathVariable("idRateUser") int idRateUser ,@PathVariable("idUser") int idUser){
		rateService.dislikeRateUser(idRateUser, idUser);
	}
	
	@GetMapping("/getRateUserByUser/{idUser}")
	@ResponseBody
	public List<Rate_User> getRateUserByUser(@PathVariable("idUser") int idUser){
		List<Rate_User> listRateUser = rateService.retrieveAllRateUserByUser(idUser);
		return listRateUser;
	}
	
	@GetMapping("/getAllRateClasse")
	@ResponseBody
	public List<Rate> getAllRateClasse(){
		return rateService.getAllRateClasseByPourcentagePoints();
	}
}
