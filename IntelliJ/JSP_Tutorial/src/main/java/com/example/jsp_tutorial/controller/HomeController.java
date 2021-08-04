package com.example.jsp_tutorial.controller;

import com.example.jsp_tutorial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(){
        System.out.println("Inside the index");
        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model){
        System.out.println("In the register");
        User user = new User();
        model.addAttribute("user", user);

        List<String> highestEdu_List = new ArrayList<>();
        highestEdu_List.add("Matser's");
        highestEdu_List.add("Bachelor's");
        highestEdu_List.add("Associate's");
        model.addAttribute("highestEdu_List", highestEdu_List);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user){
        System.out.println("Submitting: " + user);
        return "register_successful";
    }

    @GetMapping("/expression-test")
    public String expressionTest(){
        return "expression-test";
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }


}
