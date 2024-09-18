package com.example.digitalstore.services;

import com.example.digitalstore.DTO.UserDTO;
import com.example.digitalstore.entities.User;

import java.util.List;


public interface UserService {

    //create user
//   User createUser(User user);
    // using userDTO
    UserDTO createUser(UserDTO userDTo );

    //update user

    UserDTO updateUser(UserDTO userDTO,String userId);


    //delete user
    void  deleteUser(String userId);


    //search user
    List<UserDTO> searchUser(String keyword);

    //getuser
    UserDTO getUserByID(String userID);

    //get getuserByemail
    UserDTO getuserByemail(String email);

    //getallUser
    List<UserDTO> getAlluser();


}
