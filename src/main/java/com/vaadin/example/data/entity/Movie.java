package com.vaadin.example.data.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;

public class Movie {

    private @Id Long id;



    @NotNull(message = "Title is required")
    private String title;

    @Column("directorId")
    private Long directorId;

    @Min(value=1800, message = "No movie can be older than 18th century")
    @Max(value=2030, message = "Movie should be released in the nearest feature if not yet")
    private int releaseYear;

    private String imbdLink;

    public Movie(){
    }

    @PersistenceConstructor
    public Movie(String title, long directorId, int releaseYear, String imbdLink) {
        this.title = title;
        this.directorId = directorId;
        this.releaseYear = releaseYear;
        this.imbdLink = imbdLink;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImbdLink() {
        return imbdLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setImbdLink(String imbdLink) {
        this.imbdLink = imbdLink;
    }

    @Override
    public String toString() {
        return String
              .format("Movie[title= %s, producer = %d]", title, releaseYear);
    }
}
