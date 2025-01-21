BEGIN
	DECLARE @TargetId AS INT = 1,
			@FirstName AS VARCHAR(50),
			@LastName AS VARCHAR(50),
			@Age AS INT,
			@Gender AS VARCHAR(50),
			@Level AS VARCHAR(50)

	WHILE (@TargetId <= 10)
	BEGIN
		SELECT @LastName = LastName, @FirstName = FirstName,
			   @Age = Age, @Gender = Gender, @Level = Level
		FROM Records
		WHERE Id = @TargetId

		DECLARE @NewLevel AS VARCHAR(50)
		-- The BEGIN and END clauses are not needed when there's only one line within an if and else block
		-- Overall, this makes the code more concise and much cleaner..
		IF @Age BETWEEN 14 AND 16
			SET @NewLevel = 'Freshman';
		ELSE IF @Age BETWEEN 17 AND 19
			SET @NewLevel = 'Sophomore';
		ELSE IF @Age BETWEEN 20 AND 22
			SET @NewLevel = 'Junior';
		ELSE IF @Age BETWEEN 23 AND 25
			SET @NewLevel = 'Senior';
		ELSE
			SET @NewLevel = 'Unknown';
		UPDATE Records SET Level = @NewLevel WHERE Id = @TargetId

		PRINT 'Id: ' + CAST(@TargetId AS VARCHAR(3)) + ' | ' +
			  'Name: ' + @FirstName + ' ' + @LastName + ' | ' +
			  'Age: ' + CAST(@Age AS VARCHAR(3)) + ' | ' +
			  'Gender: ' + @Gender + ' | ' +
			  'Level: ' + LOWER(@Level)
		SET @TargetId = @TargetId + 1
	END
END