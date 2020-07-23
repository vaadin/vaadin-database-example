package com.vaadin.example.views;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.service.MovieService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    MovieService movieService;

    public MainView (@Autowired MovieService movieService){
        this.movieService = movieService;
        add(new H3("Accessing in-memory database using JdbcTemplate"));
        buildGrid();
    }

    private void buildGrid() {
        Grid<Movie> movies = new Grid<>(Movie.class);
        movies.setItems(movieService.getMovies());

        //movies.setColumns("title", "director.name", "releaseYear");
        movies.setColumns("title","releaseYear");
        //movies.getColumnByKey("director.name").setHeader("Director");
        movies.addColumn(
              movie -> movieService.getDirectorName(movie.getId()))
              .setHeader("Director");
        movies.addColumn(TemplateRenderer.<Movie>of(
              "<a href='[[item.imbdLink]]'>Click to IMBD site</a>")
              .withProperty("imbdLink", Movie::getImbdLink))
              .setHeader("IMBD Link");
        movies.getColumnByKey("releaseYear").setWidth("55px");
        add(movies);

        // add(new VaadinCorner());
    }

}
