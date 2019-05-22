/*
 * Query a count of the number of cities in CITY having a POPULATION larger than
 * 100,000.
 *
 * Input Format
 *
 * The CITY table is described as follows:
 *
 *                                   CITY
 *                             Field   |     Type
 *                         ID          | NUMBER
 *                         NAME        | VARCHAR2(17)
 *                         COUNTRYCODE | VARCHAR2(3)
 *                         DISTRICT    | VARCHAR2(20)
 *                         POPULATION  | NUMBER
 */

SELECT COUNT(ID) FROM CITY WHERE POPULATION > 100000;
