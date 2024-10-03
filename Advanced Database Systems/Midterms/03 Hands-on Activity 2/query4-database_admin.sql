-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	-- Database Admin sets an exclusive lock
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	-- Database Admin adds a 1000 balance to all rows in Accounts table
	-- An alternative is to use a loop but not adding WHERE clause in UPDATE already
	-- adds the balance to all accounts making this more concise
	UPDATE Accounts
	SET Balance += 1000
	SELECT * FROM Accounts

	WAITFOR DELAY '00:00:10'
	COMMIT
END