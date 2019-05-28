/*
 * You are choreographing a circus show with various animals. For one act, you
 * are given two kangaroos on a number line ready to jump in the positive
 * direction (i.e., toward positive infinity).
 *
 *   * The first kangaroo starts at location 'x1' and moves at a rate of 'v1'
 *     meters per jump.
 *
 *   * The second kangaroo starts at location 'x2' and moves at a rate of 'v2'
 *     meters per jump.
 *
 * You have to figure out a way to get both kangaroos at the same location at
 * the same time as part of the show. If it is possible, return "YES", otherwise
 * return "NO".
 *
 * For example, kangaroo '1' starts at 'x1 = 2' with a jump distance 'v1 = 1'
 * and kangaroo '2' starts at 'x2 = 1' with a jump distance of 'v2 = 2'. After
 * one jump, they are both at 'x = 3', '(x1 + v1 = 2 + 1, x2 + v2 = 1 + 2)', so
 * our answer is "YES".
 *
 * Function Description
 *
 * Complete the function 'kangaroo' in the editor below. It should return "YES"
 * if they reach the same position at the same time, or "NO" if they don't.
 *
 * 'kangaroo' has the following parameter(s):
 *
 *   * 'x1', 'v1': integers, starting position and jump distance for kangaroo 1.
 *
 *   * 'x2', 'v2': integers, starting position and jump distance for kangaroo 2.
 *
 * Input Format
 *
 * A single line of four space-separated integers denoting the respective values
 * of 'x1', 'v1', 'x2', and 'v2'.
 *
 * Constraints
 *
 * 0 <= x1 < x2 <= 10000
 *
 * 1 <= v1 <= 10000
 *
 * 1 <= v2 <= 10000
 *
 * Output Format
 *
 * Print "YES" if they can land on the same location at the same time;
 * otherwise, print "NO".
 *
 * Note: The two kangaroos must land at the same location after making the same
 * number of jumps.
 *
 * Sample Input 0
 *
 * 0 3 4 2
 *
 * Sample Output 0
 *
 * YES
 *
 * Explanation 0
 *
 * The two kangaroos jump through the following sequence of locations:
 *
 *
 *
 *                        -----    -----    -----    -----
 *                       /Jump1\  /Jump2\  /Jump3\  /Jump4\
 *                       k2      k2      k2       k2        k2
 *          -------     -------      -------      -------
 *        /  Jump 1 \ /  Jump 2 \  /  Jump 3 \  /  Jump 4 \
 *       k1          k1          k1          k1             k1
 * <----------------------------------------------------------------->
 *   -1   0   1   2   3   4   5   6   7   8   9   10   11   12   13
 *
 * From the image, it is clear that the kangaroos meet at the same location
 * (number '12' on the number line) after same number of jumps ('4' jumps), and
 * we print "YES".
 *
 * Sample Input 1
 *
 * 0 2 5 3
 *
 * Sample Output 1
 *
 * NO
 *
 * Explanation 1
 *
 * The second kangaroo has a starting location that is ahead (further to the
 * right) of the first kangaroo's starting location (i.e., 'x2 > x1'). Because
 * the second kangaroo moves at a faster rate (meaning 'v2 > v1') and is already
 * ahead of the first kangaroo, the first kangaroo will never be able to cach
 * up. Thus, we print NO.
 */

import java.util.Scanner;

public class Kangaroo {

    /** Determines if two kangaroos meet after same number of jumps.
     * By using the functions x_1(i) = x1 + v1 * jump(i) for kangaroo 1 and
     * x_2(i) = x2 + v2 * jump(i) for kangaroo 2, it's possible to determine if
     * both kangaroos meet at the same point after the same number of jumps.
     * @param x1 integer denoting kangaroo 1's starting position.
     * @param v1 integer denoting kangaroo 1's jump distance.
     * @param x2 integer denoting kangaroo 2's starting position.
     * @param v2 integer denoting kangaroo 2's jump distance.
     * @return a String "YES" if both kangaroos meet; "NO" otherwise.
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        String res = "NO";
        float jumps = (x1 - x2) / (float) (v2 - v1);

        if (jumps > 0 &&
            jumps == Math.round(jumps) &&
            jumps == Math.ceil(jumps)) {
            res = "YES";
        }
        return res;
    }

    public static void main(String[] args) {
        String result;
        Scanner in = new Scanner(System.in);

        // Process input
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        in.close();

        result = kangaroo(x1, v1, x2, v2);

        // Prints output
        System.out.println(result);
    }
}
