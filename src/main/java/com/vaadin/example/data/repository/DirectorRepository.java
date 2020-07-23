package com.vaadin.example.data.repository;

import java.util.List;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.mappers.DirectorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director,Long> {

    @Query("SELECT * from director")
    List<Director> findAll();

   // Director findFirstById(Long id);

    //Director findFirstByName(String name);


  /*  @Autowired
    JdbcTemplate jdbcTemplate;

    public Director findByName(String name) {
        String query = "SELECT * FROM DIRECTORS WHERE name = ?";
        return jdbcTemplate
              .queryForObject(query, new DirectorRowMapper(), name);
    }

    public Director findById(Long id) {
        String query = "SELECT * FROM DIRECTORS WHERE id = ?";
        return jdbcTemplate.queryForObject(query,new DirectorRowMapper(), id);
    }
   */
}
