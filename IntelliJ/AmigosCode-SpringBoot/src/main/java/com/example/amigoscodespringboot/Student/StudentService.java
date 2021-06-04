package com.example.amigoscodespringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<StudentModel> getStudent(){

        studentRepo.save(
                new StudentModel(
                        1L,
                        "Shubham Rane",
                        LocalDate.of(1997, 9, 29),
                        24,
                        "xyz.com"
                )
        );

        return List.of(
                new StudentModel(
                        1L,
                        "Shubham Rane",
                        LocalDate.of(1997, 9, 29),
                        24,
                        "xyz.com"
                )
        );

    }


}
