CREATE TABLE users (id SERIAL PRIMARY KEY, first_name VARCHAR(50), last_name VARCHAR(50), role BOOLEAN);

INSERT INTO users (first_name, last_name, role) VALUES
('Maria','Perez',true),
('Jose','Rodriguez',true),
('Luis','Gomez',true),
('Luz','Lopez',true),
('Ana','Gonzalez',true),
('Carlos','Garcia',false),
('Juan','Martinez',false),
('Antonio','Ramirez',false),
('Alberto','Sanchez',false),
('Enrique','Hernandez',false);