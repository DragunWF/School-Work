BEGIN
    BEGIN TRANSACTION
    DECLARE @MedusaID AS INT = 20;
    DECLARE @MedusaRemainingBalance AS INT = (
        SELECT Balance 
        FROM Students 
        WHERE S_ID = @MedusaID
    );
    DECLARE @PaymentAmount AS INT = 15000;

    -- Medusa tries to make a payment on August 1, 2024
    UPDATE Students
    SET Balance -= @PaymentAmount
    WHERE S_ID = @MedusaID

    INSERT INTO Payment
    VALUES (5, '2020-08-01', @PaymentAmount, @MedusaID)

    IF @MedusaRemainingBalance - @PaymentAmount < 0
    BEGIN
        PRINT 'The transaction could not proceed, the payment that have been received was overpaid. Please try again.'
        PRINT 'Your tuition balance: ' + CAST(@MedusaRemainingBalance AS VARCHAR) + ' | ' + 'Your payment: ' + CAST(@PaymentAmount AS VARCHAR)
        ROLLBACK TRANSACTION 
    END
    ELSE
    BEGIN
        COMMIT
    END
END
SELECT * FROM Students;
SELECT * FROM Payment;