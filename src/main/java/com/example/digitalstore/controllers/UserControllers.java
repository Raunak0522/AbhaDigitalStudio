package com.example.digitalstore.controllers;

import com.example.digitalstore.DTO.ApiresponseMessage;
import com.example.digitalstore.DTO.UserDTO;
import com.example.digitalstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserControllers {

    @Autowired
    private UserService userService;
    //create user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody  UserDTO userDTO){
        UserDTO userDTO1=userService.createUser(userDTO);

    return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
    }

    //update user
    @PostMapping("/{userId}")//dynamic user method

    public ResponseEntity<UserDTO> updateUser(
            @PathVariable ("userId") String userId,@RequestBody UserDTO userDTO ){
         UserDTO updatedUserDTO=userService.updateUser(userDTO,userId);
         return  new ResponseEntity<>(updatedUserDTO,HttpStatus.OK);
    }


    //deletemapping
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiresponseMessage> deleteUser(@PathVariable ("userId") String userId ){
        userService.deleteUser(userId);

        ApiresponseMessage messages= ApiresponseMessage
                .builder()
                .message("User is deleted succesfully")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }


    //getall
    @GetMapping
    public ResponseEntity<List<UserDTO>>getAllusers(){
        return  new ResponseEntity<>(userService.getAlluser(),HttpStatus.OK);
    }


    //get single user
    @GetMapping("/{users}")
    public ResponseEntity<UserDTO> getUser(@PathVariable ("users") String userId){
        return new ResponseEntity<>(userService.getUserByID(userId),HttpStatus.OK);
    }

    //get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getuserByemail(email),HttpStatus.OK);
    }

    //serach user
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<UserDTO>> searchUser(@PathVariable  String keywords){
        return new ResponseEntity<>(userService.searchUser(keywords),HttpStatus.OK);
    }






}
