
package com.esprit.pidev.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Dislike;
import com.esprit.pidev.entities.Post;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.DislikeRepository;
import com.esprit.pidev.repos.IUserRepository;
import com.esprit.pidev.repos.PostRepository;




@Service
public class DislikeServiceImpl implements DislikeService {
	@Autowired
	DislikeRepository Dislikkerepository;
	@Autowired
	PostRepository postrepository;
	@Autowired
	IUserRepository userrep;
	@Override
	public Dislike adddislike(Dislike d) {
		// TODO Auto-generated method stub
		return Dislikkerepository.save(d);
	}
	
	public void dislikeservice(Dislike Dislike, Long id, Long idp) {
		// TODO Auto-generated method stub

		Post Post1 = postrepository.findById(idp).orElse(null);
	       User User = userrep.findById(id).orElse(null);
	       Dislike.setPosts(Post1);
	       Dislike.setUser(User);
	       Dislikkerepository.save(Dislike);
	}
	
	public String getNbrLikee4() {
		
		 String x="";
		 if (Dislikkerepository.getNbrLikee3()>Dislikkerepository.getNbrLikee2()){
			 x="Users are not satisfied";
		 }else {
			 x="Users are satisfied";
		 }
		return  x;
	}

	

	
}
