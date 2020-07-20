package com.vaadin.example.data.repository;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.mappers.DirectorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DirectorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Director findByName(String name) {
        String query = "SELECT * FROM DIRECTORS WHERE name = ?";
        return jdbcTemplate
              .queryForObject(query, new DirectorRowMapper(), name);

    }
}
