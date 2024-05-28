-- Create the trainer_type table
CREATE TABLE IF NOT EXISTS trainer_type (
    id INTEGER PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL,
    trainer_description VARCHAR(255)
);
--Creates the Trainer_Entity Table  to enforce the relationship at the database level with trainer Type.
CREATE TABLE IF NOT EXISTS trainer_entity (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    trainer_description VARCHAR(255),
    trainer_type_id INTEGER,
    FOREIGN KEY (trainer_type_id) REFERENCES trainer_type_entity(id)
);