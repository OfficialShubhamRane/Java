package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloFromSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(HelloFromSpringBootApplication.class, args);
		
		System.out.println("Hello from Spring boot");
		
		Student objStudent = context.getBean(Student.class);
		objStudent.show();
		
	}

}
