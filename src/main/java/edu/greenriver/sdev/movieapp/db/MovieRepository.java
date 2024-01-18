package edu.greenriver.sdev.movieapp.db;

import edu.greenriver.sdev.movieapp.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
