package com.example.rest_jpa_h2_boot.controller;

import com.example.rest_jpa_h2_boot.AlienRepo;
import com.example.rest_jpa_h2_boot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("fetchAlien")
    public ModelAndView fetchAlien( int aid ){

        ModelAndView mv = new ModelAndView("fetched.jsp");
        Alien alien = alienRepo.findById(aid).orElse(new Alien());
        mv.addObject(alien);

        return mv;
    }

    @GetMapping("deleteAlien")
    public String deleteAlien(int aid){

        Alien alien = alienRepo.findById(aid).orElse(new Alien());
        alienRepo.delete(alien);
        return "home.jsp";
    }

    @GetMapping("getAlienByTech")
    public String getAlienByTech(){

        System.out.println("Un-Sorted: " + alienRepo.findByTech("Java"));
        System.out.println("Sorted: " + alienRepo.findByTechSorted("Java"));

        return "home.jsp";
    }

    // localhost:8080/alien
    @GetMapping("alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        return alienRepo.findById(aid);
    }

    @GetMapping("aliens")
    @ResponseBody
    public List<Alien> getAliens(){
        return alienRepo.findAll();
    }

}
