package com.example.microservice.service.impl;

import com.example.microservice.model.Commande;
import com.example.microservice.repository.CommandeRepository;
import com.example.microservice.service.interfaces.CommandeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CommandeServiceImpl implements CommandeService {

    @Inject
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> findAll() {
        return commandeRepository.listAll();
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeRepository.findByIdOptional(id);
    }

    @Override
    public void save(Commande commande) {
        commandeRepository.persist(commande);
    }

    @Override
    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }
}
