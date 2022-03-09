package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Notification;
import com.esprit.pidev.entities.User;


@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
    
  

}
