package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rate_User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRate_User;
	
	@Column
	private int nbLike;
	
	@Column
	private int nbDislike;
	
	@ManyToOne
	Rate rate;
	
	@ManyToOne
	User user;
	
	@OneToMany(mappedBy="rateUser", 
			cascade={CascadeType.PERSIST, CascadeType.REMOVE},
			fetch=FetchType.LAZY)
	private List<Rater> raters;
	
}
