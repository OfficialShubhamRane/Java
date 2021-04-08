package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {
	
	
	
}
