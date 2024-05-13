-- Create the trainer_type table
CREATE TABLE IF NOT EXISTS trainer_type (
    id INTEGER PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL
);
-- Insert mappings into trainer_type table
INSERT INTO trainer_type (id, type_name) VALUES (1, 'Personal Trainer');
INSERT INTO trainer_type (id, type_name) VALUES (2, 'Strength and Conditioning Coach');