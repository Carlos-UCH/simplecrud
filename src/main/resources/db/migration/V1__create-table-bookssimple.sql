CREATE TABLE books (
    id INT NOT NULL auto_increment PRIMARY KEY,
    author VARCHAR(100) NOT NULL,
    genres VARCHAR(100) NOT NULL, 
    publication DATE,
    pages INT NOT NULL

);