package com.example.emp;

import com.example.emp.model.Movie;
import com.example.emp.service.MovieService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpApplication {

    private final MovieService movieService;

    public EmpApplication(MovieService movieService) {
        this.movieService = movieService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class, args);
    }

    @PostConstruct
    public void seed(){
        //Save movie
        movieService.saveMovie();

        //Get one movie
        Movie movie = movieService.getMovie(1L);
        System.out.println("Inserted " + movie);

        //Merge movie
        Movie mergedMovie = movieService.mergeMovie(1L, new Movie("Movie Name 1", 1989, "Hungarian"));
        System.out.println("Updated from: " + movie + " to: " + mergedMovie);

        //Remove movie
        movieService.removeMovie(1L);
    }
}
