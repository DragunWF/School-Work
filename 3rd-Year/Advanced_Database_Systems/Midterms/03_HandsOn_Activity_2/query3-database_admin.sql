-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	-- Database Administrator sets a lock
	SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
	BEGIN TRANSACTION
	SELECT * FROM Accounts -- Output at the start of Transaction
	WAITFOR DELAY '00:00:15'
	SELECT * FROM Accounts -- Output during the Transaction
	WAITFOR DELAY '00:00:05'
	COMMIT
	SELECT * FROM Accounts -- Output at the end of Transaction
END