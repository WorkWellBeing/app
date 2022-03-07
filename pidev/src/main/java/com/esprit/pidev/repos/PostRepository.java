package com.esprit.pidev.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Post;
import com.esprit.pidev.entities.type;


@Repository
public interface PostRepository extends JpaRepository<Post ,Long>  {
//	Set<Post> findAllByOrderByCreationDateDesc();
	//@Query("Select count(typepost) FROM Post where typepost ='Personal_advice' or  typepost ='General'")
	//@Query(" SELECT * FROM Comment WHERE commenta  LIKE %*%  ")
	//int getnbdate();
//	public List<Post> findByTitle(String title);
	@Query("SELECT p FROM Post p WHERE CONCAT(title ,description ,typepost) LIKE %?1%")
	public List<Post> search(String keyword);
	
	//@Query(value="select (COUNT(*)/(select COUNT(*) from Post )*100 , Type) from Post GROUP BY typepost") 
	//public List<CountType> getPercentageGroupeByType();
	//@Query("select count(*) From Post where typepost=?1") 
	//int getnbdate();
	//List<Post> getPercentageGroupType();
	
	public List<Post> findBytypepost(type typepost);
	@Query(value= "select * from Post   order by date_creation  desc",nativeQuery = true)
	List<Post> getAllpostbydate();
}