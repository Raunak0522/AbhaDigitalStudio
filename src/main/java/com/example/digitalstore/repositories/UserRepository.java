package com.example.digitalstore.repositories;

import com.example.digitalstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

//    Optional<User> findByUser_email(String email);
//    //optional will return user is there or not
//
//    Optional<User> findByUser_emailAndPassword(String email,String password);
//
//    List<User> findByNameContaining(String keyword);



}
