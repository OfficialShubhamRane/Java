package com.example.ratingsdataservice.Controller;

import com.example.ratingsdataservice.Model.RatingsDataList_Model;
import com.example.ratingsdataservice.Model.RatingsData_Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/getRatingsData")
public class RatingsDataService_Controller {

//    @GetMapping("/{movieID}")
//    public RatingsData_Model getRatingsData(@PathVariable("movieID") String movieID){
//
//        RatingsData_Model demoRatingsData_model = new RatingsData_Model();
//        demoRatingsData_model.setMovieID(movieID);
//        demoRatingsData_model.setRating(3);
//
//        return  demoRatingsData_model;
//    }

    @GetMapping("/users/{userID}")
    public RatingsDataList_Model getUserRatingData(@PathVariable("userID") String userID){
        List<RatingsData_Model> ratingsList = Arrays.asList(
                new RatingsData_Model("1234", 4),
                new RatingsData_Model("5678", 5),
                new RatingsData_Model("1357", 2)
        );

        RatingsDataList_Model ratingsDataList_model = new RatingsDataList_Model();
        ratingsDataList_model.setRatingsData_List(ratingsList);
        return ratingsDataList_model;
    }
}
