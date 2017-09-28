/*
 * Given a square matrix of size N x N, calculate the absolute difference
 * between the sums of its diagonals.
 *
 * Input Format
 *
 * The first line contains a single integer, N. The next N lines denote the
 * matrix's rows, with each line containing N space-separated integers
 * describing the columns.
 *
 * Constraints
 *
 * -100 <= A[i, j] <= 100 for all i, j.
 *
 *  Output Format
 *
 *  Print the absolute difference between the two sums of the matrix's diagonals
 *  as a single integer.
 *
 *  Sample Input
 *
 *  3
 *  11 2 4
 *  4 5 6
 *  10 8 -12
 *
 *  Sample Output
 *
 *  15
 *
 *  Explanation
 *
 *  The primary diagonal is:
 *  11
 *      5
 *         -12
 *
 *  Sum across the primary diagonal: 11 + 5 - 12 = 4
 *
 *  The secondary diagonal is:
 *         4
 *      5
 *  10
 *
 *  Sum across the secondary diagonal: 4 + 5 + 10 = 19
 *
 *  Difference: |4 - 19| = 15.
 *
 *  Note: |x| is absolute value function.
 */

import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        for (int i = 0; i < n; i++) {
            diag1 = diag1 + matrix[i][i];
            diag2 = diag2 + matrix[i][n - i - 1];
        }
        System.out.println(Math.abs(diag1 - diag2));
    }
}
