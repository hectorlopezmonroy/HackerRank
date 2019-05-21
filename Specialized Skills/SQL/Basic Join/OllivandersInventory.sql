/*
 * Harry Potter and his friends are at Ollivander's with Ron, finally replacing
 * Charlie's old broken wand.
 *
 * Hermione decides the best way to choose is by determining the minimum number
 * of gold galleons needed to buy each non-evil wand of high power and age.
 * Write a query to print the ID, AGE, COINS_NEEDED, and POWER of the wands that
 * Ron's interested in, sorted in order of descending POWER. If more than one
 * wand has same POWER, sort the result in order of descending AGE.
 *
 * Input Format
 *
 * The following tables contain data on the wands in Ollivander's inventory:
 *
 *   * WANDS: The ID is the id of the wand, CODE is the code of the wand,
 *            COINS_NEEDED is the total number of gold galleons needed to buy
 *            the wand, and POWER denotes the quality of the wand (the higher
 *            the power, the better the wand is).
 *
 *                              Column   |  Type
 *                          ID           | INTEGER
 *                          CODE         | INTEGER
 *                          COINS_NEEDED | INTEGER
 *                          POWER        | INTEGER
 *
 *   * WANDS_PROPERTY: The CODE is the code of the wand, AGE is the age of the
 *                     wand, and IS_EVIL denotes whether the wand is good for
 *                     the dark arts. If the value of IS_EVIL is 0, it means
 *                     that the wand is not evil. The mapping between CODE and
 *                     AGE is one-to-one, meaning that if there are two pairs
 *                     (code1, age1) and (code2, age2) then code1 != code2 and
 *                     age1 != age2.
 *
 *                                Column |  Type
 *                               CODE    | INTEGER
 *                               AGE     | INTEGER
 *                               IS_EVIL | INTEGER
 *
 * Sample Input
 *
 * WANDS Table:
 *
 *                      ID | CODE | COINS_NEEDED | POWER
 *                       1 |   4  |     3688     |   8
 *                       2 |   3  |     9365     |   3
 *                       3 |   3  |     7187     |  10
 *                       4 |   3  |      734     |   8
 *                       5 |   1  |     6020     |   2
 *                       6 |   2  |     6773     |   7
 *                       7 |   3  |     9873     |   9
 *                       8 |   3  |     7721     |   7
 *                       9 |   1  |     1647     |  10
 *                      10 |   4  |      504     |   5
 *                      11 |   2  |     7587     |   5
 *                      12 |   5  |     9897     |  10
 *                      13 |   3  |     4651     |   8
 *                      14 |   2  |     5408     |   1
 *                      15 |   2  |     6018     |   7
 *                      16 |   4  |     7710     |   5
 *                      17 |   2  |     8798     |   7
 *                      18 |   2  |     3312     |   3
 *                      19 |   4  |     7651     |   6
 *                      20 |   5  |     5689     |   3
 *
 * WANDS_PROPERTY Table:
 *
 *                           CODE | AGE | IS_EVIL
 *                             1  |  45 |    0
 *                             2  |  40 |    0
 *                             3  |   4 |    1
 *                             4  |  20 |    0
 *                             5  |  17 |    0
 *
 * Sample Output
 *
 *  9 45 1647 10
 * 12 17 9897 10
 *  1 20 3688  8
 * 15 40 6018  7
 * 19 20 7651  6
 * 11 40 7587  5
 * 10 20  504  5
 * 18 40 3312  3
 * 20 17 5689  3
 *  5 45 6020  2
 * 14 40 5408  1
 *
 * Explanation
 *
 * ID | AGE | COINS_NEEDED | POWER
 * 5  |  45 |     6020     |   2
 * 9  |  45 |     1647     |  10
 *
 * The data for wands of age 45 (code 1):
 *
 *   * The minimum number of galleons needed for wand(age = 45, power = 2) = 6020
 *
 *   * The minimum number of galleons needed for wand(age = 45, power = 10) = 1647
 *
 * ID | AGE | COINS_NEEDED | POWER
 * 14 |  40 |     5408     |   1
 * 18 |  40 |     3312     |   3
 * 11 |  40 |     7587     |   5
 * 15 |  40 |     6018     |   7
 * 17 |  40 |     8798     |   7
 *  6 |  40 |     6773     |   7
 *
 * The data for wands of age 40 (code 2):
 *
 *   * The minimum number of galleons needed for wand(age = 40, power = 1) = 5408
 *
 *   * The minimum number of galleons needed for wand(age = 40, power = 3) = 3312
 *
 *   * The minimum number of galleons needed for wand(age = 40, power = 5) = 7587
 *
 *   * The minimum number of galleons needed for wand(age = 40, power = 7) = 6018
 *
 * ID | AGE | COINS_NEEDED | POWER
 * 10 |  20 |      504     |   5
 * 16 |  20 |     7710     |   5
 * 19 |  20 |     7651     |   6
 *  1 |  20 |     3688     |   8
 *
 * The data for wands of age 20 (code 4):
 *
 *   * The minimum number of galleons needed for wand(age = 20, power = 5) =  504
 *
 *   * The minimum number of galleons needed for wand(age = 20, power = 6) = 7651
 *
 *   * The minimum number of galleons needed for wand(age = 20, power = 8) = 3688
 *
 * ID | AGE | COINS_NEEDED | POWER
 * 20 |  17 |     5689     |   3
 * 12 |  17 |     9897     |  10
 *
 * The data for wands of age 17 (code 5):
 *
 *   * The minimum number of galleons needed for wand(age = 17, power = 3) = 5689
 *
 *   * The minimum number of galleons needed for wand(age = 17, power = 10) = 9897
 */

SELECT CASE
          WHEN COUNT THEN W2.ID, WP2.AGE, W2.COINS_NEEDED, W2.POWER
          ELSE ''
       END
FROM WANDS W2 INNER JOIN WANDS_PROPERTY WP2
    ON W2.CODE = WP2.CODE
WHERE WP2.IS_EVIL = 0 AND W2.COINS_NEEDED = (SELECT MIN(W1.COINS_NEEDED)
                                             FROM WANDS W1 INNER JOIN WANDS_PROPERTY WP1
                                                ON W1.CODE = WP1.CODE
                                             WHERE WP1.AGE = WP2.AGE AND W1.POWER = W2.POWER)
ORDER BY W2.POWER DESC, WP2.AGE DESC;
