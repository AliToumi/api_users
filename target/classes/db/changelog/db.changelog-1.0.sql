--liquibase formatted sql

--changeset init:1
CREATE SCHEMA IF NOT EXISTS microservice;

--changeset init:2
CREATE TABLE IF NOT EXISTS microservice.users (
                                    id SERIAL PRIMARY KEY,
                                    first_name VARCHAR(255) NOT NULL,
                                    last_name VARCHAR(255) NOT NULL,
                                    email VARCHAR(255) UNIQUE NOT NULL,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--changeset init:3
CREATE TABLE IF NOT EXISTS microservice.adresses (
                                       id SERIAL PRIMARY KEY,
                                       street VARCHAR(255) NOT NULL,
                                       city VARCHAR(255) NOT NULL,
                                       postal_code VARCHAR(50) NOT NULL,
                                       country VARCHAR(255) NOT NULL
);

--changeset init:4
CREATE TABLE IF NOT EXISTS microservice.contacts (
                                       id SERIAL PRIMARY KEY,
                                       user_id INT REFERENCES microservice.users(id) ON DELETE CASCADE,
                                       phone_number VARCHAR(20),
                                       email VARCHAR(255) UNIQUE
);

--changeset init:5
CREATE TABLE IF NOT EXISTS microservice.commandes (
                                        id SERIAL PRIMARY KEY,
                                        user_id INT REFERENCES microservice.users(id) ON DELETE CASCADE,
                                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        total_amount DECIMAL(10, 2) NOT NULL
);

--changeset init:6
CREATE TABLE IF NOT EXISTS microservice.factures (
                                       id SERIAL PRIMARY KEY,
                                       user_id INT REFERENCES microservice.users(id) ON DELETE CASCADE,
                                       commande_id INT REFERENCES microservice.commandes(id) ON DELETE CASCADE,
                                       facture_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       total_amount DECIMAL(10, 2) NOT NULL
);
