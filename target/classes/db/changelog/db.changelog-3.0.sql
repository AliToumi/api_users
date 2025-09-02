--liquibase formatted sql

--changeset data:4
INSERT INTO microservice.commandes (user_id, order_date, total_amount)
VALUES
    (1, '2024-08-01 10:30:00', 120.50),
    (1, '2024-08-15 14:20:00', 89.90),
    (2, '2024-08-10 09:00:00', 250.00),
    (3, '2024-08-12 16:45:00', 75.99),
    (4, '2024-08-20 11:15:00', 300.00),
    (5, '2024-08-25 19:30:00', 45.50)
    ON CONFLICT DO NOTHING;

--changeset data:5
INSERT INTO microservice.factures (user_id, commande_id, facture_date, total_amount)
VALUES
    (1, 1, '2024-08-01 10:35:00', 120.50),
    (1, 2, '2024-08-15 14:25:00', 89.90),
    (2, 3, '2024-08-10 09:05:00', 250.00),
    (3, 4, '2024-08-12 16:50:00', 75.99),
    (4, 5, '2024-08-20 11:20:00', 300.00),
    (5, 6, '2024-08-25 19:35:00', 45.50)
    ON CONFLICT DO NOTHING;
