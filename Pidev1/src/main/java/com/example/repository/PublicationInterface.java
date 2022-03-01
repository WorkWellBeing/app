package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entitie.Likee;
import com.example.entitie.publication;

public interface PublicationInterface extends CrudRepository<publication, Long> {


//@Query("Select * FROM publication c Where c.Category =: Category")
//List<publication> getpublicationByName(@Param("a") String Category);


}
