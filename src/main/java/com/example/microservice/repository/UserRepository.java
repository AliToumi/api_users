package com.example.microservice.repository;


import com.example.microservice.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    // Tu peux ajouter des méthodes personnalisées ici
}
