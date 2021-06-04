package com.example.amigoscodespringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/api/v1/getStudents")
    public List<StudentModel> getStudents(){
        return studentService.getStudent();
    }

    @GetMapping("/api/v1/saveStudents")
    public void saveStudents(){
        studentService.saveStudents();
    }

}
