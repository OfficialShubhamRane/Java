package com.example.rest_jpa_h2_boot;

import com.example.rest_jpa_h2_boot.model.Alien;

import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository< Alien, Integer > {

}
