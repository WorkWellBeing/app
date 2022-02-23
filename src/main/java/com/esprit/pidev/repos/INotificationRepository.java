package com.esprit.pidev.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Notification;
@Repository
public interface INotificationRepository extends CrudRepository<Notification, Integer> {

}
