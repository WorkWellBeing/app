package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	
	@Column
	private int rate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Status state;
	
	@ManyToOne
	private Event event;
	
	@ManyToOne
	private User user;
}
