/*
 * Query the list of CITY names from 'STATION' that either do not start or do
 * not end with vowels. Your result cannot contain duplicates.
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
 */

/*
 * This was a tricky one, because of the way the challenge is explained.
 * They key is that the requirement is specifically talking about an exclusive
 * or (XOR), meaning that the city can start with a vowel but not end with a
 * vowel. All other cities are part of the solution.
 */

SELECT DISTINCT CITY
FROM STATION
WHERE REGEXP_LIKE (city, '(^[^aeiou])|([^aeiou]$)', 'in');
