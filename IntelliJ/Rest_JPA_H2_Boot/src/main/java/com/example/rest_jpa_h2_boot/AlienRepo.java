package com.example.rest_jpa_h2_boot;

import com.example.rest_jpa_h2_boot.model.Alien;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository< Alien, Integer > {

}
