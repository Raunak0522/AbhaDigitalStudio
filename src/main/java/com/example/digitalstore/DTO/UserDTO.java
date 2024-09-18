package com.example.digitalstore.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {


    private String user_id;


    private String user_name;


    private String user_email;


    private String user_password;


    private String gender;



    private  String about;


    private  String image_name;


}
