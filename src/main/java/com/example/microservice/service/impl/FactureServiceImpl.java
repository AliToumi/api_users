package com.example.microservice.service.impl;

import com.example.microservice.model.Facture;
import com.example.microservice.repository.FactureRepository;
import com.example.microservice.service.interfaces.FactureService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class FactureServiceImpl implements FactureService {

    @Inject
    FactureRepository factureRepository;

    @Override
    public List<Facture> findAll() {
        return factureRepository.listAll();
    }

    @Override
    public Optional<Facture> findById(Long id) {
        return factureRepository.findByIdOptional(id);
    }

    @Override
    public void save(Facture facture) {
        factureRepository.persist(facture);
    }

    @Override
    public void delete(Long id) {
        factureRepository.deleteById(id);
    }
}

