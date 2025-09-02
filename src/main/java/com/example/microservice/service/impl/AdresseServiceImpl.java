package com.example.microservice.service.impl;

import com.example.microservice.model.Adresse;
import com.example.microservice.repository.AdresseRepository;
import com.example.microservice.service.interfaces.AdresseService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AdresseServiceImpl implements AdresseService {

    @Inject
    AdresseRepository adresseRepository;

    @Override
    public List<Adresse> findAll() {
        return adresseRepository.listAll();
    }

    @Override
    public Optional<Adresse> findById(Long id) {
        return adresseRepository.findByIdOptional(id);
    }

    @Override
    public void save(Adresse adresse) {
        adresseRepository.persist(adresse);
    }

    @Override
    public void delete(Long id) {
        adresseRepository.deleteById(id);
    }
}

