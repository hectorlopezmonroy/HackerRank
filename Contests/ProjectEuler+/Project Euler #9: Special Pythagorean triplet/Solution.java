/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 *                            a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2
 *
 * Given 'N', check if there exists any Pythagorean triplet for which a + b + c = N
 *
 * Find maximum possible value of a * b * c among all such Pythagorean triplets.
 * If there is no such Pythagorean triplet print -1.
 *
 * Input Format
 *
 * The first line contains an integer 'T' i.e. number of test cases.
 * The next 'T' lines will contain an integer 'N'.
 *
 * Constraints
 *
 * 1 <= T <= 3000
 * 1 <= N <= 3000
 *
 * Output Format
 *
 * Print the value corresponding to each test case in separate lines.
 *
 * Sample Input
 *
 * 2
 * 12
 * 4
 *
 * Sample Output
 *
 * 60
 * -1
 *
 * Explanation
 *
 * For N = 12, we have a triplet {3, 4, 5}, whose product is 60.
 * For N = 4, we don't have any pythagorean triplet.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int solution(int n) {
        int max = -1;

        /**
         * Solving the following equations:
         *
         * Equation 1: a^2 + b^2 = c^c
         * Equation 2: a + b + c = n
         * Equation 3: (a + b + c)^2 = a^2 + ab + ac + ab + b^2 + bc + ac + bc + c^2
         *
         * Plugging Eq. 2 into Eq 3. we get:
         *
         *             n^2 = a^2 + b^2 + c^2 + 2ab + 2ac + 2bc
         *
         * Plugging Eq. 1 into the equation above:
         *
         *             n^2 = 2c^2 + 2(ab + ac + bc)
         *
         *    Finally, n^2 = 2 * (c^2 + ab + ac + bc)
         *
         *  This means n must be a multiple of n for all conditions to hold!
         */
        if (n % 2 != 0) {
            return max;
        }

        /**
         * If we sum the following two equations:
         *                                         a < b
         *                                         a < c
         *
         *                               We have: 2a < b + c
         *                 Adding a to each side: 3a < a + b + c
         *                   Using a + b + c = n:  a < n / 3
         */
        for (int a = 1; a < (n / 3); a++) {
            /**
             * Using the following equations:
             *
             * Equation 1: a + b + c = n
             * Equation 2: a^2 + b^2 = c^2 -> c = sqrt(a^2 + b^2)
             *
             * Plugging Eq. 2 into Eq. 1:
             *
             *   a + b + sqrt(a^2 + b^2) = n
             *   sqrt(a^2 + b^2) = (n - a - b)
             *   sqrt(a^2 + b^2)^2 = (n - a - b)^2
             *   a^2 + b^2 = n^2 - an - bn - an + a^2 + ab - bn + ab + b^2
             *   0 = n^2 + 2ab - 2an - 2bn
             *   n^2 = 2bn - 2ab + 2an
             *   n^2 = b(2n - 2a) + 2an
             *   n^2 - 2an = b(2 * (n - a))
             *   b = (n^2 - 2an) / (2 * (n - a))
             */
            double b = ((n * n) - (2 * a * n)) / (2 * (n - a));

            if (b % 1 == 0.0) {
                int c = n - a - (int) b;

                if ((a < b && b < c) && (a*a + b*b == c*c) && (a + b + c == n)) {
                    int product = a * (int) b * c;

                    if (max < product) {
                        max = product;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();

        for (int i = 0; i < t; i++){
            int n = in.nextInt();

            if (results.containsKey(n)) {
                System.out.println(results.get(n));
            } else {
                results.put(n, solution(n));
                System.out.println(results.get(n));
            }
        }
    }
}
