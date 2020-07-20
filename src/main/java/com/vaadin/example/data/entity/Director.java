package com.vaadin.example.data.entity;


import java.io.Serializable;
import java.util.Set;

public class Director implements Serializable {

    private Long id;

    private String name;

    private Set<Movie> movies;

    protected Director(){

    }

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
