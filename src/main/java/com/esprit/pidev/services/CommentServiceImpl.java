package com.esprit.pidev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Comment;
import com.esprit.pidev.entities.Post;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.CommentRepository;
import com.esprit.pidev.repos.IUserRepository;
import com.esprit.pidev.repos.PostRepository;

import java.util.Optional;



@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentRepository commentrepository;
	@Autowired
	PostRepository postrepository;
	@Autowired
	IUserRepository userrep;
	@Override
	public Comment addcomment(Comment com) {
		// TODO Auto-generated method stub
		return  commentrepository.save(com);
	}

	@Override
	public void deletecomment(Long id) {
		// TODO Auto-generated method stub
		commentrepository.deleteById(id);
		
	}

	@Override
	public void deletecom(Comment com) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment addc(Comment c, Long id) {
		
			
			Optional<Post> p =postrepository.findById(id); 
			Post c2=p.get();
			c.setPosts(c2);
			return commentrepository.save(c);
		}

	@Override
	public Comment updateComment(Comment c) {
		// TODO Auto-generated method stub
		return commentrepository.save(c);

	}

	@Override
	public void ajouterEtaffecterListeComment(Comment comment, Long idp, Long idUser) {


		Post Post = postrepository.findById(idp).orElse(null);
	       User User = userrep.findById(idUser).orElse(null);
		comment.setPosts(Post);
		comment.setUser(User);
		commentrepository.save(comment);
	}

	
	}

	

	
	
		
	
	

	
	

	

	
	
