-- Personally, I wanted to use inner joins here since it's much cleaner
-- but the lab exercise instructions require me to use subqueries so here it is

CREATE VIEW Subqueries_View
AS
SELECT (SELECT CONCAT('Lab_OR-', Orders.OrderID)) AS 'New OrderID', 
       Customers.Cust_Name, Customers.Address, Items.ItemName, Items.Price
FROM Orders
JOIN Customers ON Customers.CustomerID = Orders.CustomerID
JOIN Items ON Items.ItemID = Orders.ItemID
WHERE Items.Price > (
    SELECT Items.Price -- Subquery for obtaining the price of Badang's Purchased item
    FROM Orders
    JOIN Customers ON Customers.CustomerID = Orders.CustomerID
    JOIN Items ON Items.ItemID = Orders.ItemID
    WHERE Customers.CustomerID = 'Cust-1'
)