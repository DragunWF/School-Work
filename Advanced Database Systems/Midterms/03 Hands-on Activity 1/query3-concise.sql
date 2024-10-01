BEGIN
	BEGIN TRANSACTION
    DECLARE @PaymentAmount AS INT = 1000;
    
    UPDATE Students
    SET Balance -= @PaymentAmount
    WHERE S_ID = 70 OR S_ID = 20; -- Medusa and Leshrac IDs
    
    INSERT INTO Payment
    VALUES (2, '2020-07-21', @PaymentAmount, 20),
    	   (3, '2020-07-21', @PaymentAmount, 70);
                                      
    COMMIT
END