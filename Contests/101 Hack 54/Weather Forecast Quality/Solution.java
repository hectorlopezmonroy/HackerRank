/*
 * In a weather forecast, given the actual and forecasted temperatures for each
 * day of a week, find the sum of the weather forecast inaccuracies across all 7
 * days. The 'weather forecast inaccuracy' on any day is the absolute difference
 * of the actual temperature and the forecasted temperature.
 *
 * Complete the function 'totalForecastInaccuracy' which takes in two integer
 * arrays: 't', denoting actual temperatures, and 'f', denoting forecasted
 * temperatures, across 7 days and returns the sum of the weather forecast
 * inaccuracies across 7 days.
 *
 * Input Format
 *
 * The first line contains 7 space-separated integers t_1, t_2, ... , t_7.
 * The second line contains 7 space-separated integers f_1, f_2, ... , f_7.
 *
 * Constraints
 *
 * -100 <= t_i, f_i <= 100
 *
 * Output Format
 *
 * Print a single integer denoting the answer.
 *
 * Sample Input
 *
 * 14 13 12 13 16 18 21
 * 15 11 12 11 16 19 24
 *
 * Sample Output
 *
 * 9
 *
 * Explanation
 *
 * |14 - 15| + |13 - 11| + |12 - 12| + |13 - 11| + |16 - 16| + |18 - 19|
 * + |21 - 24| = 9.
 */

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    /** Return the sum of the weather forecast inaccuracies across all 7 days.
     */
    static int totalForecastInaccuracy(int[] t, int[] f) {
        int res = 0;

        for (int i = 0; i < t.length; i++) {
            res = res + Math.abs(t[i] - f[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = new int[7];

        String[] tItems = scanner.nextLine().split(" ");
        for (int tItr = 0; tItr < 7; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr]);
            t[tItr] = tItem;
        }

        int[] f = new int[7];
        String[] fItems = scanner.nextLine().split(" ");
        for (int fItr = 0; fItr < 7; fItr++) {
            int fItem = Integer.parseInt(fItems[fItr]);
            f[fItr] = fItem;
        }

        int result = totalForecastInaccuracy(t, f);
        System.out.println(result);
        scanner.close();
    }
}
