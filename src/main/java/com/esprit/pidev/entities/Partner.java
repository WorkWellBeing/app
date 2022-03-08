package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partner implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPartner;
	private String title;
	private Date partnershipDate;
	private int points;
	

	@OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL,mappedBy ="partner")
	private Set<Offre> offres;
	@OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL,mappedBy = "partner")
	private Set<Ads> adss;
	
}
