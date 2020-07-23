package com.vaadin.example;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.repository.DirectorRepository;
import com.vaadin.example.data.repository.MovieRepository;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceInitListener implements
      VaadinServiceInitListener {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        System.out.println("_____________________");
        // Initializing tables in the in-memory database
        jdbcTemplate.execute("DROP TABLE movie IF EXISTS ");
        jdbcTemplate.execute("DROP TABLE director IF EXISTS ");
        jdbcTemplate.execute(
              "CREATE TABLE movie(id SERIAL, title VARCHAR(255),directorId FLOAT , release_year INTEGER ,imbd_link VARCHAR(255))");
        jdbcTemplate.execute("CREATE TABLE director(id SERIAL, name VARCHAR(255))");

        Director gray = directorRepository.save(new Director("F. Gardy Gray"));
        Director johnson = directorRepository.save(new Director("Rian Johnson"));
        movieRepository.save(new Movie("Law Abiding Citizen", gray.getId(), 2009,
              "https://www.imdb.com/title/tt1197624/"));
        movieRepository.save(new Movie("Knives Out", johnson.getId(), 2019,
              "https://www.imdb.com/title/tt8946378/"));
        System.out.println("_____________________");
    }
}
