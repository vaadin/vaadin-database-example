package com.vaadin.example;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.service.DirectorService;
import com.vaadin.example.data.service.MovieService;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

// Runs once when a VaadinService is initiated. The best place to
// initiate a DB structure and populate it.
@Service
public class ApplicationServiceInitListener implements
      VaadinServiceInitListener {

    @Autowired
    MovieService movieService;
    @Autowired
    DirectorService directorService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        System.out.println("_________DB initiation has started____________");
        initDBStructure();
        populateRepositories();
        System.out.println("_________DB initiation has finished____________");
    }

    // Initializing tables in the database
    // First, remove if already exist
    private void initDBStructure() {
        jdbcTemplate.execute("DROP TABLE movie IF EXISTS ");
        jdbcTemplate.execute("DROP TABLE director IF EXISTS ");
        jdbcTemplate.execute(
              "CREATE TABLE movie(id SERIAL, title VARCHAR(255),directorId FLOAT ,"
                    + " release_year INTEGER ,imbd_link VARCHAR(255))");
        jdbcTemplate
              .execute("CREATE TABLE director(id SERIAL, name VARCHAR(255))");
    }

    private void populateRepositories() {
        Director gray = directorService
              .saveDirector(new Director("F. Gardy Gray"));
        Director johnson = directorService
              .saveDirector(new Director("Rian Johnson"));
        movieService.saveMovie(
              new Movie("Law Abiding Citizen", gray.getId(), 2009,
                    "https://www.imdb.com/title/tt1197624/"));
        movieService.saveMovie(new Movie("Knives Out", johnson.getId(), 2019,
              "https://www.imdb.com/title/tt8946378/"));
        movieService.saveMovie(
              new Movie("Star wars: The last jedi", johnson.getId(), 2017,
                    "https://www.imdb.com/title/tt2527336/"));
    }

}
