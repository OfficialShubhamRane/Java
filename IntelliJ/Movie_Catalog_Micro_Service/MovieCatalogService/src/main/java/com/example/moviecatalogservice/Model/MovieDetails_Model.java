package com.example.moviecatalogservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetails_Model {

    private String movieID;
    private String movieName;
    private String movieDetails;
}
