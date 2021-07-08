package com.example.jsp_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHello(@RequestParam(value = "name", defaultValue = "world", required = true)
                                        String name,
                                        Model model){
        System.out.println("Inside the getHello");
        return "index";
    }

    @GetMapping("/register")
    @ResponseBody
    public String registerApplication(){
        System.out.println("In the register");
        return "Successfully registered";
    }
}
