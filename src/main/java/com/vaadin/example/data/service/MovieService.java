package com.vaadin.example.data.service;

import java.util.List;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    MovieRepository repository;

    public MovieService(@Autowired MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public String getDirectorName(Long movieId) {
        return repository.getDirector(movieId).getName();
    }
}
