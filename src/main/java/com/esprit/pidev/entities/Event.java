package com.esprit.pidev.entities;

import lombok.*;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="event")
    private List<Participation> Participations;
}