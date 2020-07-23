package com.vaadin.example.data.repository;

import java.util.List;

import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.entity.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {

    @Query("SELECT * FROM movie")
    List<Movie> findAll();

    @Query("SELECT DISTINCT dir.name FROM movie mov LEFT JOIN director dir ON mov.directorId = dir.id WHERE mov.id = :movieID")
    String getDirectorName(@Param("movieID") Long movieId);

   /** @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies(title,director,release_year, imbd_link) VALUES (?, ?,?,?)",
             movie.getTitle(),movie.getDirector().getName(),movie.getReleaseYear(),movie.getImbdLink());
    }

    public List<Movie> findAll() {
        String query = "SELECT * FROM MOVIES";
        List<Movie> movies = jdbcTemplate.query(query,  new MovieRowMapper());
        return movies;
    }
   */
}
