package com.example.microservice.service.interfaces;


import com.example.microservice.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    void save(Contact contact);
    void delete(Long id);
}
