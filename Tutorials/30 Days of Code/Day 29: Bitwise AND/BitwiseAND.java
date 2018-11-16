/*
 * Objective
 * Welcome to the last day! Today, we're discussing bitwise operations. Check
 * out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given set S = {1, 2, 3, ... , N}. Find two integers, 'A' and 'B' (where
 * A < B), from set 'S' such that the value of A&B is the maximum possible 'and
 * also less than a given integer, K'. In this case, & represents the 'bitwise
 * AND' operator.
 *
 * Input Format
 *
 * The first line contains an integer, 'T', the number of test cases.
 * Each of the 'T' subsequent lines defines a test case as 2 space-separated
 * integers, 'N' and 'K', respectively.
 *
 * Constraints
 *
 * 1 <= T <= 10^3
 *
 * 2 <= N <= 10^3
 *
 * 2 <= K <= N
 *
 * Output Format
 *
 * For each test case, print the maximum possible value of A&B on a new line.
 *
 * Sample Input
 *
 * 3
 * 5 2
 * 8 5
 * 2 2
 *
 * Sample Output
 *
 * 1
 * 4
 * 0
 *
 * Explanation
 *
 * N = 5, K = 2, S = {1, 2, 3, 4, 5}
 *
 * All possible values of 'A' and 'B' are:
 *
 *   1. A = 1, B = 2; A & B = 0
 *
 *   2. A = 1, B = 3; A & B = 1
 *
 *   3. A = 1, B = 4; A & B = 0
 *
 *   4. A = 1, B = 5; A & B = 1
 *
 *   5. A = 2, B = 3; A & B = 2
 *
 *   6. A = 2, B = 4; A & B = 0
 *
 *   7. A = 2, B = 5; A & B = 0
 *
 *   8. A = 3, B = 4; A & B = 0
 *
 *   9. A = 3, B = 5; A & B = 1
 *
 *  10. A = 4, B = 5; A & B = 4
 *
 * The maximum possible value of A&B that is also < (K = 2) is 1, so we print 1
 * on a new line.
 */

import java.util.Scanner;

public class BitwiseAND {

    public static int findCustomMax(int N, int K) {
        int max = 0;

        for (int i = 1; i < N && (max < K - 1); i++) {
            // We iterate through the set of positive integers [1, 2, ... , N)
            // until all possible combinations have been tried OR until we find
            // the A&B such that A&B = K - 1 (maximum possible allowed).
            for (int j = i + 1; j <= N; j++) {
                // This nested loop iterates through the set of positive
                // integers [i + 1, N]
                int tmp = i & j;        // tmp stores this A&B value

                if (max < tmp && tmp < K) {
                    // This A&B (tmp) is greater than the previously maximum A&B
                    // found, so, we update max accordingly.
                    max = tmp;
                    if (max == K - 1) {
                        // In case we find the maximum A&B allowed, there's no
                        // need to keep looking for a one with greater value.
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] res = new int[T];

        // Process input
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();

            res[i] =  findCustomMax(N, K);
        }
        in.close();

        // Prints output
        for (int i : res) {
            System.out.println(i);
        }
    }
}
