/*
 * Objective
 * Today we're learning about running time! Check out the Tutorial tab for
 * learning materials and an instructional video!
 *
 * Task
 * A 'prime' is a natural number greater than 1 that has no positive divisors
 * other than 1 and itself. Given a number, 'n', determine and print whether
 * it's "Prime" or "Not prime".
 *
 * Note: If possible, try to come up with a O(n^(1/2)) primality algorithm, or
 * see what sort of optimizations you come up with for an O(n) algorithm. Be
 * sure to check out the Editorial after submitting your code!
 *
 * Input Format
 *
 * The first line contains an integer, 'T', the number of test cases.
 * Each of the 'T' subsequent lines contains an integer, 'n', to be tested for
 * primality.
 *
 * Constraints
 *
 * 1 <= T <= 30
 *
 * 1 <= n <= 2 * 10^9
 *
 * Output Format
 *
 * For each test case, print whether 'n' is "Prime" or "Not prime" on a new
 * line.
 *
 * Sample Input
 *
 * 3
 * 12
 * 5
 * 7
 *
 * Sample Output
 *
 * Not prime
 * Prime
 * Prime
 *
 * Explanation
 *
 * Test Case 0: n = 12.
 * 12 is divisible by numbers other than 1 and itself (i.e.: 2, 3, 6), so we
 * print "Not prime" on a new line.
 *
 * Test Case 1: n = 5.
 * 5 is only divisible by 1 and itself, so we print "Prime" on a new line.
 *
 * Test Case 2: n = 7.
 * 7 is only divisible by 1 and itself, so we print "Prime" on a new line.
 */

import java.util.Scanner;

public class RunningTimeAndComplexity {

    public static String primalityTest(int n) {
        boolean isPrime = true;

        if (n == 2) {
            ;
        } else if ((n <= 1) || (2 < n && n % 2 == 0)) {
            // If n is a negative integer, zero, one, or an even integer greater
            // than two, then it isn't prime.
            isPrime = false;
        } else {
            for (int i = 3; i < Math.sqrt(n); i += 2) {
                // We only need to check the possible odd divisors of n up to
                // square root of n (n^(1/2)).
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime ? "Prime" : "Not prime";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] results = new String[T];

        // Process input
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            results[i] = primalityTest(n);
        }
        in.close();

        // Prints output
        for (String s : results) {
            System.out.println(s);
        }
    }
}
