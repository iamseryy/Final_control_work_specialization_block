DROP DATABASE IF EXISTS pet_registry;
CREATE DATABASE pet_registry;
USE pet_registry;

DROP TABLE IF EXISTS registry;
CREATE TABLE registry (
	id SERIAL PRIMARY KEY,
    note  VARCHAR(200)
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
	id SERIAL PRIMARY KEY,
    height INT,
    weight INT,
    birthDate  DATE NOT NULL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    loadCapacity INT,
    milkValue INT,
    registry_id INT NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
);

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
	id SERIAL PRIMARY KEY,
    height INT,
    weight INT,
    birthDate  DATE NOT NULL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    isVaccinated BOOLEAN,
    mustacheLength INT,
    registry_id INT NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
	id SERIAL PRIMARY KEY,
    height INT,
    weight INT,
    birthDate  DATE NOT NULL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    isVaccinated BOOLEAN,
    powerSenseSmell INT,
    registry_id INT NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
	id SERIAL PRIMARY KEY,
    height INT,
    weight INT,
    birthDate  DATE NOT NULL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    loadCapacity INT,
    stubbornness INT,
    registry_id INT NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
	id SERIAL PRIMARY KEY,
    height INT,
    weight INT,
    birthDate  DATE NOT NULL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    isVaccinated BOOLEAN,
    registry_id INT NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
	id SERIAL PRIMARY KEY,
    height INT,
    weight INT,
    birthDate  DATE NOT NULL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    loadCapacity INT,
    isBreak INT,
    registry_id INT NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
    );

DROP TABLE IF EXISTS command;
CREATE TABLE command (
	registry_id INT NOT NULL,
    command VARCHAR(200) NOT NULL,
    FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE  
);