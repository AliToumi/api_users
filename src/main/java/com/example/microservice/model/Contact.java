package com.example.microservice.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contacts", schema = "microservice")
public class Contact  {

    // Le champ 'id' est déjà fourni par PanacheEntity, inutile de le redéfinir
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "relationship")
    private String relationship;
}
