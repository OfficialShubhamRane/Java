package com.example.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloWorld_repoTest {
    @Test
    public void testConstructor() {
        assertEquals("Hello ", (new HelloWorld_repo()).getHelloWorld());
    }
}

