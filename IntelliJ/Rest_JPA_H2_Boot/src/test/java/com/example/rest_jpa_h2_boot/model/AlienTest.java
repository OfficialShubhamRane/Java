package com.example.rest_jpa_h2_boot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AlienTest {
    @Test
    public void testConstructor() {
        Alien actualAlien = new Alien();
        actualAlien.setAid(1);
        actualAlien.setTech("Tech");
        actualAlien.setaName("A Name");
        assertEquals(1, actualAlien.getAid());
        assertEquals("Tech", actualAlien.getTech());
        assertEquals("Alien{aid=1, aName='A Name', tech='Tech'}", actualAlien.toString());
    }

    @Test
    public void testConstructor2() {
        Alien actualAlien = new Alien(1, "A Name", "Tech");
        actualAlien.setAid(1);
        actualAlien.setTech("Tech");
        actualAlien.setaName("A Name");
        assertEquals(1, actualAlien.getAid());
        assertEquals("Tech", actualAlien.getTech());
        assertEquals("Alien{aid=1, aName='A Name', tech='Tech'}", actualAlien.toString());
    }

    @Test
    public void testGetaName() {
        assertEquals("A name", (new Alien(1, "A name", "Tech")).getaName());
    }
}

