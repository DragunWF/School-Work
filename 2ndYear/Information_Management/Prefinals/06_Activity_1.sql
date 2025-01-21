CREATE TABLE flavors (
	ItemCode INT PRIMARY KEY,
	ItemDesc VARCHAR(50),
	Price FLOAT CHECK (Price >= 65)
);

ALTER TABLE flavors DROP COLUMN ItemDesc;