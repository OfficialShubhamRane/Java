package com.example.application.backend.entity;

import com.example.application.backend.entity.AbstractApplicationEntity;
import com.example.application.backend.entity.Application;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Company extends AbstractApplicationEntity {
    private String name;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Application> employees = new LinkedList<>();

    public Company() {
    }

    public Company(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Application> getEmployees() {
        return employees;
    }
}