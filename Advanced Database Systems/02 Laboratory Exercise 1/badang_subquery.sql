-- Badang's Customer ID is "Cust-1"

SELECT Customers.Cust_Name, Items.ItemName, Items.Price
FROM Orders
JOIN Customers ON Customers.CustomerID = Orders.CustomerID
JOIN Items ON Items.ItemID = Orders.ItemID
WHERE Items.Price > (
    SELECT Items.Price
    FROM Orders
    JOIN Customers ON Customers.CustomerID = Orders.CustomerID
    JOIN Items ON Items.ItemID = Orders.ItemID
    WHERE Customers.CustomerID = 'Cust-1'
)
ORDER BY Items.Price