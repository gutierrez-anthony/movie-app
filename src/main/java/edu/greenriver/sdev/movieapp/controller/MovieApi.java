package edu.greenriver.sdev.movieapp.controller;

import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// a web api to deliver movies
@RestController
public class MovieApi {
    private List<Movie> movies = new ArrayList<>(List.of(
        new Movie("Inception", 2010, "Science Fiction", "PG-13", false),
        new Movie("The Shawshank Redemption", 1994, "Drama", "R", false),
        new Movie("The Dark Knight", 2008, "Action", "PG-13", false),
        new Movie("Pulp Fiction", 1994, "Crime", "R", false),
        new Movie("Titanic", 1997, "Drama", "PG-13", false),
        new Movie("The Godfather", 1972, "Crime", "R", false),
        new Movie("Avatar", 2009, "Action", "PG-13", true),
        new Movie("The Lord of the Rings: The Return of the King", 2003, "Fantasy", "PG-13", false),
        new Movie("Jurassic Park", 1993, "Science Fiction", "PG-13", false),
        new Movie("Forrest Gump", 1994, "Drama", "PG-13", false)
    ));

    //REST apis are routes that pass through HTTP
    //(methods: GET, POST, PUT/PATCH, DELETE)

}
