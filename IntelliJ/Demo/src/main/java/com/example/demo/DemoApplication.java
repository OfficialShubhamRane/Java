package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /** By default Page **/
    @GetMapping("/")
    public String index(){
        return "Welcome";
    }

    /** for /hello url with parameters **/
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    /** for /greetings with parameters **/
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";
    @GetMapping("/greeting")
    public model_Greetings greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new model_Greetings(counter.incrementAndGet(), String.format(template, name));
    }


}
