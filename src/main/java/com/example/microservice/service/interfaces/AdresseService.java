package com.example.microservice.service.interfaces;


import com.example.microservice.model.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseService {
    List<Adresse> findAll();
    Optional<Adresse> findById(Long id);
    void save(Adresse adresse);
    void delete(Long id);
}
