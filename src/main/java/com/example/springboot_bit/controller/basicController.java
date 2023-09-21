package com.example.springboot_bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class basicController {

    @GetMapping("/")
    public String basic(){
        return "page";
    }

}
