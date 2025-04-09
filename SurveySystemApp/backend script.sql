CREATE DATABASE IF NOT EXISTS UsersLoginDB;

USE UsersLoginDB;

CREATE TABLE IF NOT EXISTS UsersLoginInfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender ENUM('Male', 'Female') NOT NULL,
    contact VARCHAR(15) NOT NULL
);
select * from usersLoginInfo;



CREATE DATABASE IF NOT EXISTS UsersSurveyDB;
USE UsersSurveyDB;

CREATE TABLE UsersSurveyInfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    question TEXT,
    selected_option VARCHAR(255),
    submission_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


select * From UsersSurveyInfo;

show databases;