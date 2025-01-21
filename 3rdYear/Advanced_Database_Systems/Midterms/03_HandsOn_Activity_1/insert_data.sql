CREATE TABLE [dbo].[Payment](
	[P_ID] [int] NULL,
	[Date] [date] NULL,
	[Amount] [decimal](18, 2) NULL,
	[S_ID] [int] NULL
);
CREATE TABLE [dbo].[Students](
	[S_ID] [int] NULL,
	[Name] [varchar](50) NULL,
	[Tuition_Fee] [decimal](18, 2) NULL,
	[Balance] [decimal](18, 2) NULL
);
INSERT [dbo].[Payment] ([P_ID], [Date], [Amount], [S_ID]) VALUES (1, CAST(N'2020-07-20' AS Date), CAST(23000.00 AS Decimal(18, 2)), 10);
INSERT [dbo].[Students] ([S_ID], [Name], [Tuition_Fee], [Balance]) VALUES (10, N'Abaddon', CAST(23000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)));
INSERT [dbo].[Students] ([S_ID], [Name], [Tuition_Fee], [Balance]) VALUES (20, N'Medusa', CAST(25000.00 AS Decimal(18, 2)), CAST(13000.00 AS Decimal(18, 2)));
INSERT [dbo].[Students] ([S_ID], [Name], [Tuition_Fee], [Balance]) VALUES (50, N'Slark', CAST(18000.00 AS Decimal(18, 2)), CAST(18000.00 AS Decimal(18, 2)));
INSERT [dbo].[Students] ([S_ID], [Name], [Tuition_Fee], [Balance]) VALUES (70, N'Leshrac', CAST(29000.00 AS Decimal(18, 2)), CAST(26000.00 AS Decimal(18, 2)));
INSERT [dbo].[Students] ([S_ID], [Name], [Tuition_Fee], [Balance]) VALUES (90, N'Lina', CAST(15000.00 AS Decimal(18, 2)), CAST(15000.00 AS Decimal(18, 2)));