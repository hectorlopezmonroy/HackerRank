/*
 * You will be given two arrays of integers and asked to determine all integers
 * that satisfy the following two conditions:
 *
 *   1.- The elements of the first array are all factors of the integer being
 *       considered.
 *
 *   2.- The integer being considered is a factor of all elements of the second
 *       array.
 *
 * These numbers are referred to as being between the two arrays. You must
 * determine how many such numbers exist.
 *
 * For example, given the arrays 'a = [2, 6]' and 'b = [24, 36]', there are two
 * numbers between them: '6' and '12'. 6 % 2 = 0, 6 % 6 = 0, 24 % 6 = 0, and
 * 36 % 6 = 0 for the first value. Similarly, 12 % 2 = 0, 12 % 6 = 0,
 * 24 % 12 = 0 and 36 % 12 = 0.
 *
 * Function Description
 *
 * Complete the 'getTotalX' function in the editor below. It should return the
 * number of integers that are between the sets.
 *
 * 'getTotalX' has the following parameter(s):
 *
 *   * 'a': an array of integers.
 *
 *   * 'b': an array of integers.
 *
 * Input Format
 *
 * The first line contains two space-separated integers, 'n' and 'm', the number
 * of elements in array 'a' and the number of elements in array 'b'.
 *
 * The second line contains 'n' distinct space-separated integers describing
 * 'a[i]' where '0 <= i < n'.
 *
 * The third line contains 'm' distinct space-separated integers describing
 * 'b[j]' where '0 <= j < m'.
 *
 * Constraints
 *
 * 1 <= n, m <= 10
 *
 * 1 <= a[i] <= 100
 *
 * 1 <= b[j] <= 100
 *
 * Output Format
 *
 * Print the number of integers that are considered to be between 'a' and 'b'.
 *
 * Sample Input
 *
 * 2 3
 * 2 4
 * 16 32 96
 *
 * Sample Output
 *
 * 3
 *
 * Explanation
 *
 * 2 and 4 divide evenly into 4, 8, 12 and 16.
 *
 * 4, 8 and 16 divide evenly into 16, 32, 96.
 *
 * 4, 8 and 16 are the only three numbers for which each element of 'a' is a
 * factor and each is a factor of all elements of 'b'.
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class BetweenTwoSets {

    /** Gets the element with minimum value from an integer array.
     * The array must have at least one element.
     * @param a an integer array.
     * @return integer with the minimum value in the input integer array.
     */
    static int getMinimum(int[] a) {
        int res = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < res) {
                res = a[i];
            }
        }
        return res;
    }

    /** Gets the element with maximum value from an integer array.
     * The array must have at least one element.
     * @param a an integer array.
     * @return integer with the maximum value in the input integer array.
     */
    static int getMaximum(int[] a) {
        int res = a[0];

        for (int i = 1; i < a.length; i++) {
            if (res < a[i]) {
                res = a[i];
            }
        }
        return res;
    }

    /** Gets the number of integers that are between the two sets.
     * Refer to the challenge's explanation.
     * @param a an integer array.
     * @param b an integer array.
     * @return an integer denoting the number of integers between the two sets.
     */
    static int getTotalX(int[] a, int[] b) {
        int res = 0;
        int maxA, minB;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        maxA = getMaximum(a);
        minB = getMinimum(b);

        // We get those integers that satisfy condition 1 of the challenge
        // and store them in Set 's1'.
        for (int i = maxA; i <= minB; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] == 0) {
                    s1.add(i);
                } else {
                    s1.remove(i);
                    break;
                }
            }
        }

        // Out of the integers in 's1', we get those integers that also satisfy
        // condition 2 of the challenge and store them in Set 's2'.
        for (int i : s1) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] % i != 0) {
                    s2.add(i);
                    break;
                }
            }
        }
        res = s1.size() - s2.size();
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int result = 0;

        // Process input
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        in.close();

        result = getTotalX(a, b);

        // Prints output
        System.out.println(result);
    }
}
