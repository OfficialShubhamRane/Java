package com.example.amigoscodespringboot.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentModel, Integer> {
}
