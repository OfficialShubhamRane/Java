package com.example.springdemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @GetMapping()
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Shubham",
                        "shubham.rane@gmail.com",
                        LocalDate.of(1997, 9,29),
                        23
                )


        );
    }

}
