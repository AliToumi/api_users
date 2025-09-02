package com.example.microservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "microservice")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToMany
    @JoinTable(
        name = "user_adresse",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "adresse_id")
    )
    private List<Adresse> adresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Facture> factures;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = new Timestamp(System.currentTimeMillis()); // Définit la date à l'heure actuelle
        }
    }
}
