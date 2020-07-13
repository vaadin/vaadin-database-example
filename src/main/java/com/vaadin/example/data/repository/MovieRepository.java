package com.vaadin.example.data.repository;

import java.util.List;

import com.vaadin.example.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findAll();
}
