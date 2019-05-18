/*
 * Write a query identifying the type of each record in the 'TRIANGLES' table
 * using its three side lengths. Output one of the following statements for each
 * record in the table:
 *
 *   * Equilateral: It's a triangle with 3 sides of equal length.
 *
 *   * Isosceles: It's a triangle with 2 sides of equal length.
 *
 *   * Scalene: It's a triangle with 3 sides of differing lengths.
 *
 *   * Not A Triangle: The given values of A, B, and C don't form a triangle.
 *
 * Input Format
 *
 * The 'TRIANGLES' table is described as follows:
 *
 * Column |  Type
 *    A   | Integer
 *    B   | Integer
 *    C   | Integer
 *
 * Each row in the table denotes the lengths of each of a triangle's three
 * sides.
 *
 * Sample Input
 *
 * A  | B  | C
 * 20 | 20 | 23
 * 20 | 20 | 20
 * 20 | 21 | 22
 * 13 | 14 | 30
 *
 * Sample Output
 *
 * Isosceles
 * Equilateral
 * Scalene
 * Not A Triangle
 *
 * Explanation
 *
 * Values in the tuple (20, 20, 23) form an Isosceles triangle, because A = B.
 * Values in the tuple (20, 20, 20) form an Equilateral triangle, because
 * A = B = C.
 * Values in the tuple (20, 21, 22) form a Scalene triangle, because
 * A != B != C.
 * Values in the tuple (13, 14, 30) cannot form a triangle because the combined
 * value of sides A and B is not larger than that of side C.
 */

/*
 * From Wikipedia's Triangle Inequality article:
 * "In mathematics, the triangle inequality states that for any triangle, the
 *  sum of the lengths of any two sides must be greater than or equal to the
 *  length of the remaining side."
 *
 * With the definition provided above; a triangle with area = 0, where the sum
 * of two of the sides is exactly equal than the remaining side, is considered a
 * valid triangle (in practice is a line). However, in order to make this
 * challenge's solution match the correct answer, we only consider the case when
 * the sum of two of the sides is stricly greater than the remaining side.
 */

SELECT
    CASE
        WHEN A + B > C AND A + C > B AND B + C > A THEN
            CASE
                WHEN A = B AND B = C THEN 'Equilateral'
                WHEN (A != B AND A != C AND B != C)  THEN 'Scalene'
                WHEN (A = B AND A != C) OR
                     (A = C AND A != B) OR
                     (B = C AND A != B) THEN 'Isosceles'
            END
        ELSE 'Not A Triangle'
    END
FROM TRIANGLES;
