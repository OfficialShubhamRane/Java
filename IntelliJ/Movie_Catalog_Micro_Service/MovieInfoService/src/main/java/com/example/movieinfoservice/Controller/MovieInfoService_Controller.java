package com.example.movieinfoservice.Controller;

import com.example.movieinfoservice.Model.MovieDetails_Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getMovieInfo")
public class MovieInfoService_Controller {

    @GetMapping("/{movieID}")
    public MovieDetails_Model getMovieDetails(@PathVariable("movieID") String movieID){

        MovieDetails_Model demoMovieDetails_object = new MovieDetails_Model();
        demoMovieDetails_object.setMovieID(movieID);
        demoMovieDetails_object.setMovieName("Hobbit");
        demoMovieDetails_object.setMovieDetails("Very nice");

        return  demoMovieDetails_object;

    }

}
