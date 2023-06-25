package com.example.springbootsecurity.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private static final List<Student> studentsList = Arrays.asList(
            new Student(1001,"shubham rane"),
            new Student(1002, "shubham bane")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
         return studentsList.stream().filter(student -> studentId.equals(student.getStudentId()))
                 .findFirst()
                 .orElseThrow(()->new IllegalStateException("Student " + studentId + " does not exist"));
    }
}
