package com.example.amigoscodespringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    /** Returns data from database */
    public List<StudentModel> getStudent(){
        return studentRepo.findAll();
    }

    /** Saves Data into Database */
    public void saveStudents(){
        studentRepo.save(
                new StudentModel(
                        1L,
                        "Shubham Rane",
                        LocalDate.of(1997, 9, 29),
                        "xyz.com"
                )
        );
    }

}
