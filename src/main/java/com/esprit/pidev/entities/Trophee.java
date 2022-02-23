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
import javax.persistence.ManyToMany;
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
public class Trophee implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTrophee;
	
	@Column
	private String titre;
	
	@Column
	private String image;
	
	@Column
	private int nbLike;
	
	@Column
	private int nbDislike;
	
	@ManyToMany(mappedBy="trophees", cascade = CascadeType.ALL)
	private List<Evaluation> evaluations;
	
	@OneToMany(mappedBy="trophee", 
			cascade={CascadeType.PERSIST, CascadeType.REMOVE},
			fetch=FetchType.EAGER)
	private List<LikeTrophee> likeTrophees;
}
