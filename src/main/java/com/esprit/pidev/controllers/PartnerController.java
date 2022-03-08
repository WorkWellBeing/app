package com.esprit.pidev.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.esprit.pidev.entities.Partner;
import com.esprit.pidev.repos.PartnerRepository;
import com.esprit.pidev.services.IPartnerService;





@RestController

public class PartnerController {
	@Autowired
	IPartnerService partnerService;
	@Autowired
   PartnerRepository partnerRepository;
	
	@PostMapping("/ajouter-partner")
	@ResponseBody
	public Partner ajouterPartner(@RequestBody Partner partner) {
		return partnerService.ajouterPartner(partner);
	}

	@PostMapping("/addd-partner")
	@ResponseBody
	public void ajouPartner(@RequestBody Partner partner) {
		partnerService.ajouPartner(partner);
	}
	@PostMapping("/ajout-partner")
	@ResponseBody
	public void ajoutPartner(@RequestBody Partner partner) {
		partnerService.ajouPartner(partner);
	}
	
	
	

	@DeleteMapping("/delete-partner/{id-partner}")
	@ResponseBody
	public void deletePartner(@PathVariable("id-partner") int id){
		partnerService.deletePartner(id);
	}

	@PutMapping("/update-partner/{idPartner}")
	@ResponseBody
	public ResponseEntity<Partner> updatePartner(@PathVariable Integer idPartner ,@RequestBody Partner partnerDetails) {
		Partner updatePartner= partnerRepository.findById(idPartner).orElse(null);
		updatePartner.setTitle(partnerDetails.getTitle());
		updatePartner.setPartnershipDate(partnerDetails.getPartnershipDate());
		updatePartner.setPoints(partnerDetails.getPoints());
		partnerRepository.save(updatePartner);
		return ResponseEntity.ok(updatePartner);
		
	}
	@GetMapping("/retrieve-all-partners")
	@ResponseBody
	public List<Partner> getPartners(){
		return partnerService.retrieveAllPartners();
}

	
	@GetMapping("/search/{keyword}") 
    public List<Partner> listAll(@PathVariable("keyword") String keyword) {
        if (keyword != null) {
            return partnerRepository.search(keyword);
        }
        return (List<Partner>) partnerRepository.findAll();
    }
}