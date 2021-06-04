package com.example.amigoscodespringboot.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo
        extends JpaRepository<StudentModel, Long> {
}
