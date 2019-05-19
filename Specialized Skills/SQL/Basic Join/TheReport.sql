/*
 * You are given two tables: STUDENTS and GRADES. STUDENTS contains three
 * columns: ID, NAME and MARKS.
 *
 * Column |   Type
 * ID     | INTEGER
 * NAME   | STRING
 * MARKS  | INTEGER
 *
 * GRADES contains the following data:
 *
 * GRADE | MIN_MARK | MAX_MARK
 *   1   |     0    |     9
 *   2   |    10    |    19
 *   3   |    20    |    29
 *   4   |    30    |    39
 *   5   |    40    |    49
 *   6   |    50    |    59
 *   7   |    60    |    69
 *   8   |    70    |    79
 *   9   |    80    |    89
 *   10  |    90    |   100
 *
 * Ketty gives Eve a task to generate a report containing three columns: NAME,
 * GRADE and MARK. Ketty doesn't want the NAME of those students who received a
 * grade lower than 8. The report must be in descending order by grade -- i.e.
 * higher grades are entered first. If there is more than one student with the
 * same grade (8-10) assigned to them, order those particular students by their
 * name alphabetically. Finally, if the grade is lower than 8, use "NULL" as
 * their name and list them by their grades in descending order. If there is
 * more than one student with the same grade (1-7) assigned to them, order those
 * particular students by their marks in ascending order.
 *
 * Write a query to help Eve.
 *
 * Sample Input
 *
 * ID |   NAME   | MARKS
 * 1  | Julia    |   88
 * 2  | Samantha |   68
 * 3  | Maria    |   99
 * 4  | Scarlet  |   78
 * 5  | Ashley   |   63
 * 6  | Jane     |   81
 *
 * Sample Output
 *
 * Maria 10 99
 * Jane 9 81
 * Julia 9 88
 * Scarlet 8 78
 * NULL 7 63
 * NULL 7 68
 *
 * Note: Print "NULL" as the name if the grade is less than 8.
 *
 * Explanation
 *
 * Consider the following table with the grades assigned to the students:
 *
 * ID |   NAME   | MARKS | GRADE
 * 1  | Julia    |   88  |   9
 * 2  | Samantha |   68  |   7
 * 3  | Maria    |   99  |  10
 * 4  | Scarlet  |   78  |   8
 * 5  | Ashley   |   63  |   7
 * 6  | Jane     |   81  |   9
 *
 * So, the following students got 8, 9 or 10 grades:
 *
 *   * Maria (grade 10)
 *   * Jane (grade 9)
 *   * Julia (grade 9)
 *   * Scarlet (grade 8)
 */

SELECT
    CASE
        WHEN G.GRADE < 8 THEN 'NULL'
        ELSE S.NAME
    END,
    G.GRADE, S.MARKS
FROM STUDENTS S INNER JOIN GRADES G
ON S.MARKS BETWEEN G.MIN_MARK AND G.MAX_MARK
ORDER BY G.GRADE DESC, S.NAME ASC, S.MARKS ASC;
