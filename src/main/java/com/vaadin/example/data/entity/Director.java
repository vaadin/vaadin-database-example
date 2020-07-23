package com.vaadin.example.data.entity;


import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Director implements Serializable {

    private @Id Long id;

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

    public Long getId () {
        return id;
    }
}
