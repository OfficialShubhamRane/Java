package com.example.amigoscodespringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /** Retrieves all student data*/
    @GetMapping("/api/v1/getStudents")
    public List<StudentModel> getStudents(){
        return studentService.getStudent();
    }

//    @PostMapping("/api/v1/saveStudents")
//    public void saveStudents(@RequestBody StudentModel studentModel){
//        studentService.saveStudents(studentModel);
//    }

    /** Calls business login to save student data*/
    @GetMapping("/api/v1/saveStudents")
    public void saveStudents(){
        studentService.saveStudents();
    }

}
