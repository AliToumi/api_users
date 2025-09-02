package com.example.microservice.service.impl;

import com.example.microservice.model.Contact;
import com.example.microservice.repository.ContactRepository;
import com.example.microservice.service.interfaces.ContactService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ContactServiceImpl implements ContactService {

    @Inject
    ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.listAll();
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findByIdOptional(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.persist(contact);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
