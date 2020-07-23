package com.vaadin.example.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum)
          throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getLong("ID"));
        movie.setTitle(rs.getString("title"));
       // movie.setDirector(rs.getObject("director"));
        movie.setReleaseYear(rs.getInt("release_year"));
        movie.setImbdLink(rs.getString("imbd_link"));
        return movie;
    }
}
