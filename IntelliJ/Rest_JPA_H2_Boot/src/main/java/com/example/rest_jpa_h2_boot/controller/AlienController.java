package com.example.rest_jpa_h2_boot.controller;

import com.example.rest_jpa_h2_boot.AlienRepo;
import com.example.rest_jpa_h2_boot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {

    @Autowired
    AlienRepo alienRepo;

    /** Directs to home page */
    @GetMapping("home")
    public String home(){
        return "home.jsp";
    }

    /** Adds new Alien to H2 DB using JpaRepository methods */
    @GetMapping("addAlien")
    public String addAlien(Alien alien){
        alienRepo.save(alien);
        return "home.jsp";
    }

    /** Fetches an Alien with specifies aid in JSON format
     * @return */
    @GetMapping("fetchAlien")
    @ResponseBody
    public Optional<Alien> fetchAlien(int aid ){
        return alienRepo.findById(aid);
    }

    /** Deletes an alien with specified aid */
    @GetMapping("deleteAlien")
    public String deleteAlien(int aid){
        Alien alien = alienRepo.findById(aid).orElse( new Alien() );
        alienRepo.delete(alien);
        return "home.jsp";
    }


    /** FROM HERE STARTS THE REST OPERATIONS */

    /** fetches all the aliens in JSON format */
    @GetMapping("getAllAliens")
    @ResponseBody
    public List<Alien> getAliens(){
        return alienRepo.findAll();
    }

    /** Fetches an alien with specified aid in the URL in JSON format */
    @GetMapping("getAlien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        return alienRepo.findById(aid);
    }

    @GetMapping("addAlienREST/{aid}/{aName}/{tech}")
    @ResponseBody
    public Alien addAlien( @PathVariable("aid")int aid,
                                     @PathVariable("aName") String aName,
                                     @PathVariable("tech") String tech ){
        Alien newAlien = new Alien();
        newAlien.setAid(aid);
        newAlien.setaName(aName);
        newAlien.setTech(tech);

        alienRepo.save(newAlien);
        return newAlien;
    }

    @GetMapping("deleteAlien/{aid}")
    @ResponseBody
    public Optional<Alien> deleteAlienRest( @PathVariable("aid") int aid){
        Alien alien = alienRepo.findById(aid).orElse( new Alien() );
        Optional<Alien> deletedObject = alienRepo.findById(aid);
        alienRepo.delete(alien);

        return deletedObject;
    }




}