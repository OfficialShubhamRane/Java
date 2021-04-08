package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
	
	@RequestMapping("home")
	public ModelAndView show(@RequestParam("name") String myName, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		return mv ;
		
	}
}
