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
        jdbcTemplate.execute("DROP TABLE movies IF EXISTS ");
        jdbcTemplate.execute("CREATE TABLE movies(id SERIAL, title VARCHAR(255),director VARCHAR (255), release_year INTEGER ,imbd_link VARCHAR(255))");

        //Director gray = directorRepository.save(new Director("F. Gardy Gray"));
       // Director johnson = directorRepository.save(new Director("Rian Johnson"));
        Director gray =(new Director("F. Gardy Gray"));
        Director johnson = new Director("Rian Johnson");
        movieRepository.save(new Movie("Law Abiding Citizen", gray, 2009, "https://www.imdb.com/title/tt1197624/"));
        movieRepository.save(new Movie("Knives Out", johnson, 2019, "https://www.imdb.com/title/tt8946378/"));
        System.out.println("_____________________");
    }
}
