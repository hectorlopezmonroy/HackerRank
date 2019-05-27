/*
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 *
 * For example, 'arr = [1, 3, 5, 7, 9]'. Our minimum sum is '1 + 3 + 5 + 7 = 16'
 * and our maximum sum is '3 + 5 + 7 + 9 = 24'.
 *
 * Function Description
 *
 * Complete the 'miniMaxSum' function in the editor below. It should print two
 * space-separated integers on one line: the minimum sum and the maximum sum of
 * '4' of '5' elements.
 *
 * 'miniMaxSum' has the following parameter(s):
 *
 *   * 'arr': and array of 5 integers.
 *
 * Input Format
 *
 * A single line of five space-separated integers.
 *
 * Constraints
 *
 * 1 <= arr[i] <= 10^9
 *
 * Output Format
 *
 * Print two space-separated long integers denoting the respective minimum and
 * maximum values that can be calculated by summing exactly four of the five
 * integers. (The output can be greater than a 32 bit integer).
 *
 * Sample Input
 *
 * 1 2 3 4 5
 *
 * Sample Output
 *
 * 10 14
 *
 * Explanation
 *
 * Our initial numbers are 1, 2, 3, 4, and 5. We can calculate the following
 * sums using four of the five integers:
 *
 * 1. If we sum everything except 1, our sum is 2 + 3 + 4 + 5 = 14.
 *
 * 2. If we sum everything except 2, our sum is 1 + 3 + 4 + 5 = 13.
 *
 * 3. If we sum everything except 3, our sum is 1 + 2 + 4 + 5 = 12.
 *
 * 4. If we sum everything except 4, our sum is 1 + 2 + 3 + 5 = 11.
 *
 * 5. If we sum everything except 5, our sum is 1 + 2 + 3 + 4 = 10.
 *
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 */

import java.util.Scanner;

public class MiniMaxSum {

    static void miniMaxSum(long[] arr) {
        long sum = arr[0];
        long minElement = arr[0];
        long maxElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long temp = arr[i];
            try {
                sum = Math.addExact(sum, temp);
                if (temp < minElement) {
                    minElement = temp;
                } else if (temp > maxElement) {
                    maxElement = temp;
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: Integer sum overflow.");
            }
        }

        // Prints output
        System.out.println((sum - maxElement) + " " + (sum - minElement));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        long[] arr = new long[n];

        // Process input
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        miniMaxSum(arr);
    }
}
