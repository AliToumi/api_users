package com.example.microservice.repository;



import com.example.microservice.model.Commande;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommandeRepository implements PanacheRepository<Commande> {
}
