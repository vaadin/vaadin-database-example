package com.vaadin.example.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Title is required")
    private String title;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @Min(value=1800, message = "No movie can be older than 18th century")
    @Max(value=2030, message = "Movie should be released in the nearest feature if not yet")
    private int releaseYear;

    private String imbdLink;

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

    protected Movie(){

    }

    public Movie(String title, Director director, int releaseYear, String imbdLink) {
        this.title = title;
        this.director= director;
        this.releaseYear = releaseYear;
        this.imbdLink = imbdLink;
    }

    @Override
    public String toString() {
        return String.format("Movie[title= %d, director = %s, producer = %s]", title,
              director.getName(), releaseYear);
    }
}
