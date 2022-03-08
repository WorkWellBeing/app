package com.esprit.pidev.services;

import java.util.List;

import com.esprit.pidev.entities.Activity;
import com.esprit.pidev.entities.Department;
import com.esprit.pidev.entities.Event;

public interface ActivityService {
	public void ajouterEtaffecterListeActs(Activity act, Long id_user);
	public void deleteAct(Integer activity_id);
	public Department updateAct(Activity activity);
	public List<Activity>findallacActivities();

}
