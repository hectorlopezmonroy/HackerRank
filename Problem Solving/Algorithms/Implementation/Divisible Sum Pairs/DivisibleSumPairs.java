/*
 * You are given an array of 'n' integers,
 * 'ar = [ar[0], ar[1], ... , ar[n - 1]]', and a positive integer, 'k'. Find and
 * print the number of '(i, j)' pairs where 'i < j' and 'ar[i]' + 'ar[j]' is
 * divisible by 'k'.
 *
 * Function Description
 *
 * Complete the 'divisibleSumPairs' function in the editor below. It should
 * return the integer count of pairs meeting the criteria.
 *
 * 'divisibleSumPairs' has the following parameter(s):
 *
 *   * 'n': the integer length of array 'ar'.
 *
 *   * 'ar': an array of integers.
 *
 *   * 'k': the integer to divide the pair sum by.
 *
 * Input Format
 *
 * The first line contains '2' space-separated integers, 'n' and 'k'.
 *
 * The second line contains 'n' space-separated integers describing the values
 * of 'ar[ar[0], ar[1], ... , ar[n - 1]]'.
 *
 * Constraints
 *
 * 2 <= n <= 100
 *
 * 1 <= k <= 100
 *
 * 1 <= ar[i] <= 100
 *
 * Output Format
 *
 * Print the number of '(i, j)' pairs where 'i < j' and 'a[i]' + 'a[j]' is
 * evenly divisible by 'k'.
 *
 * Sample Input
 *
 * 6 3
 * 1 3 2 6 1 2
 *
 * Sample Output
 *
 * 5
 *
 * Explanation
 *
 * Here are the '5' valid pairs when 'k = 3':
 *
 *   * (0, 2) -> ar[0] + ar[2] = 1 + 2 = 3
 *   * (0, 5) -> ar[0] + ar[5] = 1 + 2 = 3
 *   * (1, 3) -> ar[1] + ar[3] = 3 + 6 = 9
 *   * (2, 4) -> ar[2] + ar[4] = 2 + 1 = 3
 *   * (4, 5) -> ar[4] + ar[5] = 1 + 2 = 3
 */

import java.util.HashMap;
import java.util.Scanner;

public class DivisibleSumPairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + a[j]) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        int result = 0;

        // Process input
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();

        result = divisibleSumPairs(n, k, ar);

        // Prints output
        System.out.println(result);
    }
}
