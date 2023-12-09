# Боярчук Эдуард Валентинович
## Разработчик|Программист|будни вечер|4581|05.04.23|

## Информация о проекте
Необходимо организовать систему учета для питомника, в котором живут
домашние и Pack animals.

## Задание
1. *Использование команды `cat` в Linux.*
* *Создать два текстовых файла: ["Pets"(Домашние животные)](/Linux/Pets.txt) и ["Pack animals"(вьючные животные)](/Linux/PackAnimals), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.*

   #### cat > Pets.txt
   Собака  
   Кошка  
   Хомяк

   #### cat > PackAnimals.txt
   Лошадь  
   Верблюд  
   Осел

* *Объединить содержимое этих двух  файлов в один и просмотреть его содержимое.*
  #### cat Pets.txt PackAnimals.txt > Pets_PackAnimals.txt
  #### cat Pets_PackAnimals.txt
  *  *Переименовать получившийся файл в "Human Friends".*
   #### mv  Pets_PackAnimals.txt   HumanFriends.txt

2. *Работа с директориями в Linux.*
*  *Создать новую директорию и переместить туда файл "Human Friends".*
   #### mkdir NewDirectory
   #### mv HumanFriends.txt NewDirectory/
   #### ls [NewDirectory/](/Linux/NewDirectory)   
3. *Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”*
* *Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.*
    ####  sudo apt update  
    #### sudo apt install mysql-server

    #### sudo systemctl start mysql
    #### sudo systemctl status mysql

    #### sudo systemctl enable mysql
    #### mysql -u root -p


    #### wget https://dev.mysql.com/get/mysql-apt-config_0.8.17-1_all.deb
    #### sudo dpkg -i mysql-apt-config_0.8.17-1_all.deb

    #### sudo apt update
    #### sudo apt install mysql-shell   


    #### mysqlsh
4. *Управление deb-пакетами.*
* *Установить и затем удалить deb-пакет, используя команду `dpkg`.*
    #### sudo dpkg -i example.deb
    #### или
    #### sudo apt-get install -f

    #### sudo dpkg -r example
    #### или 
    #### sudo dpkg -P example 








2. *Создать диаграмму.* 
*  *Создать [диаграмму](/OOP/Animals.drawio) классов с родительским классом "Животные", и двумя подклассами: "Pets" и "Pack animals".
В составы классов которых в случае Pets войдут классы: собаки, кошки, хомяки, а в класс Pack animals войдут: Лошади, верблюды и ослы.*

![UML](/OOP/Animals.png)

 7.
 *  *В ранее подключенном MySQL создать базу данных с названием "HumanFriends".*
```sql
CREATE DATABASE Human_friends;
```

*   *Создать таблицы, соответствующие иерархии из вашей диаграммы классов*
```sql
USE Human_friends;
DROP TABLE IF EXISTS animal_classes;
CREATE TABLE animal_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(20)
);

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
('домашние');  

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 

 DROP TABLE IF EXISTS pets;   
CREATE TABLE pets
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Genus_name, Class_id)
VALUES ('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 

DROP TABLE IF EXISTS cats;
CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
```
* *Заполнить таблицы данными о животных, их командах и датами рождения.*
```sql
INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Пупа', '2011-01-01', 'кс-кс-кс', 1),
('Олег', '2016-01-01', "отставить!", 1),  
('Тьма', '2017-01-01', "", 1); 

CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Дик', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
('Граф', '2021-06-12', "сидеть, лежать, лапу", 2),  
('Шарик', '2018-05-01', "сидеть, лежать, лапу, след, фас", 2), 
('Босс', '2021-05-10', "сидеть, лежать, фу, место", 2);

CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Малой', '2020-10-12', '', 3),
('Медведь', '2021-03-12', "атака сверху", 3),  
('Ниндзя', '2022-07-11', NULL, 3), 
('Бурый', '2022-05-10', NULL, 3);

CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Гром', '2020-01-12', 'бегом, шагом', 1),
('Закат', '2017-03-12', "бегом, шагом, хоп", 1),  
('Байкал', '2016-07-12', "бегом, шагом, хоп, брр", 1), 
('Молния', '2020-11-10', "бегом, шагом, хоп", 1);

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Первый', '2019-04-10', NULL, 2),
('Второй', '2020-03-12', "", 2),  
('Третий', '2021-07-12', "", 2), 
('Четвертый', '2022-12-10', NULL, 2);

CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Горбатый', '2022-04-10', 'вернись', 3),
('Самец', '2019-03-12', "остановись", 3),  
('Сифон', '2015-07-12', "повернись", 3), 
('Борода', '2022-12-10', "улыбнись", 3);
```

* *Удалить записи о верблюдах и объединить таблицы лошадей и ослов.*
```sql
SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;
```

* *Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.*
```sql
CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkeys
UNION SELECT *, 'Собаки' AS genus FROM dogs
UNION SELECT *, 'Кошки' AS genus FROM cats
UNION SELECT *, 'Хомяки' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM yang_animal;
```
* *Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.*
```sql
SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name, ya.Age_in_month 
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN pack_animals pa ON pa.Id = h.Genus_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN pack_animals pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name, ya.Age_in_month 
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN pets ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name, ya.Age_in_month 
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN pets ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name, ya.Age_in_month 
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN pets ha ON ha.Id = hm.Genus_id;
```

8. *Создать [ иерархию классов в Java, который будет повторять диаграмму классов созданную в задаче 6(Диаграмма классов) .](/OOP_JAVA/).*
2.  Написать [программу, имитирующую работу реестра домашних животных](/ProgramJava/Program_Java/).
В программе должен быть реализован следующий функционал:    
	* завести новое животное    
	* определять животное в правильный класс    
	* увидеть список команд, которое выполняет животное    
	* обучить животное новым командам    
	* реализовать навигацию по меню 
	* показать общее количество животных   
 
        
![Program](/ProgramJava/Снимок%20экрана%20от%202023-12-09%2018-21-25.png)
