package com.example.springboottelusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

//    private int id;
//    private String name;
    @Autowired
    private Spaceship mySpaceship;

    public Alien() {
        System.out.println("Alien obj created");
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    @Override
//    public String toString() {
//        return "Alien{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }

    public void show(){
        System.out.println("Showing Alien");
        mySpaceship.takeOff();
    }

}
