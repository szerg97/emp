package com.example.emp.service;

import com.example.emp.model.Movie;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final EntityManager em;

    public MovieService(EntityManager em) {
        this.em = em;
    }

    public void saveMovie() {
        em.getTransaction().begin();

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");

        em.persist(movie);
        em.getTransaction().commit();
    }
}
