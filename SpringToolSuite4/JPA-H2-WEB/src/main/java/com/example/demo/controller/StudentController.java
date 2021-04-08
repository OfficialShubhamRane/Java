package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDAO studDAO;
	
	
	@RequestMapping("/")
	public String show() {
		return "home.jsp";
	}
	
	@RequestMapping("/addStudent")
	public  String addStudent(Student studentObj) {
		
		studDAO.save(studentObj);
		return "home.jsp";
	}

}
