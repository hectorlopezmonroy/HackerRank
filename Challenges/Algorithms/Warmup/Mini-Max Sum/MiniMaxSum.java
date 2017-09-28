/*
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 *
 * Input Format
 *
 * A single line of five space-separated integers.
 *
 * Constraints
 *
 * Each integer is in the inclusive range [1, 10^9].
 *
 * Output Format
 *
 * Print two space-separated long integers denoting the respective minimum and
 * maximum values that can be calculated by summing exactly four of the five
 * integers. (The output can be grater than 32 bit integers).
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
 * As you can see, the minimal sum is 1 + 2 + 3 + 4 = 10 and the maximal sum is
 * 2 + 3 + 4 + 5 = 14. Thus, we print these minimal and maximal sums as two
 * space-separated integers on a new line.
 *
 * Hints: Beware of integer overflow! Use 64-bit integers.
 */

import java.util.Scanner;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long temp = in.nextLong();
        long minElement = temp;
        long maxElement = temp;
        long sum = temp;

        for (int i = 0; i < 4; i++) {
            temp = in.nextLong();
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
        in.close();
        System.out.println((sum - maxElement) + " " + (sum - minElement));
    }
}
