CREATE SCHEMA IF NOT EXISTS socialmedia DEFAULT CHARACTER SET utf8;
USE socialmedia;

CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE posts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    author VARCHAR(255),
    createDateTime DATETIME
);

CREATE TABLE comments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(1000),
    author VARCHAR(255),
    createDateTime DATETIME
);