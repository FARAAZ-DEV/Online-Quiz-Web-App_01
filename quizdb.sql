--1️⃣ Create Database (If Not Created)

CREATE DATABASE online_quiz;
USE online_quiz;

--2️⃣ Create users Table

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY (id)
);

INSERT INTO users (username, password)
VALUES ('student', '123');

--3️⃣ Create questions Table

CREATE TABLE questions (
    qid INT NOT NULL AUTO_INCREMENT,
    question VARCHAR(255),
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    correct VARCHAR(50),
    PRIMARY KEY (qid)
);

INSERT INTO questions (question, option1, option2, option3, option4, correct)
VALUES
('Java is?', 'Language', 'Animal', 'Car', 'Game', 'Language'),
('JSP stands for?', 'Java Server Pages', 'Java Simple Program', 'Just Server Page', 'None', 'Java Server Pages');

--End of SQL Script