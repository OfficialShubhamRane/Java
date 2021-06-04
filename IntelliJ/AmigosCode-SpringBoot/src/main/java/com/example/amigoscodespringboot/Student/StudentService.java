package com.example.amigoscodespringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

//    /** Saves Data into Database
//     * @param studentModel*/
//    public void saveStudents(StudentModel studentModel){
//        System.out.println(studentModel);
//    }

    /** Save student */
    public void saveStudents() {

        StudentModel studentModel = new StudentModel(
                "Shubham Rane",
                LocalDate.of(1997, 9, 29),
                "xyz.com"
        );
        studentRepo.save(studentModel);

        /** To check if email already exists are throw an exception */
        studentModel = new StudentModel(
                "Shubham Rane",
                LocalDate.of(1997, 9, 29),
                "xyz.com"
        );

        Optional<StudentModel> studentByEmail = studentRepo.findStudentByEmail(studentModel.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepo.save(studentModel);

    }



}
