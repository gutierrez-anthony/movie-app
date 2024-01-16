package edu.greenriver.sdev.movieapp.service;

import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Stereotypical service layer that acts as a business logic class
@Service
public class MovieService {
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

    // Returns the index where the matching movie title is found
    private int movieIndexOf(String title){
        for (int i = 0; i < movies.size(); i++) {
            Movie next = movies.get(i);
            if(next.getTitle().equalsIgnoreCase(title)){
                return i;
            }
        }
        return -1;
    }
    public Movie getRandomMovie() {
        Random generator = new Random();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

    public List<Movie> all() {
        return Collections.unmodifiableList(movies);
    }

    public Movie byTitle(String title) {
        int index = movieIndexOf(title);
        return movies.get(index);

        // use functional code (with lambda)
        /*movies.stream()
            .filter(movies -> movies.getTitle().equals(title))
            .findFirst()
            .orElse(null);*/
    }

    public List<Movie> byYear(int year) {
        List<Movie> results = new ArrayList<>();

        for(int i = 0; i < movies.size(); i++) {
            Movie next = movies.get(i);
            if(next.getYear() == year) {
                results.add(next);
            }
        }
        return results;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Movie updateMovie(String title, Movie updatedMovie) {
        Movie savedMovie = movies.get(movieIndexOf(title));

        //updated movie
        savedMovie.setGenre(updatedMovie.getGenre());
        savedMovie.setYear(updatedMovie.getYear());
        savedMovie.setInternational(updatedMovie.isInternational());
        savedMovie.setRating(updatedMovie.getRating());

        return savedMovie;
    }

    public void deleteMovie(String title) {
        int index = movieIndexOf(title);
        movies.remove(index);
    }
}
