-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
    BEGIN TRANSACTION
    -- Mrs Slark views the balance of their account
    SELECT * FROM Accounts WHERE A_ID = 5;
    COMMIT
END
