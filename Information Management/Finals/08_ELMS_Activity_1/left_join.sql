SELECT Vendors.VendorName, Items.ItemDesc
FROM Vendors
LEFT JOIN Items ON Vendors.VendorID = Items.VendorID;