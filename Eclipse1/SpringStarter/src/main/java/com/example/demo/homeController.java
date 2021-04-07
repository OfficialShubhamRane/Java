package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homeController {
	
	@RequestMapping("home")
	@ResponseBody
	public String show() {
		System.out.println("Entered in homeController");
		return "home.jsp";
		
	}
	

	
	
}
