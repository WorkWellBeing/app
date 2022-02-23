package com.esprit.pidev.entities;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idp")
	Long idp;

	String description;
	String title;
	//@Temporal (TemporalType.DATE)
	private Date dateCreation = new Date(System.currentTimeMillis());

	@Enumerated(EnumType.STRING)
	private type typepost;
	@OneToMany( mappedBy="posts" ,cascade={CascadeType.PERSIST, CascadeType.REMOVE},
			fetch=FetchType.EAGER)

			

	private List<Comment> Comments;
	
	//@ManyToMany(mappedBy = "posts", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	//private List<User> user;



}
