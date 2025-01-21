BEGIN
    BEGIN TRANSACTION
    DECLARE @SlarkID AS INT = 50;
    -- The instructions assumes that Slark is paying on this date
    DECLARE @DateSlarkPaid AS DATE = '2020-08-05';

    -- Tuition applies the 15% off when paying on August 5, 2020
    IF @DateSlarkPaid = '2020-08-05'
    BEGIN
        UPDATE Students
        SET Balance -= Balance * 0.15, 
            TuitionFee -= TuitionFee * 0.15
        WHERE S_ID = @SlarkID
    END

    -- Slark decides to make a full payment with the discount applied
    DECLARE @SlarkPayment AS INT = (
        SELECT Balance FROM Students WHERE S_ID = @SlarkID
    )
    UPDATE Students
    SET Balance -= @SlarkPayment
    WHERE S_ID = @SlarkID

    INSERT INTO Payment
    VALUES (6, @DateSlarkPaid, @SlarkPayment, @SlarkID)

    COMMIT
END
SELECT * FROM Students;
SELECT * FROM Payment;