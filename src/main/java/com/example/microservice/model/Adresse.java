package com.example.microservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "adresses", schema = "microservice")
public class Adresse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String country;

    @ManyToMany(mappedBy = "adresses")
    private List<User> users;
}
