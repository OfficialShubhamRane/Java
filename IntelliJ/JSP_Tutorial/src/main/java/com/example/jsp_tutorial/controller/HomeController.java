package com.example.jsp_tutorial.controller;

import com.example.jsp_tutorial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(){
        System.out.println("Inside the index");
        return "index";
    }

    @GetMapping("/register")
    public String registerApplication(Model model){
        System.out.println("In the register");
        User user = new User();
        model.addAttribute(user);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user){
        System.out.println("Submitting: " + user);
        return "register_successful";
    }

}
