/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 'N'.
 *
 * Input Format
 *
 * First line contains 'T' that denotes the number of test cases. This is
 * followed by 'T' lines, each containing an integer, 'N'.
 *
 * Constraints
 *
 * 1 <= T <= 10^5
 * 1 <= N <= 10^9
 *
 * Output Format
 *
 * For each test case, print an integer that denotes the sum of all the
 * multiples of 3 or 5 below 'N'.
 *
 * Sample Input
 *
 * 2
 * 10
 * 100
 *
 * Sample Output
 *
 * 23
 * 2318
 *
 * Explanation
 *
 * For N = 10, if we list all the natural numbers below 10 that are multiples of
 * 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Similarly for N = 100, we get 2318.
 */

import java.util.Scanner;

public class MultiplesOf3And5 {

    public static long computeSumMultiplesOf(int n, int num) {
        long res = 0;
        int countMultiplesOfNum = (n - 1) / num;

        if (countMultiplesOfNum % 2 == 0) {
            // Using right-shift bitwise operation instead of division by two
            res = countMultiplesOfNum >> 1;
            try {
                res = Math.multiplyExact(res, (countMultiplesOfNum + 1));
                res = Math.multiplyExact(res, num);
            } catch (ArithmeticException e) {
                System.out.println("  Error: Overflow ocurred 1st if.");
            }
        } else {
            res = (countMultiplesOfNum + 1) >> 1;
            try {
                res = Math.multiplyExact(res, countMultiplesOfNum);
                res = Math.multiplyExact(res, num);
            } catch (ArithmeticException e) {
                System.out.println("  Error: Overflow ocurred 1st else.");
            }
        }
        return res;
    }

    public static long computeMultiplesSum(int n) {
        long res = 0;

        res = computeSumMultiplesOf(n, 3);
        res = res - computeSumMultiplesOf(n, 15);
        res = res + computeSumMultiplesOf(n, 5);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] res = new long[t];

        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            res[a0] = computeMultiplesSum(n);
        }
        in.close();
        for (long d : res) {
            System.out.println(d);
        }
    }
}
