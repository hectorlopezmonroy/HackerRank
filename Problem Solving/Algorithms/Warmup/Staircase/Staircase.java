/*
 * Consider a staircase of size 'n = 4':
 *
 *    #
 *   ##
 *  ###
 * ####
 *
 * Observe that its base and height are both equal to 'n', and the image is
 * drawn using # symbols and spaces. The last line is not preceded by any
 * spaces.
 *
 * Write a program that prints a staircase of size 'n'.
 *
 * Function Description
 *
 * Complete the 'staircase' function in the editor below. It should print a
 * staircase as described above.
 *
 * 'staircase' has the following parameter(s):
 *
 *   * 'n': an integer.
 *
 * Input Format
 *
 * A single integer, 'n', denoting the size of the staircase.
 *
 * Constraints
 *
 * 0 < n <= 100
 *
 * Output Format
 *
 * Print a staircase of size 'n' using # symbols and spaces.
 *
 * Note: The last line must have '0' spaces in it.
 *
 * Sample Input
 *
 * 6
 *
 * Sample Output
 *
 *      #
 *     ##
 *    ###
 *   ####
 *  #####
 * ######
 *
 * Explanation
 *
 * The staircase is right-aligned, composed of # symbols and spaces, and has a
 * height and width of 'n = 6'.
 */

import java.util.Scanner;

public class Staircase {

    static void staircase(int n) {

        // This loop handles the 'n' lines to print.
        for (int i = 0; i < n; i++) {

            // This loop handles how many spaces are printed on each line.
            // Starts with n - 1 for the first line and 0 spaces for the last
            // one.
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // This loop handles how many '#' are printed on each line.
            // Starts with 1 for the first line and n for the last one.
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        staircase(n);
    }
}
