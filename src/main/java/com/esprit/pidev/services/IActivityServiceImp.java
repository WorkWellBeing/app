package com.esprit.pidev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.*;
import com.esprit.pidev.repos.*;
@Service
public class IActivityServiceImp implements ActivityService {
@Autowired
IActivityRepository activityRepository;
@Autowired
IUserRepository userRepository;
	
@Override
	public void ajouterEtaffecterListeActs(Activity act, Long id_user) {
		
	User user=userRepository.findById(id_user).orElse(null);
	act.setUser(user);
	activityRepository.save(act);
	}

@Override
public void deleteAct(Integer activity_id) {
	activityRepository.deleteById(activity_id);
	
}

@Override
public Department updateAct(Activity activity) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Activity> findallacActivities() {
	return (List<Activity>) activityRepository.findAll();
}




}
