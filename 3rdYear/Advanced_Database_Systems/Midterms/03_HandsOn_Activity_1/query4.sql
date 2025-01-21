BEGIN
	BEGIN TRANSACTION
    
    -- Cashier mistakenly encoded the payment to Slark
    DECLARE @TuitionFeePayment AS INT = 15000
    DECLARE @StudentID AS INT = 50 -- Slark's ID

    UPDATE Students
    SET Balance -= @TuitionFeePayment
    WHERE S_ID = @StudentID
                                      
    -- Cashier realized her unwanted mistake
    ROLLBACK TRANSACTION

    BEGIN TRANSACTION
    -- Sets the StudentID to the correct person (Lina)
    SET @StudentID = 90 -- Lina's ID

    UPDATE Students
    SET Balance -= @TuitionFeePayment
    WHERE S_ID = @StudentID

    INSERT INTO Payment
    VALUES (4, '2020-07-28', @TuitionFeePayment, @StudentID)

    COMMIT
END
SELECT * FROM Students;
SELECT * FROM Payment;