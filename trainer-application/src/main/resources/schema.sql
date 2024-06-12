-- Create the trainer_type table
CREATE TABLE IF NOT EXISTS trainer_type (
    id INTEGER PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL,
    trainer_description VARCHAR(255)
);
