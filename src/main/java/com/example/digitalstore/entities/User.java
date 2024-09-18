package com.example.digitalstore.entities;

import jakarta.persistence.*;
import lombok.*;

//if we are using lombok ,the getter and setter will be automatically generated;
@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    //2. @GeneratedValue(strategy = GenerationType.IDENTITY) used to create random id but we create it by ourself
    @Column(name = "User_id")
    private String user_id;

    @Column(name = "User_name")
    private String user_name;

    @Column(name="User_email",unique = true)
    private String user_email;

    @Column(name = "User_password",length = 10)
    private String user_password;

    @Column(name = "User_gender")
    private String gender;


    @Column(name="User_about",length = 1000)
    private  String about;

    @Column(name="Image_name")
    private  String image_name;



}
