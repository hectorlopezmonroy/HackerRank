/*
 * Complete the function 'solveMeFirst' to compute the sum of two integers.
 *
 * Function prototype:
 *
 *   int solveMeFirst(int a, int b);
 *
 * where,
 *
 *   * 'a' is the first integer input.
 *
 *   * 'b' is the seconf integer input.
 *
 * Return values
 *
 *   * sum of the above two integers
 *
 * Sample Input
 *
 * a = 2
 * b = 3
 *
 * Sample Output
 *
 * 5
 *
 * Explanation
 *
 * The sum of the two integers 'a' and 'b' is computed as: 2 + 3 = 5.
 */

import java.util.Scanner;

class SolveMeFirst {

    static int solveMeFirst(int a, int b) {
        int res = 0;

        res = a + b;
        return res;
    }

    public static void main(String[] args) {
        int sum = 0;
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}
