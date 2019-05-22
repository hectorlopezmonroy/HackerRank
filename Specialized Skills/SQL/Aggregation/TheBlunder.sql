/*
 * Samantha was tasked with calculating the average monthly salaries for all
 * employees in the EMPLOYEES table, but did not realize her keyboard's '0' key
 * was broken until after completing the calculation. She wants your help
 * finding the difference between her miscalculation (using salaries with any
 * zeroes removed), and the actual average salary.
 *
 * Write a query calculating the amount of error (i.e.: 'actual' -
 * 'miscalculated' average monthly salaries), and round it up to the next
 * integer.
 *
 * Input Format
 *
 * The EMPLOYEES table is described as follows:
 *
 *                              Column    Type
 *                              ID     | INTEGER
 *                              NAME   | STRING
 *                              SALARY | INTEGER
 *
 * Note: Salary is measured in dollars per month and its value is < 10^5.
 *
 * Sample Input
 *
 * ID |   NAME   | SALARY
 *  1 | Kristeen |  1420
 *  2 | Ashley   |  2006
 *  3 | Julia    |  2210
 *  4 | Maria    |  3000
 *
 * Sample Output
 *
 * 2061
 *
 * Explanation
 *
 * The table below shows the salaries without zeroes as they were entered by
 * Samantha:
 *
 * ID |   NAME   | SALARY
 *  1 | Kristeen |  142
 *  2 | Ashley   |   26
 *  3 | Julia    |  221
 *  4 | Maria    |    3
 *
 * Samantha computes an average salary of 98.00. The actual average salary is
 * 2159.00.
 *
 * The resulting error between the two calculations is 2159.00 - 98.00 = 2061.00
 * which, when rounded to the next integer, is 2061.
 */

SELECT

	/* We round up to the next integer by using the ceiling function. */
	CEIL(

		 /* We calculate the difference between the correct salaries average
		  * and Samantha's miscalculated average.
		  */
		 AVG(SALARY) -

		 /* First we convert the salary (a number) to a string, then we replace
		  * zeroes on that string with an empty character '' simulating
		  * Samantha's error. Next, we convert that string back to a number.
		  * Finally, we calculate the average of those mistiped salaries.
		  */
	     AVG(TO_NUMBER(REGEXP_REPLACE(TO_CHAR(SALARY), '0', ''))))

FROM EMPLOYEES;
