SELECT Vendors.VendorName, Items.ItemDesc
FROM Vendors
INNER JOIN Items ON Vendors.VendorID = Items.VendorID;