package com.example.moviecatalogservice.Controller;

import com.example.moviecatalogservice.Model.MovieCatalogItems_Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("api/getMovieCatalog")
public class MovieCatalogService_Controller {

    @GetMapping("/{userID}")
    public List<MovieCatalogItems_Model> getMovieCatalog(@PathVariable("userID") String userID){

        MovieCatalogItems_Model demoMovie_Object = new MovieCatalogItems_Model();
        demoMovie_Object.setMovieName("Avengers");
        demoMovie_Object.setMovieDesc("Ekdum mast");
        demoMovie_Object.setMovieRating(5);

        return Collections.singletonList(demoMovie_Object);
    }

}
