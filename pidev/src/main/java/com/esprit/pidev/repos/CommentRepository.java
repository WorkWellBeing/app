package com.esprit.pidev.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Comment;




@Repository

public interface CommentRepository extends JpaRepository<Comment ,Long> {
	
	//@Query(" SELECT count(*)FROM Comment WHERE commenta =LIKE %*%  ")
//	int getnbdate();
	//@Query("SELECT c FROM Comment c JOIN c.post p p.class")
	//List<Comment> findByPost (Post p);
}
