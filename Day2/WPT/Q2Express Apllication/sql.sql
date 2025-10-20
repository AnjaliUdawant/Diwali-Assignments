CREATE DATABASE webtech;
USE webtech;

CREATE TABLE Users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(50),
  lastname VARCHAR(50),
  email VARCHAR(100),
  userid VARCHAR(50),
  password VARCHAR(100)
);
