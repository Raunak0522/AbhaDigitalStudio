package com.example.digitalstore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeControllers {

    @GetMapping
    public String test(){
        return "Hi from backend";
    }
}
