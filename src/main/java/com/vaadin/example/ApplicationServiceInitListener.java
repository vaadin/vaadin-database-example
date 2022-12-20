package com.vaadin.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

/**
 * This init listener is run once whenever the Vaadin context starts. As such,
 * it is a great place to create dummy data.
 * <p>
 * See the <code>application.properties</code> file for database connection
 * properties.
 */
@Service
public class ApplicationServiceInitListener implements VaadinServiceInitListener {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void serviceInit(ServiceInitEvent serviceInitEvent) {
		System.out.println("_________DB initiation has started____________");

		// Initializing tables in the database

		// First, remove if already exist
		initDBStructure();
		// insert data
		populateData();

		System.out.println("_________DB initiation has finished____________");
	}

	private void initDBStructure() {
		jdbcTemplate.execute("DROP TABLE movie IF EXISTS ");
		jdbcTemplate.execute("DROP TABLE director IF EXISTS ");

		jdbcTemplate.execute("CREATE TABLE director (id IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255))");
		jdbcTemplate.execute("CREATE TABLE movie (id IDENTITY NOT NULL PRIMARY KEY, title VARCHAR(255), directorId INT,"
				+ "release_year INTEGER , imbd_link VARCHAR(255),"
				+ "CONSTRAINT FK_MOVIE_DIRECTOR FOREIGN KEY (directorId) REFERENCES director(id))");
	}

	private void populateData() {

		jdbcTemplate.update("INSERT INTO director VALUES (DEFAULT, 'F. Gardy Gray')");
		jdbcTemplate.update("INSERT INTO director VALUES (DEFAULT, 'Rian Johnson')");

		jdbcTemplate.update(
				"INSERT INTO movie VALUES (DEFAULT, 'Law Abiding Citizen', 1,2009, 'https://www.imdb.com/title/tt1197624/')");

		jdbcTemplate.update(
				"INSERT INTO movie VALUES (DEFAULT, 'Knives Out', 2, 2019, 'https://www.imdb.com/title/tt8946378/')");
		jdbcTemplate.update(
				"INSERT INTO movie VALUES (DEFAULT, 'The Last Jedi', 2, 2017, 'https://www.imdb.com/title/tt2527336/')");

	}

}
