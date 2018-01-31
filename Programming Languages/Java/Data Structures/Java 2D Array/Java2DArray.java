/*
 * You are given a 6 * 6 2D array. An hourglass in an array is a portion shaped
 * like this:
 *
 *   a b c
 *     d
 *   e f g
 *
 * For example, if we create an hourglass using the number 1 within an array
 * full of zeros, it may look like this:
 *
 *   1 1 1 0 0 0
 *   0 1 0 0 0 0
 *   1 1 1 0 0 0
 *   0 0 0 0 0 0
 *   0 0 0 0 0 0
 *   0 0 0 0 0 0
 *
 * Actually, there are many hourglasses in the array above. The three leftmost
 * hourglasses are the following:
 *
 *   1 1 1    1 1 0    1 0 0
 *     1        0        0
 *   1 1 1    1 1 0    1 0 0
 *
 * The sum of an hourglass is the sum of all the numbers within it. The sum for
 * the hourglasses above are 7, 4, and 2, respectively.
 *
 * In this problem you have to 'print the largest sum among all the hourglasses'
 * in the array.
 *
 * Input Format
 *
 * There will be exactly 6 lines, each containing 6 integers separated by
 * spaces. Each integer will be between -9 and 9 inclusive.
 *
 * Output Format
 *
 * Print the answer to this problem on a single line.
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
 * The hourglass which has the largest sum is:
 *
 *   2 4 4
 *     2
 *   1 2 4
 */

import java.util.Scanner;

public class Java2DArray {

    public static void main(String[] args) {
        int max = 0;
        int temp = 0;
        int[][] arr = new int[6][6];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        in.close();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                temp = temp + arr[i + 1][j + 1];
                temp = temp + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (i == 0 && j == 0) {
                    max = temp;
                } else if (temp > max) {
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }
}
