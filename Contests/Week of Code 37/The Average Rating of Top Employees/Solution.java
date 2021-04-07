/*
 * The general manager of Byteland Company has decided to rate all of the
 * employees for their performance during this year. The rating will be a score
 * in the range of 90 - 100 (inclusive) points. The manager wants to compute the
 * average rating of all employees whose rating is greater or equal to 90 since
 * he wants to give them a bonus for their good performance.
 *
 * Complete the function 'averageOfTopEmployees' which takes in an integer array
 * 'rating' denoting the ratings of the employees and prints the average rating
 * of employees who will get a bonus, with exactly 2 digits after the decimal
 * point, 'rounded half up'. (For example, 95.345 should be rounded to 95.35,
 * while 95.344 should be rounded to 95.34).
 *
 * Input Format
 *
 * The first line contains a single integer 'n' denoting the number of employees
 * in the Byteland Company. Then, 'n' lines follow. The i-th of them contains a
 * single integer 'rating_i', denoting the rating of the i-th employee.
 *
 * Constraints
 *
 * 5 <= n <= 200
 * 0 <= rating_i <= 100
 *
 * It's guaranteed that there is at least one employee with a rating >= 90.
 *
 * Output Format
 *
 * Print a single line containing a real number denoting the average rating of
 * employees who will get a bonus. This number has to have 'exactly' 2 digits
 * after the decimal point, 'rounded half up'. (For example, 95.345 should be
 * rounded to 95.35, while 95.344 should be rounded to 95.34).
 *
 * Sample Input
 *
 * 5
 * 84
 * 92
 * 61
 * 50
 * 95
 *
 * Sample Output
 *
 * 93.50
 *
 * Explanation
 *
 * There are only two employees whose rating is equal or greater to 90. They are
 * the only ones who are getting a bonus. Computing the average, we get:
 *
 * (92 + 95) / 2 = 93.50
 */

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static void averageOfTopEmployees(int[] rating) {
        int acum = 0;
        double empN = 0.0;

        for (int i = 0; i < rating.length; i++) {
            if (rating[i] >= 90) {
                acum = acum + rating[i];
                empN++;
            }
        }
        System.out.printf("%.2f\n", acum/empN);
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] rating = new int[n];

        for (int i = 0; i < n; i++) {
            int ratingItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            rating[i] = ratingItem;
        }

        averageOfTopEmployees(rating);

        scanner.close();
    }
}
