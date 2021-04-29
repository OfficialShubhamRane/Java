package com.example.rest_jpa_h2_boot.controller;

import com.example.rest_jpa_h2_boot.AlienRepo;
import com.example.rest_jpa_h2_boot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlienController {

    @Autowired
    AlienRepo alienRepo;

    @GetMapping("home")
    public String home(){
        System.out.println("log: Inside home controller");
        return "home.jsp";
    }

    @GetMapping("addAlien")
    public String addAlien(Alien alien){
        System.out.println("Submitting Alien data");

        alienRepo.save(alien);
        return "home.jsp";
    }


}
