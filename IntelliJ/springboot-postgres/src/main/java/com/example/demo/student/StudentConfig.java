package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student alex = new Student(
                    "alex",11, LocalDate.of(2000, 1,1), "alex@gmail.com"
            );
            Student shubham = new Student(
                    "shubham",12, LocalDate.of(2001, 1,1), "shubham@gmail.com"
            );


            studentRepository.saveAll(
                    List.of(alex,shubham)
            );
        };
    }
}
