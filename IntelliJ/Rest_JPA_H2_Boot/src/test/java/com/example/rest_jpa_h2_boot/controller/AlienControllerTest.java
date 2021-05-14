package com.example.rest_jpa_h2_boot.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.rest_jpa_h2_boot.AlienRepo;
import com.example.rest_jpa_h2_boot.model.Alien;

import java.util.ArrayList;

import java.util.Optional;

import org.hamcrest.Matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AlienController.class})
@ExtendWith(SpringExtension.class)
public class AlienControllerTest {
    @Autowired
    private AlienController alienController;

    @MockBean
    private AlienRepo alienRepo;

    @Test
    public void testAddAlien() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/addAlienREST/{aid}/{aName}/{tech}",
                "Tech", "A Name", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void testAddAlien2() throws Exception {
        Alien alien = new Alien();
        alien.setTech("Tech");
        alien.setaName("A Name");
        alien.setAid(1);
        when(this.alienRepo.save((Alien) any())).thenReturn(alien);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/addAlien");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("alien"))
                .andExpect(MockMvcResultMatchers.view().name("home.jsp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.jsp"));
    }

    @Test
    public void testDeleteAlien() throws Exception {
        Alien alien = new Alien();
        alien.setTech("Tech");
        alien.setaName("A Name");
        alien.setAid(1);
        Optional<Alien> ofResult = Optional.<Alien>of(alien);
        doNothing().when(this.alienRepo).delete((Alien) any());
        when(this.alienRepo.findById((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/deleteAlien");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("aid", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.jsp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.jsp"));
    }

    @Test
    public void testDeleteAlienRest() throws Exception {
        Alien alien = new Alien();
        alien.setTech("Tech");
        alien.setaName("A Name");
        alien.setAid(1);
        Optional<Alien> ofResult = Optional.<Alien>of(alien);
        doNothing().when(this.alienRepo).delete((Alien) any());
        when(this.alienRepo.findById((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/deleteAlien/{aid}", 1);
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"aid\":1,\"aName\":\"A Name\",\"tech\":\"Tech\"}")));
    }

    @Test
    public void testFetchAlien() throws Exception {
        Alien alien = new Alien();
        alien.setTech("Tech");
        alien.setaName("A Name");
        alien.setAid(1);
        Optional<Alien> ofResult = Optional.<Alien>of(alien);
        when(this.alienRepo.findById((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/fetchAlien");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("aid", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"aid\":1,\"aName\":\"A Name\",\"tech\":\"Tech\"}")));
    }

    @Test
    public void testGetAlien() throws Exception {
        Alien alien = new Alien();
        alien.setTech("Tech");
        alien.setaName("A Name");
        alien.setAid(1);
        Optional<Alien> ofResult = Optional.<Alien>of(alien);
        when(this.alienRepo.findById((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAlien/{aid}", 1);
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"aid\":1,\"aName\":\"A Name\",\"tech\":\"Tech\"}")));
    }

    @Test
    public void testGetAliens() throws Exception {
        when(this.alienRepo.findAll()).thenReturn(new ArrayList<Alien>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllAliens");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAliens2() throws Exception {
        when(this.alienRepo.findAll()).thenReturn(new ArrayList<Alien>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getAllAliens");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testHome() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.jsp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.jsp"));
    }

    @Test
    public void testHome2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/home");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.jsp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.jsp"));
    }

    @Test
    public void testHome3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.jsp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.jsp"));
    }

    @Test
    public void testHome4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/home", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.alienController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.jsp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.jsp"));
    }
}

