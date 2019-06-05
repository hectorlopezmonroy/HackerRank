/*
 * Given two integers, 'l' and 'r', find the maximal value of 'a' xor 'b', where
 * 'a' and 'b' satisfy the following condition:
 *
 *   'l <= a <= b <= r'
 *
 * For example, if 'l = 11' and 'r = 12', then
 *
 * 11 xor 11 = 0
 * 11 xor 12 = 7
 * 12 xor 12 = 0
 *
 * Our maximum value is '7'.
 *
 * Function Description
 *
 * Complete the 'maximizingXor' function in the editor below. It must return an
 * integer representing the maximum value calculated.
 *
 * 'maximizingXor' has the following parameter(s):
 *
 *   * 'l': an integer, the lower bound, inclusive.
 *
 *   * 'r': an integer, the upper bound, inclusive.
 *
 * Input Format
 *
 * The first line contains the integer 'l'.
 *
 * The second line contains the integer 'r'.
 *
 * Constraints
 *
 * 1 <= l <= r <= 10^3
 *
 * Output Format
 *
 * Return the maximal value of the xor operations for all permutations of the
 * integers from 'l' to 'r', inclusive.
 *
 * Sample Input 0
 *
 * 10
 * 15
 *
 * Sample Output 0
 *
 * 7
 *
 * Explanation 0
 *
 * The input tells us that 'l = 10' and 'r = 15'. All the pairs which comply to
 * the condition above are the following:
 *
 * 10 xor 10 = 0
 * 10 xor 11 = 1
 * 10 xor 12 = 6
 * 10 xor 13 = 7
 * 10 xor 14 = 4
 * 10 xor 15 = 5
 * 11 xor 11 = 0
 * 11 xor 12 = 7
 * 11 xor 13 = 6
 * 11 xor 14 = 5
 * 11 xor 15 = 4
 * 12 xor 12 = 0
 * 12 xor 13 = 1
 * 12 xor 14 = 2
 * 12 xor 15 = 3
 * 13 xor 13 = 0
 * 13 xor 14 = 3
 * 13 xor 15 = 2
 * 14 xor 14 = 0
 * 14 xor 15 = 1
 * 15 xor 15 = 0
 *
 * Here two pairs (10, 13) and (11, 12) have maximum xor value '7', and this is
 * the answer.
 *
 * Sample Input 1
 *
 * 11
 * 100
 *
 * Sample Output 1
 *
 * 127
 */

import java.util.Scanner;

public class MaximizingXOR {

    static int maximizingXor(int l, int r) {
        int res = 0;

        for (int i = l; i < r; i++) {
            for (int j = i + 1; j <= r; j++) {
                // We skip r = l since 'l' xor 'r' is always zero.

                int tmp = i ^ j;
                if (res < tmp) {
                    // Updating maximum accordingly.
                    res = tmp;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result = 0;
        in.close();

        result = maximizingXor(l, r);

        // Prints output
        System.out.println(result);
    }
}
