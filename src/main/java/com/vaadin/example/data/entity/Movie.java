package com.vaadin.example.data.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Movie {

    private Long id;

    @NotNull(message = "Title is required")
    private String title;


    private Director director;
    @Min(value=1800, message = "No movie can be older than 18th century")
    @Max(value=2030, message = "Movie should be released in the nearest feature if not yet")
    private int releaseYear;

    private String imbdLink;

    public Movie(){
    }

    public Movie(String title, Director director, int releaseYear, String imbdLink) {
        this.title = title;
        this.director= director;
        this.releaseYear = releaseYear;
        this.imbdLink = imbdLink;
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImbdLink() {
        return imbdLink;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setImbdLink(String imbdLink) {
        this.imbdLink = imbdLink;
    }


    @Override
    public String toString() {
        return String.format("Movie[title= %d, director = %s, producer = %s]", title,
              director.getName(), releaseYear);
    }
}
