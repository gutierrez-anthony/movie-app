package edu.greenriver.sdev.movieapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data adds getters/setters/toString()/equals/hashcode...
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {


    private String title;
    private int year;

    private String genre;
    private String rating;
    private boolean international;
}
