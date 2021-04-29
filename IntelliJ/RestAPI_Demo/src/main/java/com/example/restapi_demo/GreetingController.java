package com.example.restapi_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    long id = 0;
    @GetMapping("greeting")
    public Greeting showGreeting(String name){
        return new Greeting(id++, name);
    }

}
