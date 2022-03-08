package com.esprit.pidev.entities;


import java.io.Serializable;
import java.util.Date;

import javax.management.Query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class Participation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	/**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int part_id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate=new Date(System.currentTimeMillis());
	
	@Column
	private int rate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date Edate;
	
	@ManyToOne
	
	@JoinColumn(name = "event_id",referencedColumnName = "event_id")
	//@JoinColumn(name = "eventDate",referencedColumnName = "eventDate")})
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;

}
