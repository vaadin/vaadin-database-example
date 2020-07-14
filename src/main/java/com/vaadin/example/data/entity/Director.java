package com.vaadin.example.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
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
