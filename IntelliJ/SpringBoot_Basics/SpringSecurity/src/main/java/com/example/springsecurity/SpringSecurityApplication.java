package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}

@RestController
class HelloWorld{

    @GetMapping("/")
    public String getHelloWorld(){
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/user")
    public String getUser(){
        return "<h1>Hello User</h1>";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "<h1>Hello Admin</h1>";
    }

}