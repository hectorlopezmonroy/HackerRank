/*
 * Given an array of integers, find the sum of its elements.
 *
 * For example, if the array ar = [1, 2, 3], 1 + 2 + 3 = 6, so return 6.
 *
 * Function Description
 *
 * Complete the 'simpleArraySum' function in the editor below. It must return
 * the sum of the array elements as an integer.
 *
 * 'simpleArraySum' has the following parameter(s):
 *
 *   * ar: an array of integers.
 *
 * Input Format
 *
 * The first line contains an integer, 'n', denoting the size of the array.
 *
 * The second line contains 'n' space-separated integers representing the
 * array's elements.
 *
 * Constraints
 *
 * 0 <= n, ar[i] <= 1000
 *
 * Output Format
 *
 * Print the sum of the array's elements as a single integer.
 *
 * Sample Input
 *
 * 6
 * 1 2 3 4 10 11
 *
 * Sample Output
 *
 * 31
 *
 * Explanation
 *
 * We print the sum of the array's elements, which is:
 * 1 + 2 + 3 + 4 + 10 + 11 = 31.
 */

import java.util.Scanner;

class SimpleArraySum {

    public static int simpleArraySum(int n, int[] ar) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += ar[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int sum = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];

        // Process input
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        in.close();

        sum = simpleArraySum(n, ar);

        // Prints output
        System.out.println(sum);
    }
}
