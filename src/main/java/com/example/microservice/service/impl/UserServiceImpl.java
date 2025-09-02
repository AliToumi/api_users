package com.example.microservice.service.impl;


import com.example.microservice.model.User;
import com.example.microservice.repository.UserRepository;
import com.example.microservice.service.interfaces.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.listAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findByIdOptional(id);
    }

    @Override
    public void save(User user) {
        userRepository.persist(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
