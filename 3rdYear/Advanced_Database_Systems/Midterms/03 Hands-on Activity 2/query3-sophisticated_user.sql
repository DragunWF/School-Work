-- Marc Plarisan | BSIT501 | Advanced Database Systems

BEGIN
	-- Sophisticated user modifies the balance of Thor
	BEGIN TRANSACTION
	DECLARE @ThorID AS INT = 1
	DECLARE @DeductionAmount AS DECIMAL = 500

	UPDATE Accounts
	SET Balance -= @DeductionAmount
	WHERE A_ID = @ThorID
	INSERT INTO Transac_History
	VALUES (3, '2020-08-28', -@DeductionAmount, @ThorID) 

	COMMIT
END