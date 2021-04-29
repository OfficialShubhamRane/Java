package com.example.rest_jpa_h2_boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

    @Id
    private int aid;
    private String aName;
    private String tech;

    public Alien() {

    }

    public Alien(int aid, String aName) {
        this.aid = aid;
        this.aName = aName;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                '}';
    }
}
