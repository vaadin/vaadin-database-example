package com.vaadin.example.data.repository;

import java.util.List;
import java.util.Optional;

import com.vaadin.example.data.entity.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {

    List<Director> findAll();
    Optional<Director> findByName(String name);
}
