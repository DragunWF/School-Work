SELECT Vendors.VendorName, Items.ItemDesc
FROM Vendors
RIGHT JOIN Items ON Vendors.VendorID = Items.VendorID;