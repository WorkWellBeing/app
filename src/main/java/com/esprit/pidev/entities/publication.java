package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class publication implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpublication;
	
	private String Category;
	
	private String imageUrl;
	
	private int Prix_dentree;

	
	
	@Temporal(TemporalType.DATE)
	private Date Date_debut;
	
	@Temporal(TemporalType.DATE)
	private Date Date_fin;
	@ManyToOne
	@JoinColumn(name = "User")
	private User User;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
	private Set <Commentaire> Commentaire;
	
	

}
