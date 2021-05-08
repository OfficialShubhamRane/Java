package com.example.covid19trackerapplication.controllers;

import com.example.covid19trackerapplication.model.LocationStats;
import com.example.covid19trackerapplication.service.Covid19DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    Covid19DataService covid19DataService;

    @GetMapping("/")
    public String home( Model model ){
        List<LocationStats> locationStats = covid19DataService.getAllStats();
        int totalNoReportedCases = locationStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        int newNoReportedCases = locationStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();

        model.addAttribute("locationStats", covid19DataService.getAllStats() );
        model.addAttribute("totalNoReportedCases", totalNoReportedCases );
        model.addAttribute("newNoReportedCases", newNoReportedCases);

        return "home";
    }
}
