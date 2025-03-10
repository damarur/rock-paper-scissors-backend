CREATE TABLE Game
(
    id             SERIAL PRIMARY KEY,
    datetime       TIMESTAMP   NOT NULL,
    nickname       VARCHAR(255),
    user_choice    VARCHAR(50) NOT NULL,
    machine_choice VARCHAR(50) NOT NULL,
    result         VARCHAR(50) NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
