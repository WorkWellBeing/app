package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ; 
	@Column
	private String userName ; 
	@Column
	private String Name ; 
	@Column
	private String lastName ; 
	@Column
	private Date birthDate ; 
	@Column
	private String currentPosition ; 
	@Column
	private int phone ; 
	@Column
	private String email ; 
	@Column
	private String password ; 
	@Column
	private boolean isVerified; 
	@Column
	private boolean isAbrroved; 
	@Column
	private int points ; 
	
	
	@ManyToMany(cascade={CascadeType.PERSIST} , fetch =FetchType.EAGER ) 
	private Set<Role> roles ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user",fetch=FetchType.LAZY)
	private  Set<Post> posts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List <Comment> comments;
	
	
	
	@OneToMany( mappedBy="user" ,cascade={CascadeType.ALL})
private List<Formulaire> formulairess;
	
	
	
	@JsonIgnore
	private Departement departement;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String userName, String name, String lastName, Date birthDate, String currentPosition,
			int phone, String email, String password, boolean isVerified,boolean isAbrroved ,Departement departement ,  int points, List<Notification> notifications,
			Set<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		Name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.currentPosition = currentPosition;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.isVerified = isVerified;
		this.points = points;
		
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id =  id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public boolean isAbrroved() {
		return isAbrroved;
	}
	public void setAbrroved(boolean isAbrroved) {
		this.isAbrroved = isAbrroved;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	

	
	

}
