package com.example.restapi_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    String template = "Hello %s";
    AtomicLong id = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting showGreeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(id.incrementAndGet(), String.format(template, name));
    }

}
