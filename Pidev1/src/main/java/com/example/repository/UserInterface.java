package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entitie.User;

@Repository
public interface UserInterface extends CrudRepository<User, Long> {


}
