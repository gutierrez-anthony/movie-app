package edu.greenriver.sdev.movieapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data adds getters/setters/toString()/equals/hashcode...
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String title;
    private int year;
    private String genre;
    private String rating;
    private boolean international;
}
