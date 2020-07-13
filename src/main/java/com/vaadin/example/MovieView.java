package com.vaadin.example;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.repository.MovieRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("movies")
public class MovieView extends VerticalLayout {
    MovieRepository repository;

    public MovieView (@Autowired MovieRepository repository){
        this.repository = repository;
        buildUI();
    }

    private void buildUI() {

        Grid<Movie> movies = new Grid<>(Movie.class);
        movies.getColumnByKey("releaseYear").setWidth("55px");
        movies.removeColumnByKey("imbdLink");
        movies.addColumn(TemplateRenderer.<Movie>of("<a href='[[item.imbdLink]]'>Click to IMBD site</a>")
              .withProperty("imbdLink", Movie::getImbdLink))
              .setHeader("IMBD Link");
        movies.setItems(repository.findAll());
        add(movies);
    }

}
