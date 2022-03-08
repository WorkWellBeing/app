package com.esprit.pidev.services;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Post;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.CommentRepository;
import com.esprit.pidev.repos.IUserRepository;
import com.esprit.pidev.repos.PostRepository;



@Service
public class PostServiceImpl implements PostService{
	@Autowired
	PostRepository postrepository;
	@Autowired
	CommentRepository repositorycomment;
	@Autowired
	IUserRepository userRepositoey;
	
	
	@Override
	public Post addPost(Post p) {
		// TODO Auto-generated method stub
		 return postrepository.save(p);
	}

	
	

	@Override
	public List<Post> retrieveAllPosts() {
		// TODO Auto-generated method stub
		return (List<Post>)postrepository.getAllpostbydate();

	}

	@Override
	public void deletePost(Long id) {
		// TODO Auto-generated method stub
		postrepository.deleteById( id);

		
	}



	public List<Post> getpost()
	{
	return postrepository.getAllpostbydate();
	}

	@Override
	public Post addc(Post p, Long id) {
		// TODO Auto-generated method stub
		java.util.Optional<User> u = userRepositoey.findById(id); 
		User u2=u.get();
			p.setUser(u2);      
			return postrepository.save(p);
	}




	








//@Scheduled(cron = "*/30 * * * * *")
//	public int getNbdate() {
	
		//return  postrepository.getnbdate();
	//}
	


//public List<Post> getPostByTitle(String title)
//{
//return postrepository.findByTitle(title);




//public List<Post> getPercentageGroupType()
{
// return (List<Post>)postrepository.getPercentageGroupType();
}













@Override
public Post updatePost(Post p) {
	// TODO Auto-generated method stub
	return null;
}




@Override
public Set<Post> findAllByOrderByCreationDateDesc() {
	// TODO Auto-generated method stub
	return null;
}








//public List<CountType> getPercentageGroupeByType(){
//	return postrepository.getPercentageGroupeByType();
	
}
//}
	//@Override
//	public Post addc(Post p, Long id) {
	//	// TODO Auto-generated method stub
	//	Optional<User> u = userRepositoey.findById(id); 
	////	User u2=u.get();
	//	p.setUsers(users);      
	//	return postrepository.save(p);
//	}

	

