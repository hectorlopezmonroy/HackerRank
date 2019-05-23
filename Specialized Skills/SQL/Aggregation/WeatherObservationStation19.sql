/*
 * Consider P1(a, c) and P2(b, d) to be two points on a 2D plane where (a, b)
 * are the respective minimum and maximum values of Northern Latitude (LAT_N)
 * and (c, d) are the respective minimum and maximum values of Western Longitude
 * (LONG_W) in 'STATION'.
 *
 * Query the Euclidean Distance between points P1 and P2 and format your answer
 * to display 4 decimal places.
 *
 * Input Format
 *
 * The 'STATION' table is described as follows:
 *
 *                                  STATION
 *                               Field |    Type
 *                              ID     | NUMBER
 *                              CITY   | VARCHAR2(21)
 *                              STATE  | VARCHAR2(2)
 *                              LAT_N  | NUMBER
 *                              LONG_W | NUMBER
 *
 * where LAT_N is the northern latitude and LONG_W is the western longitude.
 */

/* Definition of Euclidean Distance:
 * In the Euclidean plane (two dimensions), if P1 = (a, c) and P2 = (b, d) then
 * the distance is given by d(P1, P2) = sqr((b - a)^2 + (d - c)^2)
 */

SELECT ROUND(
             SQRT(POWER(MAX(LAT_N) - MIN(LAT_N), 2) +
                  POWER(MAX(LONG_W) - MIN(LONG_W), 2)), 4)
FROM STATION;
