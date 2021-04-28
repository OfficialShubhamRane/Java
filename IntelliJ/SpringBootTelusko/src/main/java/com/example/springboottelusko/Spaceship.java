package com.example.springboottelusko;

import org.springframework.stereotype.Component;

@Component
public class Spaceship {

//    private String model;
//    private int fuelLevel;

    private Spaceship() {
        System.out.println("Spaceship obj created");
    }

//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public int getFuelLevel() {
//        return fuelLevel;
//    }
//
//    public void setFuelLevel(int fuelLevel) {
//        this.fuelLevel = fuelLevel;
//    }

//    @Override
//    public String toString() {
//        return "Spaceship{" +
//                "model='" + model + '\'' +
//                ", fuelLevel=" + fuelLevel +
//                '}';
//    }

    public void takeOff(){
        System.out.println("Flying...");
    }

}
