CREATE TABLE Items (
	ItemID INT PRIMARY KEY,
	ItemName VARCHAR(300),
	Price DECIMAL(10, 2)
);

INSERT INTO Items
VALUES (001, 'Gatorade', 90.00),
	   (002, 'VitaMilk', 35.00);

SELECT * FROM Items;