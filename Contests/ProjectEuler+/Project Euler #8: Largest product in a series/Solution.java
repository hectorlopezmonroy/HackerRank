/*
 * Find the greatest product of 'K' consecutive digits in the 'N' digit number.
 *
 * Input Format
 *
 * First line contains 'T' that denotes the number of test cases.
 * First line of each test case will contain two integers 'N' & 'K'.
 * Second line of each test case will contain a 'N' digit integer.
 *
 * Constraints
 *
 * 1 <= T <= 100
 * 1 <= K <= 7
 * K <= N <= 1000
 *
 * Output Format
 *
 * Print the required answer for each test case.
 *
 * Sample Input
 *
 * 2
 * 10 5
 * 3675356291
 * 10 5
 * 2709360626
 *
 * Sample Output
 *
 * 3150
 * 0
 *
 * Explanation
 *
 * For 3675356291 and selecting K = 5 consecutive digits, we have 36753, 67535,
 * 75356, 53562, 35629 and 56291. Where 6 * 7 * 5 * 3 * 5 gives maximum product
 * as 3150.
 *
 * For 2709360626, 0 lies in all selection of 5 consecutive digits hence maximum
 * product remains 0.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long productInSeries(String s) {
        long res = 1;

        for (int i = 0; i < s.length(); i++) {
            res = res * Integer.parseInt(s.substring(i, i + 1));
        }
        return res;
    }

    public static long largestProductInSeries(int n, int k, String num) {
        long res = 0;
        int number_of_series = n - k;

        for (int i = 0; i <= number_of_series; i++) {
            String series = num.substring(i, i + k);
            long current_product = productInSeries(series);

            if (res < current_product) {
                res = current_product;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();

            System.out.println(largestProductInSeries(n, k, num));
        }
    }
}
