package com.example.demo;

public class model_Greetings {

    private final long id;
    private final String content;

    public model_Greetings(long id, String greeting) {
        this.id = id;
        this.content = greeting;
    }

    public long getId() {
        return id;
    }

    public String getGreeting() {
        return content;
    }

}
