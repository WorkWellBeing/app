package com.esprit.pidev.services;

import com.esprit.pidev.entities.Comment;

public interface CommentService {
	Comment addcomment(Comment com );

	void deletecomment(Long id);
	void deletecom(Comment com);

	Comment addc(Comment c, Long id);
	Comment updateComment(Comment c);

	public void	ajouterEtaffecterListeComment(Comment comment, Long idp,Long idUser);	
}
