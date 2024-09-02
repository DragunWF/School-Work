-- Personally, I wanted to use inner joins here since it's much cleaner
-- but the lab exercise instructions require me to use subqueries so here it is

CREATE VIEW Subqueries_View
AS
SELECT CONCAT('Lab_', Orders.OrderID) AS 'New OrderID',
       (SELECT Cust_Name FROM Customers WHERE Customers.CustomerID = Orders.CustomerID) AS Cust_Name,
       (SELECT Address FROM Customers WHERE Customers.CustomerID = Orders.CustomerID) AS Address,
       (SELECT ItemName FROM Items WHERE Items.ItemID = Orders.ItemID) AS ItemName,
       (SELECT Price FROM Items WHERE Items.ItemID = Orders.ItemID) AS Price
FROM Orders