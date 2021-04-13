/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes not greater than given 'N'.
 *
 * Input Format
 *
 * The first line contains an integer 'T' i.e. number of the test cases.
 * The next 'T' lines contain an integer 'N'.
 *
 * Constraints
 *
 * 1 <= T <= 10^4
 * 1 <= N <= 10^6
 *
 * Output Format
 *
 * Print the value corresponding to each test case in a separate line.
 *
 * Sample Input
 *
 * 2
 * 5
 * 10
 *
 * Sample Output
 *
 * 10
 * 17
 *
 * Explanation
 *
 * For N = 5, we have primes as {2, 3, 5} and the sum is 10.
 * For N = 10, we have primes as {2, 3, 5, 7} and the sum is 17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /**
     *  Using the Sieve of Eratosthenes method.
     *  Reference: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    private static boolean[] primesGenerator(int n) {
        boolean[] res = new boolean[n + 1];
        Arrays.fill(res, Boolean.TRUE);

        res[0] = false; // Since 0 isn't prime.
        res[1] = false; // Since 1 isn't prime.

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (res[i] == true) {
                for (int j = 0; i*i + j*i <= n; j++) {
                    res[i*i + j*i] = false;
                }
            }
        }
        return res;
    }

    private static long[] summationOfPrimes(boolean[] primes) {
        long[] results = new long[primes.length];

        results[0] = 0; // Since 0 isn't prime.
        results[1] = 0; // Since 1 isn't prime.

        for (int i = 2; i < results.length; i++) {
            if (primes[i]) {
                results[i] = results[i - 1] + i;
            } else {
                results[i] = results[i - 1];
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        boolean[] primes = primesGenerator((int) Math.pow(10, 6));
        long[] results = summationOfPrimes(primes);

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            System.out.println(results[n]);
        }
    }
}
