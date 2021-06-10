package com.example.ratingsdataservice.Controller;

import com.example.ratingsdataservice.Model.RatingsData_Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/getRatingsData")
public class RatingsDataService_Controller {

    @GetMapping("/{movieID}")
    public RatingsData_Model getRatingsData(@PathVariable("movieID") String movieID){

        RatingsData_Model demoRatingsData_model = new RatingsData_Model();
        demoRatingsData_model.setMovieID(movieID);
        demoRatingsData_model.setRating(3);

        return  demoRatingsData_model;
    }
}
