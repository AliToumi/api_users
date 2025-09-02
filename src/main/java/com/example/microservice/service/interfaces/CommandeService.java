package com.example.microservice.service.interfaces;


import com.example.microservice.model.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> findAll();
    Optional<Commande> findById(Long id);
    void save(Commande commande);
    void delete(Long id);
}