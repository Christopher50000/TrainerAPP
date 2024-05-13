-- Create the trainer_type table
CREATE TABLE IF NOT EXISTS trainer_type (
    id INTEGER PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);
-- Insert mappings into trainer_type table
INSERT INTO trainer_type (id, type_name, description) VALUES (1, 'Personal Trainer', 'Provides individualized fitness training');
INSERT INTO trainer_type (id, type_name, description) VALUES (2, 'Strength and Conditioning Coach', 'Focuses on improving strength and athletic performance');