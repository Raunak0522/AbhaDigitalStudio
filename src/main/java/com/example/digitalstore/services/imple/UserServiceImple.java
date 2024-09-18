package com.example.digitalstore.services.imple;

import com.example.digitalstore.DTO.UserDTO;
import com.example.digitalstore.entities.User;
import com.example.digitalstore.repositories.UserRepository;
import com.example.digitalstore.services.UserService;
import jakarta.persistence.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public UserDTO createUser(UserDTO userDTo) {
        String userID=UUID.randomUUID().toString();
        userDTo.setUser_id(userID + "Raunak");
        //DTo to user
        User user=DTOtoEntity(userDTo);
        User savedUser= userRepository.save(user);
        //entity to DTO
        UserDTO newDTO= EntitytoDTO(savedUser);
        return  newDTO;
    }

    private UserDTO EntitytoDTO(User savedUser) {
//        UserDTO userDTO=UserDTO.builder().user_id(savedUser.getUser_id()).user_name(savedUser.getUser_name())
//                .user_email(savedUser.getUser_email()).user_password(savedUser.getUser_password())
//                .gender(savedUser.getGender()).image_name(savedUser.getImage_name()).about(savedUser.getAbout()).build();

//        return userDTO;
        return  mapper.map(savedUser,UserDTO.class);
    }

    private User DTOtoEntity(UserDTO userDTo) {
//        User user=User.builder().user_id(userDTo.getUser_id()).user_name(userDTo.getUser_name())
//                .user_email(userDTo.getUser_email()).user_password(userDTo.getUser_password())
//                .gender(userDTo.getGender()).about(userDTo.getAbout())
//                .image_name(userDTo.getImage_name()).build();
//        return user;
        return mapper.map(userDTo,User.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userId) {

        User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        user.setUser_name(userDTO.getUser_name());
        user.setUser_email(userDTO.getUser_id());
        user.setUser_password(userDTO.getUser_password());
        user.setGender(userDTO.getGender());
        userDTO.setAbout(userDTO.getAbout());
        userDTO.setImage_name(userDTO.getImage_name());


        //save data

       User updateduser= userRepository.save(user);
        UserDTO updatedDTO=EntitytoDTO(updateduser);


        return updatedDTO;
    }

    @Override
    public void deleteUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public List<UserDTO> searchUser(String keyword) {
//        List<User> users=userRepository.findByNameContaining(keyword);
//        List<UserDTO> newDTO=users.stream().map(user -> EntitytoDTO(user)).collect(Collectors.toList());
//       return  newDTO;
        return null;
    }

    @Override
    public UserDTO getUserByID(String userID) {
       User user=userRepository.findById(userID).orElseThrow(()-> new RuntimeException("User not found"));
        return EntitytoDTO(user);
    }

    @Override
    public UserDTO getuserByemail(String email) {
//       User x = userRepository.findByUser_email(email).orElseThrow(()-> new RuntimeException("user not found"));

//        return EntitytoDTO(x);
        return null;
    }

    @Override
    public List<UserDTO> getAlluser() {
        List<User> users=userRepository.findAll();
        List<UserDTO> newDTO=users.stream().map(user -> EntitytoDTO(user)).collect(Collectors.toList());
        return newDTO;
    }
}
