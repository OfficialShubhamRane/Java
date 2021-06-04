package com.example.amigoscodespringboot.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo
        extends JpaRepository<StudentModel, Long> {

    /** Check if email exists before saving */
    @Query("SELECT s FROM StudentModel s WHERE s.email = ?1")
    Optional<StudentModel> findStudentByEmail (String email);
}
