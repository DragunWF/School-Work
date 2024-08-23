BEGIN
	DECLARE @TargetId AS INT = 1,
			@FirstName AS VARCHAR(50),
			@LastName AS VARCHAR(50),
			@Age AS INT,
			@Gender AS VARCHAR(50),
			@Level AS VARCHAR(50)
	SET NOCOUNT ON; -- The sample output shown in the laboratory exercise requires that it only shows the values of the rows hence this line

	WHILE (@TargetId <= 10)
	BEGIN
		SELECT @LastName = LastName, @FirstName = FirstName,
			   @Age = Age, @Gender = Gender, @Level = Level
		FROM Records
		WHERE Id = @TargetId

		UPDATE Records
		SET Level = CASE
						WHEN @Age BETWEEN 14 AND 16 THEN 'Freshman'
						WHEN @Age BETWEEN 17 AND 19 THEN 'Sophomore'
						WHEN @Age BETWEEN 20 AND 22 THEN 'Junior'
						WHEN @Age BETWEEN 23 AND 25 THEN 'Senior'
						ELSE 'Unknown'
					END
		WHERE Id = @TargetId

		PRINT 'Id: ' + CAST(@TargetId AS VARCHAR(3)) + ' | ' +
			  'Name: ' + @FirstName + ' ' + @LastName + ' | ' +
			  'Age: ' + CAST(@Age AS VARCHAR(3)) + ' | ' +
			  'Gender: ' + @Gender + ' | ' +
			  'Level: ' + UPPER(@Level)
		SET @TargetId = @TargetId + 1
	END
END