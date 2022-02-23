package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name="Abonnement")
public class Abonnement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date endingDate;
	
	@Column
	private boolean isFavourite;
	
	@Column
	private int note;
	
	@Column
	private long price;
	
	@Column
	private String comment;
	
	@ManyToOne
	private Activity activity;
	
	@ManyToOne
	private User user;
	
	
	

}
