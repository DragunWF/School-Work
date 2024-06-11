SELECT Vendors.VendorName, Items.ItemDesc
FROM Vendors
FULL JOIN Items ON Vendors.VendorID = Items.VendorID;