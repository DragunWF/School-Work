BEGIN
	BEGIN TRANSACTION
    
    DECLARE @TuitionFeePayment AS INT = 15000
    DECLARE @StudentID = 50

    UPDATE Students
    SET Balance -= @TutionFeePayment
    WHERE S_ID = @StudentID
    SAVE TRANSACTION TuitionFeePaymentTransfer
                                      
    -- Cashier realized his unwanted mistake
    ROLLBACK TRANSACTION TuitionFeePaymentTransfer

    BEGIN TRANSACTION
    -- Sets the StudentID to the correct person (Lina)
    SET @StudentID = 90 

    UPDATE Students
    SET Balance -= @TutionFeePayment
    WHERE S_ID = @StudentID

    INSERT INTO Payment
    VALUES (4, '2020-07-28', @TuitionFeePayment, @StudentID)

    COMMIT
END