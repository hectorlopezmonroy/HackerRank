/*
 * You did such a great job helping Julia with her coding contest challenge that
 * she wants you to work on this one, too!
 *
 * The total score of a hacker is the sum of their maximum scores for all of the
 * challenges. Write a query to print the HACKER_ID, NAME, and total score of
 * the hackers ordered by the descending score. If more than one hacker achieved
 * the same total score, then sort the result by ascending HACKER_ID. Exclude
 * all hackers with a total score of 0 from your result.
 *
 * Input Format
 *
 * The following tables contain contest data:
 *
 *   * HACKERS: The HACKER_ID is the id of the hacker, and NAME is the name of
 *              the hacker.
 *
 *                                Column  |  Type
 *                              HACKER_ID | INTEGER
 *                              NAME      | STRING
 *
 *   * SUBMISSIONS: The SUBMISSION_ID is the id of the submission, HACKER_ID is
 *                  the id of the hacker who made the submission, CHALLENGE_ID
 *                  is the id of the challenge that the submission belongs to,
 *                  and SCORE is the score of the submission.
 *
 *                              Column    |  Type
 *                          SUBMISSION_ID | INTEGER
 *                          HACKER_ID     | INTEGER
 *                          CHALLENGE_ID  | INTEGER
 *                          SCORE         | INTEGER
 *
 * Sample Input
 *
 * HACKERS table:
 *
 * HACKER_ID | NAME
 *     4071  | Rose
 *     4806  | Angela
 *    26071  | Frank
 *    49438  | Patrick
 *    74842  | Lisa
 *    80305  | Kimberly
 *    84072  | Bonnie
 *    87868  | Michael
 *    92118  | Todd
 *    95895  | Joe
 *
 * SUBMISSIONS table:
 *
 * SUBMISSION_ID | HACKER_ID | CHALLENGE_ID | SCORE
 *     67194     |   74842   |     63132    |   76
 *     64479     |   74842   |     19797    |   98
 *     40742     |   26071   |     49593    |   20
 *     17513     |    4806   |     49593    |   32
 *     69846     |   80305   |     19797    |   19
 *     41002     |   26071   |     89343    |   36
 *     52826     |   49438   |     49593    |    9
 *     31093     |   26071   |     19797    |    2
 *     81614     |   84072   |     49593    |  100
 *     44829     |   26071   |     89343    |   17
 *     75147     |   80305   |     49593    |   48
 *     14115     |    4806   |     49593    |   76
 *      6943     |    4071   |     19797    |   95
 *     12855     |    4806   |     25917    |   13
 *     73343     |   80305   |     49593    |   42
 *     84264     |   84072   |     63132    |    0
 *      9951     |    4071   |     49593    |   43
 *     45104     |   49438   |     25917    |   34
 *     53795     |   74842   |     19797    |    5
 *     26363     |   26071   |     19797    |   29
 *     10063     |    4071   |     49593    |   96
 *
 * Sample Output
 *
 * 4071 Rose 191
 * 74842 Lisa 174
 * 84072 Bonnie 100
 * 4806 Angela 89
 * 26071 Frank 85
 * 80305 Kimberly 67
 * 49438 Patrick 43
 *
 * Explanation
 *
 * Hacker 4071 submitted solutions for challenges 19797 and 49593, so the total
 * score = 95 + max(43, 96) = 191.
 *
 * Hacker 74842 submitted solutions for challenges 19797 and 63132, so the total
 * score = max(98, 5) + 76 = 174.
 *
 * Hacker 84072 submitted solutions for challenges 49593 and 63132, so the total
 * score = 100 + 0 = 100.
 *
 * The total scores for hackers 4806, 26071, 80305, and 49438 can be similarly
 * calculated.
 */

/* Selects all relevant columns required for this challenge. */
SELECT H.HACKER_ID, H.NAME, SUM(MAX_SCORES.SCORE) AS "TOTAL_SCORE"
FROM HACKERS H INNER JOIN

    /* This nested query groups all submissions by CHALLENGE_ID and HACKER_ID.
     * This allows us to get the maximum score each hacker gets on each
	 * challenge.
     */
    (SELECT S.HACKER_ID, S.CHALLENGE_ID, MAX(S.SCORE) AS "SCORE"
     FROM SUBMISSIONS S
     GROUP BY S.HACKER_ID, S.CHALLENGE_ID
     ORDER BY S.HACKER_ID, S.CHALLENGE_ID) MAX_SCORES

/* Using the proper column to join the HACKERS table with our newly named
 * MAX_SCORES nested query.
 */
ON H.HACKER_ID = MAX_SCORES.HACKER_ID

/* Grouping by H.HACKER_ID AND H.NAME we can effectively SUM all MAX_SCORES each
 * hacker gets on their submissions.
 */
GROUP BY H.HACKER_ID, H.NAME HAVING SUM(MAX_SCORES.SCORE) > 0

/* Orders results as requested. */
ORDER BY TOTAL_SCORE DESC, H.HACKER_ID ASC;
