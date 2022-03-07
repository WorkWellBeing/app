package com.esprit.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.pidev.BadWordFilter;
import com.esprit.pidev.entities.Post;
import com.esprit.pidev.entities.type;
import com.esprit.pidev.repos.PostRepository;
import com.esprit.pidev.services.PostService;
import com.esprit.pidev.services.PostServiceImpl;


@RestController
@RequestMapping("/post")

public class PostController {
	@Autowired
	PostService postservice;
	@Autowired
	PostServiceImpl Postservice;
	@Autowired
	PostRepository postrepo;
	@PostMapping("/add")
	@ResponseBody
	public Post addPost(@RequestBody Post p)
	{ 
		
	Post post =  postservice.addPost(p);
	return post;
	}
	@GetMapping("/AfficherPosttile/{keyword}")
	@ResponseBody
	
	public List<Post> listAll(@PathVariable("keyword") String keyword) {
        if (keyword != null) {
            return postrepo.search(keyword);
        }
		return null;
	}
	@GetMapping("/AfficherPosttype/{typepost}")
	@ResponseBody
	 List<Post> AfficherPosttype(@PathVariable("typepost")type typepost) {
		return postrepo.findBytypepost(typepost);
	}
	
	// http://localhost:8089/SpringMVC/post/retrieve-all-posts
		@GetMapping("/retrieve-all-posts")
		@ResponseBody
		public List<Post> getPosts() 
		{
		List<Post> listposts = postservice.retrieveAllPosts();
		return listposts;
		}
		// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
		@DeleteMapping("/remove-post/{idp}")
		@ResponseBody
		public void deletePost(@PathVariable("idp") Long idp) {
			postservice.deletePost(idp);
		}
		// http://localhost:8089/SpringMVC/post/modify-post
				@PutMapping("/modify-post")
				@ResponseBody
				public Post updatePost(@RequestBody Post p) {
				return postservice.updatePost(p);
				}

				//http://localhost:8089/SpringMVC/add-post/{id}

				
				@PostMapping("/add-post/{id}")
				@ResponseBody
				public Post  addc (@RequestBody Post p,@PathVariable ("id") Long id) {
				p.setDescription( BadWordFilter.getCensoredText(p.getDescription()));
			
					Post listpos =postservice.addc(p, id);
					return listpos;
				}
			
				@GetMapping("/retrieve-all-posttriee")
				@ResponseBody
				public List<Post> getAllpostbydate() {
				return postrepo.getAllpostbydate(); 
				}
				
				//@GetMapping("/percentageType")
				//List<CountType> getPercentageGroupeByType()
				//{
				//return Postservice.getPercentageGroupeByType();
				//}
				//@GetMapping("/test")
				//@ResponseBody
				//public int getnbdate()
				//{
					
						//return Postservice.getNbdate();
				
				
				//}

}
