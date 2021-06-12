package com.example.moviecatalogservice.Controller;

import com.example.moviecatalogservice.Model.MovieCatalogItems_Model;
import com.example.moviecatalogservice.Model.MovieDetails_Model;
import com.example.moviecatalogservice.Model.RatingsDataList_Model;
import com.example.moviecatalogservice.Model.RatingsData_Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/getMovieCatalog")
public class MovieCatalogService_Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userID}")
    public List<MovieCatalogItems_Model> getMovieCatalog(@PathVariable("userID") String userID){

        /** Get all the rated movies IDs */
        RatingsDataList_Model ratingObject = restTemplate.getForObject(
                "http://localhost:8083/api/getRatingsData/users/"+userID,
                RatingsDataList_Model.class);

        return ratingObject.getRatingsData_List().stream().map(rating -> {
            /** Get their name and Description from MovieInfoService  */
            MovieDetails_Model movieObject = restTemplate
                    .getForObject("http://localhost:8082/api/getMovieInfo/" + rating.getMovieID(), MovieDetails_Model.class);

            /** Combine it all together */
            return new MovieCatalogItems_Model(
                    movieObject.getMovieName(),
                    movieObject.getMovieDetails(),
                    rating.getRating());
        })
                .collect(Collectors.toList());
    }

}
