package com.example.springbootwebapptelusko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @GetMapping("home")
    public ModelAndView showHome(Alien alienObj){

        System.out.println("log: Home place holder ");

        ModelAndView mv = new ModelAndView("home.jsp");
        mv.addObject("alienObj",alienObj);

        return mv;
    }

}
