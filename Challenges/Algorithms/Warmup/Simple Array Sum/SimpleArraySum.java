/*
 * Given an array of N integers, can you find the sum of its elements?
 *
 * Input Format
 *
 * The first line contains an integer, N, denoting the size of the array.
 * The second line contains N space-separated integers representing the array's
 * elements.
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
            res = res + ar[i];
        }
        return res;
    }

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
        in.close();
    }
}
