DROP DATABASE IF EXISTS pet_registry;
CREATE DATABASE pet_registry;
USE pet_registry;

DROP TABLE IF EXISTS registry;
CREATE TABLE registry (
                          id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                          note  VARCHAR(200)
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
                       id SERIAL PRIMARY KEY,
                       height INT,
                       weight INT,
                       birthdate  DATE NOT NULL,
                       name VARCHAR(50) NOT NULL,
                       breed VARCHAR(50) NOT NULL,
                       loadcapacity INT,
                       milkvalue INT,
                       registry_id INT NOT NULL,
                       FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
                     id SERIAL PRIMARY KEY,
                     height INT,
                     weight INT,
                     birthdate  DATE NOT NULL,
                     name VARCHAR(50) NOT NULL,
                     breed VARCHAR(50) NOT NULL,
                     isvaccinated BOOLEAN,
                     mustachelength INT,
                     registry_id INT NOT NULL,
                     FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
                     id SERIAL PRIMARY KEY,
                     height INT,
                     weight INT,
                     birthdate  DATE NOT NULL,
                     name VARCHAR(50) NOT NULL,
                     breed VARCHAR(50) NOT NULL,
                     isvaccinated BOOLEAN,
                     powersensesmell INT,
                     registry_id INT NOT NULL,
                     FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
                        id SERIAL PRIMARY KEY,
                        height INT,
                        weight INT,
                        birthdate  DATE NOT NULL,
                        name VARCHAR(50) NOT NULL,
                        breed VARCHAR(50) NOT NULL,
                        loadcapacity INT,
                        stubbornness INT,
                        registry_id INT NOT NULL,
                        FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
                         id SERIAL PRIMARY KEY,
                         height INT,
                         weight INT,
                         birthdate  DATE NOT NULL,
                         name VARCHAR(50) NOT NULL,
                         breed VARCHAR(50) NOT NULL,
                         isvaccinated BOOLEAN,
                         registry_id INT NOT NULL,
                         FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
                       id SERIAL PRIMARY KEY,
                       height INT,
                       weight INT,
                       birthdate  DATE NOT NULL,
                       name VARCHAR(50) NOT NULL,
                       breed VARCHAR(50) NOT NULL,
                       loadcapacity INT,
                       speed INT,
                       registry_id INT NOT NULL,
                       FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS command;
CREATE TABLE command (
                         registry_id INT NOT NULL,
                         command VARCHAR(200) NOT NULL,
                         FOREIGN KEY (registry_id) REFERENCES registry (id) ON DELETE CASCADE ON UPDATE CASCADE
);