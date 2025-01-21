CREATE INDEX ix_CustomerRecords
ON Customers(CustomerID, Cust_Name);

CREATE INDEX ix_ItemRecords
ON Items(ItemID, ItemName);

CREATE INDEX ix_OrderRecords
ON Orders(OrderID, CustomerID);