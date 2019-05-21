/*
 * Julia asked her students to create some coding challenges. Write a query to
 * print the HACKER_ID, NAME, and the total number of challenges created by each
 * student. Sort your results by the total number of challenges in descending
 * order. If more than one student created the same number of challenges and the
 * count is less than the maximum number of challenges created, then exclude
 * those students from the result.
 *
 * Input Format
 *
 * The following tables contain challenge data:
 *
 *   * HACKERS: The HACKER_ID is the id of the hacker, and NAME is the name of
 *              the hacker.
 *                             Column  |  Type
 *                           HACKER_ID | INTEGER
 *                           NAME      | STRING
 *
 *   * CHALLENGES: The CHALLENGE_ID is the id of the challenge, and HACKER_ID is
 *                 the id of the student who created the challenge.
 *
 *                            Column   |  Type
 *                        CHALLENGE_ID | INTEGER
 *                        HACKER_ID    | INTEGER
 *
 * Sample Input 0
 *
 * HACKERS Table:
 *
 * HACKER_ID |  NAME
 *    5077   | Rose
 *   21283   | Angela
 *   62743   | Frank
 *   88255   | Patrick
 *   96196   | Lisa
 *
 * CHALLENGES Table:
 *
 * CHALLENGE_ID | HACKER_ID
 *     61654    |    5077
 *     58302    |   21283
 *     40587    |   88255
 *     29477    |    5077
 *      1220    |   21283
 *     69514    |   21283
 *     46561    |   62743
 *     18483    |   88255
 *     76766    |   21283
 *     52382    |    5077
 *     74467    |   21283
 *     33625    |   96196
 *     26053    |   88255
 *     42665    |   62743
 *     12859    |   62743
 *     70094    |   21283
 *     34599    |   88255
 *     54680    |   88255
 *     61881    |    5077
 *
 * Sample Output 0
 *
 * 21283 Angela 6
 * 88255 Patrick 5
 * 96196 Lisa 1
 *
 * Sample Input 1
 *
 * HACKERS Table:
 *
 * HACKER_ID |  NAME
 *   12299   | Rose
 *   34856   | Angela
 *   79345   | Frank
 *   80491   | Patrick
 *   81041   | Lisa
 *
 * CHALLENGES Table:
 *
 * CHALLENGE_ID | HACKER_ID
 *     63963    |   81041
 *     63117    |   79345
 *     28225    |   34856
 *     21989    |   12299
 *      4653    |   12299
 *     70070    |   79345
 *     36905    |   34856
 *     61136    |   80491
 *     17234    |   12299
 *     80308    |   79345
 *     40510    |   34856
 *     79820    |   80491
 *     22720    |   12299
 *     21394    |   12299
 *     36261    |   34856
 *     15334    |   12299
 *     71435    |   79345
 *     23157    |   34856
 *     54102    |   34856
 *     69065    |   80491
 *
 * Sample Output 1
 *
 * 12299 Rose 6
 * 34856 Angela 6
 * 79345 Frank 4
 * 80491 Patrick 3
 * 81041 Lisa 1
 *
 * Explanation
 *
 * For Sample Case 0, we can get the following details:
 *
 * HACKER_ID |  NAME   | CHALLENGES_CREATED
 *   21283   | Angela  |         6
 *   88255   | Patrick |         5
 *    5077   | Rose    |         4
 *   62743   | Frank   |         4
 *   96196   | Lisa    |         1
 *
 * Students 5077 and 62743 both created 4 challenges, but the maximum number of
 * challenges created is 6 so these students are excluded from the result.
 *
 * For Sample Case 1, we can get the following details:
 *
 * HACKER_ID |  NAME   | CHALLENGES_CREATED
 *   12299   | Rose    |         6
 *   34856   | Angela  |         6
 *   79345   | Frank   |         4
 *   80491   | Patrick |         3
 *   81041   | Lisa    |         1
 *
 * Students 12299 and 34856 both created 6 challenges. Because 6 is the maximum
 * number of challenges created, these students are included in the result.
 */

/* Let's break this one down piece by piece..
 */

/* First we get the columns asked in the challenge's statement:
 * Hacker's id, name, and the count of challenges the hacker created.
 */
SELECT H.HACKER_ID, H.NAME, COUNT(C.HACKER_ID)

/* We join both the HACKERS AND CHALLENGES tables to get all the necessary
 * information.
 */
FROM HACKERS H INNER JOIN CHALLENGES C
    ON H.HACKER_ID = C.HACKER_ID

/* We need to group rows by the columns we use for the result.
 * Why? I'm glad you ask. Because we need to use the COUNT aggregate function
 * in a couple of really creative ways as soon you'll see.
 */
GROUP BY H.HACKER_ID, H.NAME

    /* Here's where the fun begins:
     * We need to include as part of our result those students that have
     * created the maximum count of challenges by a single student.
     */
    HAVING COUNT(C.HACKER_ID) = (SELECT MAX(COUNT(Q1.HACKER_ID))
                                 FROM CHALLENGES Q1
                                 GROUP BY Q1.HACKER_ID)

        /* We also include the students that have created less than the maximum
         * count of challenges by a single student but at the same time there is
         * not another student that has created the same count of challenges.
         */
        OR COUNT(C.HACKER_ID) IN (SELECT T.CC
                                  FROM (SELECT COUNT(Q2.HACKER_ID) AS "CC"
                                        FROM CHALLENGES Q2
                                        GROUP BY Q2.HACKER_ID) T
                                  /* Here's the key for this query:
                                   * We group the counts of challenges created
                                   * by each student and only take those whose
                                   * count's count is one, meaning only one
                                   * student has created this many challenges.
                                   */
                                  GROUP BY T.CC HAVING COUNT(T.CC) = 1)

/* Finally we order the results as requested */
ORDER BY COUNT(C.HACKER_ID) DESC, H.HACKER_ID ASC;
