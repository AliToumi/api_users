--liquibase formatted sql

--changeset data:1
INSERT INTO microservice.users (first_name, last_name, email)
VALUES
    ('Jean', 'Dupont', 'jean.dupont@example.com'),
    ('Marie', 'Martin', 'marie.martin@example.com'),
    ('Ali', 'Benkacem', 'ali.benkacem@example.com'),
    ('Sophie', 'Durand', 'sophie.durand@example.com'),
    ('Lucas', 'Petit', 'lucas.petit@example.com')
ON CONFLICT (email) DO NOTHING;

--changeset data:2
INSERT INTO microservice.adresses (street, city, postal_code, country)
VALUES
    ('12 Rue de la Paix', 'Paris', '75002', 'France'),
    ('45 Avenue Habib Bourguiba', 'Tunis', '1001', 'Tunisie'),
    ('78 Rue Mohammed V', 'Casablanca', '20000', 'Maroc'),
    ('5 Oxford Street', 'London', 'W1D 2HG', 'UK'),
    ('99 Wall Street', 'New York', '10005', 'USA')
ON CONFLICT DO NOTHING;

--changeset data:3
INSERT INTO microservice.contacts (user_id, phone_number, email)
VALUES
    (1, '+33612345678', 'contact.jean@example.com'),
    (2, '+21620111222', 'contact.marie@example.com'),
    (3, '+212601223344', 'contact.ali@example.com'),
    (4, '+447911123456', 'contact.sophie@example.com'),
    (5, '+12125551234', 'contact.lucas@example.com')
ON CONFLICT DO NOTHING;
