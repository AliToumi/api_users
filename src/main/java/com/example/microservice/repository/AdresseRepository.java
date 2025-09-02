package com.example.microservice.repository;


import com.example.microservice.model.Adresse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdresseRepository implements PanacheRepository<Adresse> {
}