CREATE DATABASE ConcurrencyControl

USE ConcurrencyControl;

CREATE TABLE Accounts (
	A_ID INT PRIMARY KEY,
  	Name VARCHAR(50),
  	Balance DECIMAL(18, 2)
);

CREATE TABLE Transac_History (
	T_ID INT, -- No primary key since the instructions needs to insert two rows with the same key
    Date DATE,
    Amount DECIMAL(18, 2),
    A_ID INT
);

INSERT INTO Accounts
VALUES (1, 'Thor', 8000),
	   (2, 'Hulk', 4000),
       (3, 'Thanos', 12000),
       (4, 'Loki', 3000),
       (5, 'Stark', 15000);
 
 INSERT INTO Transac_History
 VALUES (1, '2020-09-02', -1500, 3),
 		(2, '2020-09-03', 3000, 5),
        (2, '2020-09-03', -3000, 1);