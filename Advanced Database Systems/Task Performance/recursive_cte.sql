WITH Recursive_CTE(ID, Name, LeaderID, Rank)
AS 
(
	SELECT ID, Name, LeaderID, 0 AS Rank
    FROM Students
    WHERE LeaderID IS NULL
    UNION ALL
    SELECT S.ID, S.Name, S.LeaderID, R.Rank + 1
    FROM Students S
    JOIN Recursive_CTE R ON R.ID = S.LeaderID
)

SELECT * 
FROM Recursive_CTE
ORDER BY Rank;