package com.example.emp;

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
        movieService.saveMovie();
    }
}
