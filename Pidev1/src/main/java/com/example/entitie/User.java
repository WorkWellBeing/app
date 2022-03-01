package com.example.entitie;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column
	private Long user_id;
	
	@Column
	private String name;
	@Enumerated(EnumType.STRING)
	private Role Role;
	
	@Column
	private int user_points;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="User",fetch=FetchType.LAZY)
	private List <publication> publications;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="User",fetch=FetchType.LAZY)
	private List <Commentaire> Commentaire;
	@OneToOne
	private Likee Likee;
    
	
	public static boolean isValid(String Email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (Email == null)
            return false;
        return pat.matcher(Email).matches();
        
       
    }
	
	
	

	
	
	

}