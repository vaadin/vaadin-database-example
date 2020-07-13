package com.vaadin.example.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String director;

    private int releaseYear;

    private String imbdLink;

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImbdLink() {
        return imbdLink;
    }

    protected Movie(){

    }

    public Movie(String title, String director, int releaseYear, String imbdLink) {
        this.title = title;
        this.director= director;
        this.releaseYear = releaseYear;
        this.imbdLink = imbdLink;
    }

    @Override
    public String toString() {
        return String.format("Movie[title= %d, director = %s, producer = %s]", title,
              director, releaseYear);
    }
}
