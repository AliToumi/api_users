package com.example.microservice.repository;


import com.example.microservice.model.Facture;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FactureRepository implements PanacheRepository<Facture> {
}
