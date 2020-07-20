package com.vaadin.example.data.repository;

import java.util.List;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.mappers.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies(title,director,release_year, imbd_link) VALUES (?, ?,?,?)",
             movie.getTitle(),movie.getDirector().getName(),movie.getReleaseYear(),movie.getImbdLink());
    }

    public List<Movie> findAll() {
        String query = "SELECT * FROM MOVIES";
        List<Movie> movies = jdbcTemplate.query(query,  new MovieRowMapper());
        return movies;
    }
}
