package com.esprit.pidev.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Evaluation;
import com.esprit.pidev.entities.Event;
import com.esprit.pidev.entities.Rate;
import com.esprit.pidev.entities.Rate_User;
import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ServiceImpIUser implements ServiceIUser ,UserDetailsService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired 
	RateUserRepository rateUserRepository;
	@Autowired
	RateRepository rateRepository;
	@Autowired
	EvaluationRepository evaluationRepository;
	
	@Autowired
	IEventRepository eventRepository;
	@Autowired
	IActivityRepository activityRepository;
	@Autowired
	IParticipationRepository participationRepository;
	@Autowired
	IAbonnementRepository abonnementRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		{
			User user = userRepository.findByUserName(username);
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>() ; 
			user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRole())) ; 
			});
			return new org.springframework.security.core.userdetails.User(user.getUserName(),
			user.getPassword(),user.isVerified(), true, true, true, authorities); 
		}
	}



	
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
		}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		user.setVerified(true);
		User user1 = userRepository.save(user); 
		Evaluation evaluation = new Evaluation();
		evaluation.setCompteur(0);
		evaluation.setScore(0);
		evaluation.setNbTrophee(0);
		evaluation.setUser(user1);
		evaluationRepository.save(evaluation);
		List<Rate> listRates = (List<Rate>) rateRepository.findAll();
		for(int i=0; i<listRates.size();i++){
			Rate_User rateUser = new Rate_User();
			rateUser.setNbDislike(0);
			rateUser.setNbLike(0);	
			rateUser.setRate(listRates.get(i));
			rateUser.setUser(user1);
			rateUserRepository.save(rateUser);
			
		}
		
		return user1; 
		
		 
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user  = userRepository.findByUserName(username) ; 
		Role role = roleRepository.findByRole(roleName) ; 
		user.getRoles().add(role); 
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	
	
	
	


	
	@Transactional
	public List< Event>retrieveAllEvents(){
		
		List <Event>EventList =new ArrayList<>();
		eventRepository.findAll().forEach(EventList::add);
		return EventList;
	}
	
	
	public void ajouterEtaffecterListeEvents(Event event, Long id_user) {
		User user=userRepository.findById(id_user).orElse(null);
		event.setUser(user);
		eventRepository.save(event);
		
	}
	
	@Override
	public Evaluation getEvaluationByUser(long idUser){
		User user= userRepository.findById(idUser).orElse(null);
		return evaluationRepository.getEvaluiationByUser(user);
	}
	
	@Override
	public List<User> getAllUserClasse(){
		return userRepository.getAllUsersClasseByPoints();
	}
	
	
	
	


}
