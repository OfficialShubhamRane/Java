package com.example.rest_jpa_h2_boot;

import com.example.rest_jpa_h2_boot.model.Alien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository< Alien, Integer > {

    List<Alien> findByTech(String tech);

    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where tech= ?1 order by aName")
    List<Alien> findByTechSorted(String java);
}
