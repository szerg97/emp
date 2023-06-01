package com.example.emp.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public EntityManager entityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.emp");
        return emf.createEntityManager();
    }
}
