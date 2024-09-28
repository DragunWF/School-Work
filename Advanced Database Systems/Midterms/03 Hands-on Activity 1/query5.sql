BEGIN
    DECLARE @MedusaID = 20;
    DECLARE @MedusaRemainingBalance AS INT = (
        SELECT Balance 
        FROM Students 
        WHERE S_ID = @MedusaID
    );
    DECLARE @PaymentAmount AS INT = 15000;

    UPDATE Students
    SET Balance -= @PaymentAmount
    WHERE S_ID = @MedusaID
    SAVE TRANSACTION MedusaPaymentTransfer;

    IF @MedusaRemainingBalance - @PaymentAmount < 0
    BEGIN
        PRINT 'The transaction could not proceed, the payment that have been received was overpaid. Please try again.'
        PRINT 'Your tuition balance: ' + @MedusaRemainingBalance + ' | ' + 'Your payment: ' + @PaymentAmount
        ROLLBACK TRANSACTION MedusaPaymentTransfer
    END

    COMMIT
END