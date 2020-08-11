package com.vaadin.example.data.service;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository repository;

    public Director saveDirector(Director director) {
        return repository.save(director);
    }
}
