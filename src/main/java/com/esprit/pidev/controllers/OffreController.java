package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Offre;
import com.esprit.pidev.repos.OffreRepository;
import com.esprit.pidev.services.IOffreService;



@RestController

public class OffreController {
	@Autowired
	IOffreService offreService;
	@Autowired
	   OffreRepository offreRepository;

	@PostMapping("/add-offre")
	@ResponseBody
	public void ajouOffre(@RequestBody Offre offre) {
		offreService.ajouOffre(offre);
	}
	@DeleteMapping("/delete-offre/{id-offre}")
	@ResponseBody
	public void deleteOffre(@PathVariable("id-offre") int id){
		offreService.deleteOffre(id);
	}  
	@GetMapping("/retrieve-all-offres")
	@ResponseBody
	public List<Offre> getOffres(){
		List<Offre>listoffers=offreService.retrieveAllOffres();
		return listoffers;
}
	
	/*@GetMapping("/retrieve-all-offres")
	@ResponseBody
	public List<Offre> getOffres(){
		List<Offre> listoffres = offreService.retrieveAllOffres();
		return listoffres;}*/

	@PutMapping("/update-offre/{idOffre}")
	@ResponseBody
	public ResponseEntity<Offre> updateOffre(@PathVariable Integer idOffre ,@RequestBody Offre offreDetails) {
		Offre updateOffre= offreRepository.findById(idOffre).orElse(null);
		updateOffre.setType_offre(offreDetails.getType_offre());
		updateOffre.setCode(offreDetails.getCode());
		updateOffre.setDiscount(offreDetails.getDiscount());
		offreRepository.save(updateOffre);
		return ResponseEntity.ok(updateOffre);
		
	}
	@PostMapping("/add-listeOffre/{idPartner}")
	@ResponseBody
	void ajouterEtaffecterListeoffre(@RequestBody List<Offre> lb,@PathVariable("idPartner") int idPartner) {
		offreService.ajouterEtaffecterListeoffre(lb, idPartner);
	}
	
	@GetMapping("/liste-offre/{idPartner}")
	@ResponseBody
	List<Offre> listedeOffres(@PathVariable("idPartner") int idPartner){
		return offreService.listedeOffres(idPartner);
	}
	@GetMapping("/count-partner-offre/{id}")
	public int countOffrePartner(@PathVariable("id")int idPartner){
		
		
		return offreService.countOffrePartner(idPartner);
	}

}
