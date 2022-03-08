package com.esprit.pidev.entities;
import lombok.*;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class Event implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int event_id;

	@Column
    @Temporal(TemporalType.DATE)
   
    private Date eventDate;

    @Column
    
    private String EventName;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column
    private int points;
    
    private String location;
    
    private int capacity;
    
    @JsonBackReference
    @ManyToOne
       
        private User user;
    
  @OneToMany(targetEntity = Participation.class,cascade = CascadeType.ALL, mappedBy="event")
  
    
    private Set<Participation> participations=new HashSet<Participation>();
}