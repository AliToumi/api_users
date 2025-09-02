package com.example.microservice.service.interfaces;

import com.example.microservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void delete(Long id);
}
