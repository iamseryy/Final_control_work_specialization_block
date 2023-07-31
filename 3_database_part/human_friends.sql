-- создать базу данных
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;


-- cоздать таблицы
DROP TABLE IF EXISTS animal;
CREATE TABLE animal (
                          id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          animal_type  VARCHAR(50)
);

DROP TABLE IF EXISTS pet;
CREATE TABLE pet (
                          id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          pet_type  VARCHAR(50),
                          animal_id INT NOT NULL,
                          FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS pac;
CREATE TABLE pac (
                          id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          pac_type  VARCHAR(50),
                          animal_id INT NOT NULL,
                          FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
                       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       birthdate  DATE,
                       commands VARCHAR(200),
                       pac_id INT NOT NULL,
                       FOREIGN KEY (pac_id) REFERENCES pac (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
                    id SERIAL PRIMARY KEY,
					name VARCHAR(50) NOT NULL,
                    birthdate  DATE,
                    commands VARCHAR(200),
                    pet_id INT NOT NULL,
                    FOREIGN KEY (pet_id) REFERENCES pet (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
                    id SERIAL PRIMARY KEY,
					name VARCHAR(50) NOT NULL,
                    birthdate  DATE,
					commands VARCHAR(200),
                    pet_id INT NOT NULL,
                    FOREIGN KEY (pet_id) REFERENCES pet (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
                    id SERIAL PRIMARY KEY,
					name VARCHAR(50) NOT NULL,
                    birthdate  DATE,
                    commands VARCHAR(200),
					pac_id INT NOT NULL,
					FOREIGN KEY (pac_id) REFERENCES pac (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
					id SERIAL PRIMARY KEY,
					name VARCHAR(50) NOT NULL,
                    birthdate  DATE,
                    commands VARCHAR(200),
					pet_id INT NOT NULL,
                    FOREIGN KEY (pet_id) REFERENCES pet (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
					id SERIAL PRIMARY KEY,
					name VARCHAR(50) NOT NULL,
                    birthdate  DATE,
                    commands VARCHAR(200),
					pac_id INT NOT NULL,
					FOREIGN KEY (pac_id) REFERENCES pac (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
INSERT INTO animal (animal_type)
VALUES ('pet'), ('pac');

INSERT INTO pet (pet_type, animal_id)
VALUES ('cat', 1), ('dog', 1), ('hamster', 1);

INSERT INTO pac (pac_type, animal_id)
VALUES ('camel', 2), ('donkey', 2), ('horse', 2);


INSERT INTO camel (name, birthdate, commands, pac_id)
VALUES 
('camel1', '2015-01-11', "go", 1),  
('camel2', '2021-02-12', "sit", 1), 
('camel3', '2022-03-13', "stay", 1);

INSERT INTO donkey (name, birthdate, commands, pac_id)
VALUES 
('donkey1', '2015-01-12', "go", 2),  
('donkey2', '2016-02-13', "sit", 2), 
('donkey3', '2019-03-14', "stay", 2);

INSERT INTO horse (name, birthdate, commands, pac_id)
VALUES 
('horse1', '2022-01-13', "go", 3),  
('horse2', '2021-02-14', "sit", 3), 
('horse3', '2019-03-15', "stay", 3);

INSERT INTO cat (name, birthdate, commands, pet_id)
VALUES 
('cat1', '2020-01-13', "go", 1),  
('cat2', '2020-02-14', "sit", 1), 
('cat3', '2015-03-15', "stay", 1);

INSERT INTO dog (name, birthdate, commands, pet_id)
VALUES 
('dog1', '2018-01-12', "go", 2),  
('dog2', '2020-02-13', "sit", 2), 
('dog3', '2021-03-14', "stay", 2);

INSERT INTO hamster (name, birthdate, commands, pet_id)
VALUES 
('hamster1', '2018-01-13', "go", 3),  
('hamster2', '2017-02-14', "sit", 3), 
('hamster3', '2020-03-15', "stay", 3);


-- Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку
SET SQL_SAFE_UPDATES = 0;
DELETE FROM camel;

-- Объединить таблицы лошади, и ослы в одну таблицу.
SELECT name, birthdate, commands FROM horse
UNION SELECT name, birthdate, commands FROM donkey;

/*
Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/
DROP TABLE IF EXISTS temp_table_animals;
CREATE TEMPORARY TABLE temp_table_animals AS 
SELECT camel.name, camel.birthdate, camel.commands, pac.pac_type as animal_type FROM camel JOIN pac ON camel.pac_id = pac.id 
UNION SELECT donkey.name, donkey.birthdate, donkey.commands, pac.pac_type AS animal_type FROM donkey JOIN pac ON donkey.pac_id = pac.id 
UNION SELECT horse.name, horse.birthdate, horse.commands,  pac.pac_type AS animal_type FROM horse JOIN pac ON horse.pac_id = pac.id 
UNION SELECT cat.name, cat.birthdate, cat.commands, pet.pet_type AS animal_type FROM cat JOIN pet ON cat.pet_id = pet.id 
UNION SELECT dog.name, dog.birthdate, dog.commands, pet.pet_type AS animal_type FROM dog JOIN pet ON dog.pet_id = pet.id 
UNION SELECT hamster.name, hamster.birthdate, hamster.commands, pet.pet_type AS animal_type FROM hamster JOIN pet ON hamster.pet_id = pet.id; 

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals AS
SELECT name, birthdate, commands, animal_type, TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) AS age
FROM temp_table_animals WHERE birthdate BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
/*
Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам
*/
SELECT pac.pac_type as type, camel.name, camel.birthdate, camel.commands, young_animals.age
FROM camel 
LEFT JOIN young_animals ON camel.name = young_animals.name
JOIN pac ON camel.pac_id = pac.id
UNION 
SELECT pac.pac_type as type, donkey.name, donkey.birthdate, donkey.commands, young_animals.age 
FROM donkey 
LEFT JOIN young_animals ON donkey.name = young_animals.name
JOIN pac ON donkey.pac_id = pac.id
UNION
SELECT pac.pac_type as type, horse.name, horse.birthdate, horse.commands, young_animals.age 
FROM horse 
LEFT JOIN young_animals ON horse.name = young_animals.name
JOIN pac ON horse.pac_id = pac.id
UNION
SELECT pet.pet_type as type, cat.name, cat.birthdate, cat.commands, young_animals.age 
FROM cat 
LEFT JOIN young_animals ON cat.name = young_animals.name
JOIN pet ON cat.pet_id = pet.id
UNION
SELECT pet.pet_type as type, dog.name, dog.birthdate, dog.commands, young_animals.age 
FROM dog 
LEFT JOIN young_animals ON dog.name = young_animals.name
JOIN pet ON dog.pet_id = pet.id
UNION
SELECT pet.pet_type as type, hamster.name, hamster.birthdate, hamster.commands, young_animals.age 
FROM hamster 
LEFT JOIN young_animals ON hamster.name = young_animals.name
JOIN pet ON hamster.pet_id = pet.id;