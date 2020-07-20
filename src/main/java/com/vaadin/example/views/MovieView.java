package com.vaadin.example.views;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.example.data.repository.MovieRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "movies", layout = MainView.class)
public class MovieView extends VerticalLayout {
    MovieRepository repository;

    public MovieView (@Autowired MovieRepository repository){
        this.repository = repository;
        buildUI();
    }

    private void buildUI() {
        Grid<Movie> movies = new Grid<>(Movie.class);
        movies.setItems(repository.findAll());

        //movies.setColumns("title", "director.name", "releaseYear");
        movies.setColumns("title","releaseYear");
        //movies.getColumnByKey("director.name").setHeader("Director");
        movies.addColumn(TemplateRenderer.<Movie>of(
              "<a href='[[item.imbdLink]]'>Click to IMBD site</a>")
              .withProperty("imbdLink", Movie::getImbdLink))
              .setHeader("IMBD Link");
        movies.getColumnByKey("releaseYear").setWidth("55px");
        add(movies);

       // add(new VaadinCorner());
    }

}
