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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.entities.Activity;
import com.esprit.pidev.entities.Department;
import com.esprit.pidev.entities.Event;
import com.esprit.pidev.repos.IActivityRepository;
import com.esprit.pidev.services.*;

@RestController
@RequestMapping("/Act")
public class ActivityController {
	@Autowired
	IActivityRepository activityRepository;
	@Autowired
	ActivityService activityService;
	@Autowired
	IUserService userService;
	
	@PostMapping("/add-act/{user_id}")
	public void addEvent(@RequestBody Activity act,@PathVariable(value = "user_id") Long id_user ) 
	{
		activityService.ajouterEtaffecterListeActs(act, id_user);

	}
	
	@DeleteMapping("/delete-act/{activity_id}")
	@ResponseBody
	public void deleteAct(@PathVariable("activity_id") Integer activity_id){
		activityService.deleteAct(activity_id);
	}
	

	@PutMapping("/update-act/{activity_id}")
	@ResponseBody
	public  ResponseEntity<Activity> updateAct(@PathVariable Integer activity_id ,@RequestBody Activity activitytDetails) {
		Activity updateAct= activityRepository.findById(activity_id).orElse(null);
		updateAct.setActivity_name(activitytDetails.getActivity_name());
		updateAct.setDescription(activitytDetails.getDescription());
		updateAct.setPoint(activitytDetails.getPoint());
		
		activityRepository.save(updateAct);
		return ResponseEntity.ok(updateAct);
		
	}
	
	@GetMapping("/show-acts")
	@ResponseBody
	public List<Activity>findallacActivities(){
		return activityService.findallacActivities();
	}

}
