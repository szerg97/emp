package com.example.emp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private Long id;
    private String movieName;
    private Integer releaseYear;
    private String language;

    public Movie(String movieName, Integer releaseYear, String language) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.language = language;
    }

    public void copyFrom(Movie from){
        this.movieName = from.getMovieName();
        this.releaseYear = from.getReleaseYear();
        this.language = from.getLanguage();
    }
}
