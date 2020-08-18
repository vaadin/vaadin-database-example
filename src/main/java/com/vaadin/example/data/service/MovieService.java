package com.vaadin.example.data.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.vaadin.example.ApplicationServiceInitListener;
import com.vaadin.example.data.entity.Director;
import com.vaadin.example.data.entity.Movie;

/**
 * Standard Spring Service class, where we access the database to get our data.
 * <p>
 * See the <code>application.properties</code> file for database connections
 * properties.
 *
 * @see ApplicationServiceInitListener Dummy data generation
 */
@Service
public class MovieService {

	/**
	 * Access point to our DB, automatically configured by Spring.
	 */
	@Autowired
	private JdbcTemplate template;

	/**
	 * @return All movies in the database, with director information.
	 */
	public List<Movie> getMovies() {

		// Use a query the sql mapper class understands
		final String sql = MovieRowMapper.SELECT_ALL;

		// Use Spring's JdbcTemplate helper class to run the sql
		final List<Movie> list = template.query(sql, new MovieRowMapper());

		return list;
	}

	/**
	 * JDBCTemplate mapper class, where we take a SQL ResultSet and parse out our
	 * Java DTO(s).
	 * <p>
	 * The ResultSet is dependent on the SQL query we do in the Service class, so we
	 * define the query here as a public constant.
	 */
	public static class MovieRowMapper implements RowMapper<Movie> {

		/**
		 * SQL clause to fetch all Movies from the DB, with Director names included.
		 */
		public static final String SELECT_ALL = "SELECT * FROM movie mov LEFT JOIN director dir ON mov.directorId = dir.id";

		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

			final Movie movie = new Movie();
			movie.setId(rs.getLong("id"));
			movie.setTitle(rs.getString("title"));
			movie.setReleaseYear(rs.getInt("release_year"));
			movie.setImbdLink(rs.getString("imbd_link"));

			final Director director = new Director();
			director.setId(rs.getLong("directorId"));
			director.setName(rs.getString("name"));
			movie.setDirector(director);

			return movie;
		}
	}
}
