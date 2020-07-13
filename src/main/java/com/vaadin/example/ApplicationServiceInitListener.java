package com.vaadin.example;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.repository.MovieRepository;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceInitListener implements
      VaadinServiceInitListener {

    @Autowired
    MovieRepository repository;

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        System.out.println("_____________________");
        repository.save(new Movie("Law Abiding Citizen", "F. Gardy Gray", 2009, "https://www.imdb.com/title/tt1197624/"));
        repository.save(new Movie("Knives Out", "Rian Johnson", 2019, "https://www.imdb.com/title/tt8946378/"));
        System.out.println("_____________________");
    }
}
