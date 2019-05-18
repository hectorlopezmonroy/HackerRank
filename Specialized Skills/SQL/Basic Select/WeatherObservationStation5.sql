/*
 * Query the two cities in 'STATION' with the shortest and longest CITY names,
 * as well as their respective lengths (i.e.: number of characters in the name).
 * If there is more than one smallest or largest city, choose the one that comes
 * first when ordered alphabetically.
 *
 * Input Format
 *
 * The 'STATION' table is described as follows:
 *
 *          STATION
 * Field       | Type
 * ID          | NUMBER
 * CITY        | VARCHAR2(21)
 * STATE       | VARCHAR2(2)
 * LAT_N       | NUMBER
 * LONG_W      | NUMBER
 *
 * where LAT_N is the northern latitude and LONG_W is the western longitude.
 *
 * Sample Input
 *
 * Let's say that CITY only has four entries: DEF, ABC, PQRS and WXY.
 *
 * Sample Output
 *
 * ABC 3
 * PQRS 4
 *
 * Explanation
 *
 * When ordered alphabetically, the CITY names are listed as ABC, DEF, PQRS and
 * WXY, with the respective lengths 3, 3, 4 and 3. The longest-named city is
 * obviously PQRS, but there are 3 options for shortest-named city; we choose
 * ABC, because it comes first alphabetically.
 *
 * Note: You can write two separate queries to get the desired output.
 *       It need not be a single query.
 */

/*
 * The approach for this query is:
 *   1.- We get what's the minimum CITY name length
 *       (or maximum for the second query).
 *   2.- The intermediate query provides the CITY names (without repetitions)
 *       for those cities with the smallest length (or largest length for the
 *       second query), ordered alphabetically.
 *   3.- The outer query gets the first CITY from the previous step, completing
 *       the requirements for this challenge.
 */

SELECT *
FROM
    (SELECT DISTINCT CITY, LENGTH(CITY)
     FROM STATION
     WHERE (LENGTH(CITY) = (SELECT MIN(LENGTH(CITY)) FROM STATION))
     ORDER BY CITY)
WHERE ROWNUM <= 1;

SELECT *
FROM
    (SELECT DISTINCT CITY, LENGTH(CITY)
     FROM STATION
     WHERE (LENGTH(CITY) = (SELECT MAX(LENGTH(CITY)) FROM STATION))
     ORDER BY CITY)
WHERE ROWNUM <= 1;
