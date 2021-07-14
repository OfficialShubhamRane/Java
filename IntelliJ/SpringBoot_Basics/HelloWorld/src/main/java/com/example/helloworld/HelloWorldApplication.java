package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * This application handles simple hello <person_name> GET requests
 * Input parameters are accepted as a Path variable
 * Output is returned as String
 * */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}

@Controller
@ResponseBody
class HelloWorld_controller{

    @Autowired
    HelloWorld_service helloWorld_service;

    @RequestMapping(value = {"/","/{name}", "/hello/{name}"}, method = RequestMethod.GET)
    public String getHelloWorld(@PathVariable(required = false) String name){
        return helloWorld_service.getHelloWorld(name);
    }
}

@Service
class HelloWorld_service{

    @Autowired
    HelloWorld_repo helloWorld_repo;

    public String getHelloWorld(String name){

        if( name == null || name.equalsIgnoreCase("hello") ){
            return helloWorld_repo.getHelloWorld();
        }else{
            return helloWorld_repo.getHelloWorld() + name;
        }

    }
}

@Repository
class HelloWorld_repo{
    public String getHelloWorld(){
        return "Hello ";
    }
}