/*
 * Julia just finished conducting a coding contest, and she needs your help
 * assembling the leaderboard! Write a query to print the respective HACKER_ID
 * and NAME of hackers who achieved full scores for more than one challenge.
 * Order your output in descending order by the total number of challenges in
 * which the hacker earned a full score. If more than one hacker received full
 * scores in the same number of challenges, then sort them by ascending
 * HACKER_ID.
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
 *   * DIFFICULTY: The DIFFICULTY_LEVEL is the level of difficulty of the
 *                 challenge, and SCORE is the score of the challenge for the
 *                 difficulty level.
 *
 *                             Column     |  Type
 *                       DIFFICULTY_LEVEL | INTEGER
 *                       SCORE            | INTEGER
 *
 *   * CHALLENGES: The CHALLENGE_ID is the id of the challenge, the HACKER_ID is
 *                 the id of the hacker who created the challenge, and
 *                 DIFFICULTY_LEVEL is the level of difficulty of the challenge.
 *
 *                             Column     |  Type
 *                       CHALLENGE_ID     | INTEGER
 *                       HACKER_ID        | INTEGER
 *                       DIFFICULTY_LEVEL | INTEGER
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
 *     5580  | Rose
 *     8439  | Angela
 *    27205  | Frank
 *    52243  | Patrick
 *    52348  | Lisa
 *    57645  | Kimberly
 *    77726  | Bonnie
 *    83082  | Michael
 *    86870  | Todd
 *    90411  | Joe
 *
 * DIFFICULTY table:
 *
 * DIFFICULTY_LEVEL | SCORE
 *         1        |   20
 *         2        |   30
 *         3        |   40
 *         4        |   60
 *         5        |   80
 *         6        |  100
 *         7        |  120
 *
 * CHALLENGES table:
 *
 * CHALLENGE_ID | HACKER_ID | DIFFICULTY_LEVEL
 *      4810    |   77726   |        4
 *     21089    |   27205   |        1
 *     36566    |    5580   |        7
 *     66730    |   52243   |        6
 *     71055    |   52243   |        2
 *
 * SUBMISSIONS table:
 *
 * SUBMISSION_ID | HACKER_ID | CHALLENGE_ID | SCORE
 *     68628     |   77726   |     36566    |   30
 *     65300     |   77726   |     21089    |   10
 *     40326     |   52243   |     36566    |   77
 *      8941     |   27205   |      4810    |    4
 *     83554     |   77726   |     66730    |   30
 *     43353     |   52243   |     66730    |    0
 *     55385     |   52348   |     71055    |   20
 *     39784     |   27205   |     71055    |   23
 *     94613     |   86870   |     71055    |   30
 *     45788     |   52348   |     36566    |    0
 *     93058     |   86870   |     36566    |   30
 *      7344     |    8439   |     66730    |   92
 *      2721     |    8439   |      4810    |   36
 *       523     |    5580   |     71055    |    4
 *     49105     |   52348   |     66730    |    0
 *     55877     |   57645   |     66730    |   80
 *     38355     |   27205   |     66730    |   35
 *      3924     |    8439   |     36566    |   80
 *     97397     |   90411   |     66730    |  100
 *     84162     |   83082   |      4810    |   40
 *     97431     |   90411   |     71055    |   30
 *
 * Sample Output
 *
 * 90411 Joe
 *
 * Explanation
 *
 * Hacker 86870 got a score of 30 for challenge 71055 with a difficulty level of
 * 2, so 86870 earned a full score for this challenge.
 *
 * Hacker 90411 got a score of 30 for challenge 71055 with a difficulty level of
 * 2, so 90411 earned a full score for this challenge.
 *
 * Hacker 90411 got a score of 100 for challenge 66730 with a difficulty level
 * of 6, 90411 earned a full score for this challenge.
 *
 * Only hacker 90411 managed to earn a full score for more than one challenge,
 * so we print their HACKER_ID and NAME as 2 space-separated values.
 */

SELECT H.HACKER_ID, H.NAME
FROM SUBMISSIONS S
INNER JOIN CHALLENGES C
    ON S.CHALLENGE_ID = C.CHALLENGE_ID
INNER JOIN DIFFICULTY D
    ON D.DIFFICULTY_LEVEL = C.DIFFICULTY_LEVEL
INNER JOIN HACKERS H
    ON H.HACKER_ID = S.HACKER_ID
WHERE S.SCORE = D.SCORE
GROUP BY H.HACKER_ID, H.NAME HAVING COUNT(H.HACKER_ID) > 1
ORDER BY COUNT(H.HACKER_ID) DESC, H.HACKER_ID ASC;
