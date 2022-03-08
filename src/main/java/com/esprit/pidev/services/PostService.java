package com.esprit.pidev.services;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.esprit.pidev.entities.Post;


public interface PostService {
	Post addPost(Post post);

List<Post> retrieveAllPosts();

void deletePost(Long id);
Post updatePost(Post p);
Post addc(Post p, Long id);

Set<Post> findAllByOrderByCreationDateDesc();

}
