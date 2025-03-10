CREATE TABLE Game
(
    id               SERIAL PRIMARY KEY,
    datetime         TIMESTAMP   NOT NULL,
    nickname         VARCHAR(255),
    user_choice      VARCHAR(50) NOT NULL,
    machine_choice   VARCHAR(50) NOT NULL,
    result           VARCHAR(50) NOT NULL,
    audit_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    audit_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
