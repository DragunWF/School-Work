-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
    BEGIN TRANSACTION
	DECLARE @StarkID AS INT = 5
	DECLARE @WithdrawAmount AS DECIMAL = 1000

    UPDATE Accounts
    SET Balance -= @WithdrawAmount
    WHERE A_ID = @StarkID
	INSERT INTO Transac_History
	VALUES (3, '2020-09-21', -@WithdrawAmount, @StarkID); -- August 21, 2020
    WAITFOR DELAY '00:00:10'

    ROLLBACK TRANSACTION
    SELECT * FROM Accounts WHERE A_ID = 5
END
