-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	BEGIN TRANSACTION
	-- Sophisticated user named Joe adds an entry
	DECLARE @NatashaID AS INT = 7
	DECLARE @NatashaBalance AS DECIMAL = 9000

	INSERT INTO Accounts
	VALUES (@NatashaID, 'Natasha', @NatashaBalance)
	-- The instructions mention a T_ID so I added a new entry to Transac_History
	-- Furthermore, in other instructions; an entry in Transac_History is
	-- inserted everytime a new account is added
	INSERT INTO Transac_History 
	VALUES (7, '2020-09-28', @NatashaBalance, @NatashaID) -- On the same day (According to instructions, August 28, 2020)

	SELECT * FROM Accounts

	COMMIT
END