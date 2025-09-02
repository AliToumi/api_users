package com.example.microservice.service.interfaces;
import com.example.microservice.model.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureService {
    List<Facture> findAll();
    Optional<Facture> findById(Long id);
    void save(Facture facture);
    void delete(Long id);
}