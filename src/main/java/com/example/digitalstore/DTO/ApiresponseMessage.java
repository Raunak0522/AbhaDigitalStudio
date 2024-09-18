package com.example.digitalstore.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiresponseMessage {

    private String message;
    private  boolean success;

    private HttpStatus status;


}
