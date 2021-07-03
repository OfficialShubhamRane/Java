package com.example.demo.controller;

import com.example.demo.model.Demo_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo_Controller {

    @Autowired
    Demo_model demo_model;

    @GetMapping("demo")
    @ResponseBody
    public Demo_model getDemoData(){
        System.out.println("Demo");

        demo_model.setVin("a5s6fd9f7s3");
        demo_model.setMake("Honda");
        demo_model.setModel("Accord 2019");

        return demo_model;
    }

    @GetMapping("demoArray")
    @ResponseBody
    public Demo_model[] getDemoArray(
            @RequestBody Demo_model[] demoData_Array){

        System.out.println(demoData_Array);
        return demoData_Array;
    }
}
