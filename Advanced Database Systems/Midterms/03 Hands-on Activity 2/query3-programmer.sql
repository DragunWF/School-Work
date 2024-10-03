-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	-- Application Programmer inserts a new entry in Accounts
	BEGIN TRANSACTION
	DECLARE @ClintID AS INT = 6
	DECLARE @ClintBalance AS DECIMAL = 19000

	INSERT INTO Accounts
	VALUES (@ClintID, 'Clint', @ClintBalance)
	INSERT INTO Transac_History
	VALUES (4, '2020-08-28', @ClintBalance, @ClintID)

	COMMIT
	SELECT * FROM Transac_History
END