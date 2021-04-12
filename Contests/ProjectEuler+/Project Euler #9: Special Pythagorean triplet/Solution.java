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

        for (int c = n - 1; 2 < c; c--) {
            for (int b = c - 1; 1 < b; b--) {
                double a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));

                if ((a < b && b < c) && (a % 1 == 0.0) && ((int) a + b + c == n)) {
                    int product = (int) a * b * c;

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
