/*
 * Objective
 * Today, we're building on our knowledge of Arrays by adding another dimension.
 * Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Context
 * Given a 6 x 6 2D Array, 'A':
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 *
 * We define an hourglass in 'A' to be a subset of values with indices falling
 * in this pattern in A's graphical representation:
 *
 * a b c
 *   d
 * e f g
 *
 * There are 16 hourglasses in 'A', and an hourglass sum is the sum of an
 * hourglass' values.
 *
 * Task
 * Calculate the hourglass sum for every hourglass in 'A', then print the
 * maximum hourglass sum.
 *
 * Input Format
 *
 * There are 6 lines of input, where each line contains 6 space-separated
 * integers describing 2D Array 'A'; every value in 'A' will be in the inclusive
 * range of -9 to 9.
 *
 * Constraints
 *
 * -9 <= A[i][j] <= 9
 *
 * 0 <= i, j <= 5
 *
 * Output Format
 *
 * Print the largest (maximum) hourglass sum found in 'A'.
 *
 * Sample Input
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 *
 * Sample Output
 *
 * 19
 *
 * Explanation
 *
 * 'A' contains the following hourglasses:
 *
 * 1 1 1  1 1 0  1 0 0  0 0 0
 *   1      0      0      0
 * 1 1 1  1 1 0  1 0 0  0 0 0
 *
 * 0 1 0  1 0 0  0 0 0  0 0 0
 *   1      1      0      0
 * 0 0 2  0 2 4  2 4 4  4 4 0
 *
 * 1 1 1  1 1 0  1 0 0  0 0 0
 *   0      2      4      4
 * 0 0 0  0 0 2  0 2 0  2 0 0
 *
 * 0 0 2  0 2 4  2 4 4  4 4 0
 *   0      0      2      0
 * 0 0 1  0 1 2  1 2 4  2 4 0
 *
 * The hourglass with the maximum sum (19) is:
 *
 * 2 4 4
 *   2
 * 1 2 4
 */

 import java.util.Scanner;

 public class TwoDimensionalArrays {

    public static int computeMaxHourglassSum(int[][] arr) {
        int max = 0;
        int tmp = 0;

        // Loops through the columns of the two-dimensional array
        for (int i = 0; i < 4; i++) {

            // Loops through the rows of the two-dimensional array
            for (int j = 0; j < 4; j++) {

                // Upper edge of the hourglass
                tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];

                // Center of the hourglass
                tmp += arr[i + 1][j + 1];

                // Bottom of the hourglass
                tmp += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (i == 0 && j == 0) {
                    // Initializes 'max' with the value of the first hourglass
                    max = tmp;
                } else if (tmp > max) {
                    // Updates 'max' if there's another hourglass with a greater
                    // value
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[6][6];

        // Process input
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        in.close();

        System.out.println(computeMaxHourglassSum(arr));
    }
 }
