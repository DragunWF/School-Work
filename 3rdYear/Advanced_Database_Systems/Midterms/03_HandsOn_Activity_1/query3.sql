BEGIN
	BEGIN TRANSACTION
    
    DECLARE @PaymentAmount AS INT = 1000;
    
    UPDATE Students
    SET Balance -= @PaymentAmount
    WHERE S_ID = 70 OR S_ID = 20; -- Medusa and Leshrac IDs
    SAVE TRANSACTION PaymentTransfer
    
    INSERT INTO Payment
    VALUES (2, '2020-07-21', @PaymentAmount, 20),
    	   (3, '2020-07-21', @PaymentAmount, 70);
    
    DECLARE @MedusaBalance AS INT = (SELECT balance FROM Students WHERE S_ID = 20;
    DECLARE @LeshracBalance AS INT = (SELECT balance from Students WHERE S_ID = 70;
                                      
    if @MedusaBalance < 0 OR @LeshracBalance < 0
    BEGIN
        ROLLBACK PaymentTransfer
    END
    ELSE IF @MedusaBalance >= 0 AND @LeshracBalance >= 0
    BEGIN
        SAVE TRANSACTION PaymentWithdraw
    END
                                      
    COMMIT
END