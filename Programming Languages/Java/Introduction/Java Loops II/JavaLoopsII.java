/*
 * We use the integers a, b, and n to create the following series:
 * (a + 2^0 * b), (a + 2^0 * b + 2^1 * b), ..., (a + 2^0 * b + ... + 2^(n - 1) * b)
 *
 * You are given q queries in the form of a, b, and n. For each query, print the
 * series corresponding to the given a, b, and n values as a single line of n
 * space-separated integers.
 *
 * Input Format
 *
 * The first line contains an integer, q_1 denoting the number of queries.
 * Each line i of the subsequent lines contains three space-separated integers
 * describing the respective a_i, b_i and n_i values for that query.
 *
 * Constraints
 *
 * 0 <= q <= 500
 *
 * 0 <= a, b, <= 50
 *
 * 1 <= n <= 15
 *
 * Output Format
 *
 * For each query, print the corresponding series on a new line. Each series
 * must be printed in order as a single line of n space-separated integers.
 *
 * Sample Input
 *
 * 2
 * 0 2 10
 * 5 3 5
 *
 * Sample Output
 *
 * 2 6 14 30 62 126 254 510 1022 2046
 * 8 14 26 50 98
 *
 * Explanation
 *
 * We have two queries:
 *
 * 1. We use a = 0, b = 2, and n = 10 to produce some series
 *    s_0, s_1, ... , s_(n - 1):
 *
 *    s_0 = 0 + 1 * 2 = 2
 *
 *    s_1 = 0 + 1 * 2 + 2 * 2 = 6
 *
 *    s_2 = 0 + 1 * 2 + 2 * 2 + 4 * 2 = 14
 *
 *    ... and so on.
 *
 *    Once we hit n = 10, we print the first ten terms as a single line of
 *    space-separated integers.
 *
 * 2. We use a = 5, b = 3, and n = 5 to produce some series
 *    s_0, s_1, ..., s_(n - 1):
 *
 *    s_0 = 5 + 1 * 3 = 8
 *
 *    s_1 = 5 + 1 * 3 + 2 * 3 = 14
 *
 *    s_2 = 5 + 1 * 3 + 2 * 3 + 4 * 3 = 26
 *
 *    s_3 = 5 + 1 * 3 + 2 * 3 + 4 * 3 + 8 * 3 = 50
 *
 *    s_4 = 5 + 1 * 3 + 2 * 3 + 4 * 3 + 8 * 3 + 16 * 3 = 98
 *
 * We then print each element of our series as a single line of space-separated
 * values.
 */

import java.util.Scanner;

public class JavaLoopsII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numQueries = in.nextInt();
        int[][] intArr = new int[numQueries][3];

        for (int i = 0; i < numQueries; i++) {
            intArr[i][0] = in.nextInt();
            intArr[i][1] = in.nextInt();
            intArr[i][2] = in.nextInt();
        }
        in.close();
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i][2]; j++) {
                double tmp = intArr[i][0];
                for (int k = 0; k <= j; k++) {
                    tmp = tmp + (Math.pow(2, k) * intArr[i][1]);
                }
                System.out.print((int) tmp);
                if (j < intArr[i][2] - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
