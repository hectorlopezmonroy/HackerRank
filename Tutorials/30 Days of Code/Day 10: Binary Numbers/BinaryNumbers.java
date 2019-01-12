/*
 * Objective
 * Today, we're working with binary numbers. Check out the Tutorial tab for
 * learning materials and an instructional video!
 *
 * Task
 * Given a base-10 integer, 'n', convert it to binary (base-2). Then find and
 * print the base-10 integer denoting the maximum number of consecutive 1's in
 * n's binary representation.
 *
 * Input Format
 *
 * A single integer, 'n'.
 *
 * Constraints
 *
 * 1 <= n <= 10^6
 *
 * Output Format
 *
 * Print a single base-10 integer denoting the maximum number of consecutive 1's
 * in the binary representation of 'n'.
 *
 * Sample Input 0
 *
 * 5
 *
 * Sample Output 0
 *
 * 1
 *
 * Sample Input 1
 *
 * 13
 *
 * Sample Output 1
 *
 * 2
 *
 * Explanation
 *
 * Sample Case 0:
 * The binary representation of 5 is 101, so the maximum number of consecutive
 * 1's is 1.
 *
 * Sample Case 1:
 * The binary representation of 13 is 1101, so the maximum number of consecutive
 * 1's is 2.
 */

import java.util.Scanner;

public class BinaryNumbers {

    public static String decimalToBinaryRep(int n) {
        String res = "";

        /* Using the "Divide by 2" algorithm to convert a decimal integer into
         * its binary representation.
         */
        while (n > 0) {
            res = ((char) n % 2) + res;
            n = n / 2;
        }
        return res;
    }

    public static int countMaxConsecutiveOnes(String s) {
        int max = 0;
        int temp = 0;

        /* Loops through the length of the binary representation to find its
         * maximum number of consecutive ones.
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                temp++;
            } else {
                temp = 0;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(countMaxConsecutiveOnes(decimalToBinaryRep(n)));
        in.close();
    }
}
