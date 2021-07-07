package com.example.jsp_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({"/","/hello"})
    public String getHello(@RequestParam String name){
        return "hello";
    }
}
