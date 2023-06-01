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

    public Movie getMovie(Long movieId) {
        Movie movie = em.find(Movie.class, movieId);
        em.detach(movie);
        return movie;
    }

    public Movie mergeMovie(Long movieId, Movie from) {
        Movie movieOld = getMovie(movieId);
        em.detach(movieOld);
        movieOld.copyFrom(from);
        em.getTransaction().begin();
        em.merge(movieOld);
        em.getTransaction().commit();
        return movieOld;
    }

    public void removeMovie(Long movieId) {
        em.getTransaction().begin();
        Movie movie = em.find(Movie.class, movieId);
        em.remove(movie);
        System.out.println(em.getTransaction().isActive());
        em.getTransaction().commit();
        System.out.println(em.getTransaction().isActive());
    }
}
