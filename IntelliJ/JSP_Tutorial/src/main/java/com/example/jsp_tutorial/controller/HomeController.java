package com.example.jsp_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({"/","/hello"})
    public String getHello(@RequestParam(value = "name", defaultValue = "world", required = true)
                                       String name,
                                        Model model){
        System.out.println("Inside the getHello");
        model.addAttribute("name" , name);
        return "hello";
    }
}
