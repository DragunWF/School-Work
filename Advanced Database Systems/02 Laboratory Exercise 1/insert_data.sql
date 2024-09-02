CREATE TABLE [Customers](
	[CustomerID] [varchar](50) NULL,
	[Cust_Name] [varchar](50) NULL,
	[Address] [varchar](50) NULL
);

CREATE TABLE [Items](
	[ItemID] [varchar](50) NULL,
	[ItemName] [varchar](50) NULL,
	[Price] [decimal](18, 2) NULL
);

CREATE TABLE [Orders](
	[OrderID] [varchar](50) NULL,
	[OrderDate] [date] NULL,
	[ItemID] [varchar](50) NULL,
	[CustomerID] [varchar](50) NULL
);

INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-1', N'Badang', N'Makati')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-2', N'Hanzo', N'Taguig')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-3', N'Lilia', N'Rizal')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-4', N'Layla', N'Laguna')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-5', N'Lesley', N'Laguna')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-6', N'Balmond', N'Makati')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-7', N'Chou', N'Navotas')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-8', N'Eudora', N'Malabon')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-9', N'Miya', N'Taguig')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-10', N'Cecilion', N'Navotas')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-11', N'Roger', N'Baguio')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-12', N'Cong', N'Cebu')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-13', N'Emman', N'Cebu')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-14', N'Jerome', N'Baguio')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-15', N'Gusion', N'Davao')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-16', N'Lancelot', N'Iloilo')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-17', N'Granger', N'Antipolo')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-18', N'Irithel', N'Makati')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-19', N'Alucard', N'Binondo')
INSERT [dbo].[Customers] ([CustomerID], [Cust_Name], [Address]) VALUES (N'Cust-20', N'Carmilla', N'Malabon');
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-1', N'Samsung S9', CAST(32000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-2', N'Samsung S10', CAST(40000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-3', N'Huawei P30', CAST(29000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-4', N'Huawei Mate30', CAST(31000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-5', N'Realme 6', CAST(9999.99 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-6', N'Realme 6 Pro', CAST(11000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-7', N'Xiaomi Note 9', CAST(8000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-8', N'Xiaomi Note 10', CAST(11000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-9', N'LG V40', CAST(15000.00 AS Decimal(18, 2)))
INSERT [dbo].[Items] ([ItemID], [ItemName], [Price]) VALUES (N'IT-10', N'LG V50', CAST(23000.00 AS Decimal(18, 2)));
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-1', CAST(N'2019-08-14' AS Date), N'IT-6', N'Cust-10')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-2', CAST(N'2019-12-04' AS Date), N'IT-3', N'Cust-9')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-3', CAST(N'2017-08-20' AS Date), N'IT-7', N'Cust-13')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-4', CAST(N'2018-06-12' AS Date), N'IT-10', N'Cust-7')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-5', CAST(N'2017-02-28' AS Date), N'IT-5', N'Cust-6')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-6', CAST(N'2019-05-21' AS Date), N'IT-9', N'Cust-11')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-7', CAST(N'2017-12-27' AS Date), N'IT-2', N'Cust-5')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-8', CAST(N'2017-02-10' AS Date), N'IT-4', N'Cust-3')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-9', CAST(N'2018-09-12' AS Date), N'IT-10', N'Cust-9')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-10', CAST(N'2018-01-17' AS Date), N'IT-3', N'Cust-4')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-11', CAST(N'2019-02-11' AS Date), N'IT-6', N'Cust-7')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-12', CAST(N'2018-02-23' AS Date), N'IT-4', N'Cust-9')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-13', CAST(N'2018-11-01' AS Date), N'IT-7', N'Cust-2')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-14', CAST(N'2018-01-11' AS Date), N'IT-8', N'Cust-4')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-15', CAST(N'2018-05-28' AS Date), N'IT-1', N'Cust-2')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-16', CAST(N'2017-01-03' AS Date), N'IT-6', N'Cust-1')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-17', CAST(N'2019-01-17' AS Date), N'IT-8', N'Cust-9')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-18', CAST(N'2017-06-22' AS Date), N'IT-3', N'Cust-7')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-19', CAST(N'2017-04-09' AS Date), N'IT-7', N'Cust-3')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-20', CAST(N'2019-09-15' AS Date), N'IT-5', N'Cust-5')
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [ItemID], [CustomerID]) VALUES (N'OR-21', CAST(N'2017-08-13' AS Date), N'IT-9', N'Cust-4');