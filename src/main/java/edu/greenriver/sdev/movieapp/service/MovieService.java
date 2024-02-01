package edu.greenriver.sdev.movieapp.service;

import edu.greenriver.sdev.movieapp.db.MovieRepository;
import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Stereotypical service layer that acts as a business logic class
@Service
public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository){
        this.repository = repository;
    }


    // Returns the index where the matching movie title is found
    private int movieIndexOf(String title){
        List<Movie> movies = repository.findAll();
        for (int i = 0; i < movies.size(); i++) {
            Movie next = movies.get(i);
            if(next.getTitle().equalsIgnoreCase(title)){
                return i;
            }
        }
        return -1;
    }
    public Movie getRandomMovie() {
        List<Movie> movies = repository.findAll();
        Random generator = new Random();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

    public List<Movie> all() {
        List<Movie> movies = repository.findAll();
        return Collections.unmodifiableList(movies);
    }

    public Movie byTitle(String title) {
        List<Movie> movies = repository.findAll();
        int index = movieIndexOf(title);
        return movies.get(index);

        // use functional code (with lambda)
        /*movies.stream()
            .filter(movies -> movies.getTitle().equals(title))
            .findFirst()
            .orElse(null);*/
    }

    public List<Movie> byYear(int year) {
        List<Movie> movies = repository.findAll();
        List<Movie> results = new ArrayList<>();

        for(int i = 0; i < movies.size(); i++) {
            Movie next = movies.get(i);
            if(next.getReleaseYear() == year) {
                results.add(next);
            }
        }
        return results;
    }

    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie byId(int id){
        return repository.findById(id).orElseThrow();
    }

    public Movie updateMovie(Movie updatedMovie, int id){
        Movie currentMovie = repository.findById(id).orElseThrow();

        currentMovie.setRating(updatedMovie.getRating());
        currentMovie.setInternational(updatedMovie.isInternational());
        currentMovie.setGenre(updatedMovie.getGenre());
        currentMovie.setTitle(updatedMovie.getTitle());
        currentMovie.setReleaseYear(updatedMovie.getReleaseYear());

        // this is add or update
        return repository.save(currentMovie);
    }
   /* public Movie updateMovie(String title, Movie updatedMovie) {
        List<Movie> movies = repository.findAll();
        Movie savedMovie = movies.get(movieIndexOf(title));

        //updated movie
        savedMovie.setGenre(updatedMovie.getGenre());
        savedMovie.setReleaseYear(updatedMovie.getReleaseYear());
        savedMovie.setInternational(updatedMovie.isInternational());
        savedMovie.setRating(updatedMovie.getRating());

        return savedMovie;
    }

    public void deleteMovie(String title) {
        List<Movie> movies = repository.findAll();
        int index = movieIndexOf(title);
        movies.remove(index);
    }*/

    public void deleteMovie(int id) {
        repository.deleteById(id);
    }
}
