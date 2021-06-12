package com.example.moviecatalogservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieCatalogItems_Model {

    private String movieName;
    private String movieDesc;
    private int movieRating;


}
