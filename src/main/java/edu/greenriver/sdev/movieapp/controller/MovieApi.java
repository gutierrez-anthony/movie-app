package edu.greenriver.sdev.movieapp.controller;

import edu.greenriver.sdev.movieapp.domain.Movie;
import edu.greenriver.sdev.movieapp.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST apis are routes that pass through HTTP
//(methods: GET, POST, PUT/PATCH, DELETE)
// a web api to deliver movies
@RestController
public class MovieApi {
    private MovieService service;

    public MovieApi(MovieService service) {
        this.service = service;
    }

    // respond to (GET) request at localhost:3000/movies/random
    @GetMapping("movies/random")
    public Movie getRandom() {
        return service.getRandomMovie();
    }

    @GetMapping("movies/all")
    public List<Movie> all() {
        return service.all();
    }

    @GetMapping("movies/{title}")
    public Movie byTitle(@PathVariable String title) {

        return service.byTitle(title);
    }
    @GetMapping("movies/year/{year}")
    public List<Movie> byYear(@PathVariable int year) {
        return service.byYear(year);
    }
    @PostMapping("movies")
    public void addMovie(@RequestBody Movie movie){
        service.addMovie(movie);
    }

    @PutMapping("movies/{title}")
    public Movie updateMovie(@PathVariable String title,
                            @RequestBody Movie updatedMovie){
        return service.updateMovie(title, updatedMovie);
    }

    @DeleteMapping("movies/{title}")
    public void deleteMovie(@PathVariable String title){
        service.deleteMovie(title);
    }

}
