/*
 * You will be given an array of integers. All of the integers except one occur
 * twice. That one is unique in the array.
 *
 * Given an array of integers, find and print the unique element.
 *
 * For example, 'a = [1, 2, 3, 4, 3, 2, 1]', the unique element is '4'.
 *
 * Function Description
 *
 * Complete the 'lonelyInteger' function in the editor below. It should return
 * the integer which occurs only once in the input array.
 *
 * 'lonelyInteger' has the following parameter(s):
 *
 *   * 'a': an array of integers.
 *
 * Input Format
 *
 * The first line contains a single integer, 'n', denoting the number of
 * integers in the array.
 *
 * The second line contains 'n' space-separated integers describing the values
 * in 'a'.
 *
 * Constraints
 *
 * 1 <= n < 100
 *
 * It is guaranteed that 'n' is an odd number and that there is one unique
 * element.
 *
 * 0 <= a[i] <= 100, where '0 <= i < n'.
 *
 * Output Format
 *
 * Print the unique integer in the array.
 *
 * Sample Input 0
 *
 * 1
 * 1
 *
 * Sample Output 0
 *
 * 1
 *
 * Explanation 0
 *
 * There is only one element in the array, thus it is unique.
 *
 * Sample Input 1
 *
 * 3
 * 1 1 2
 *
 * Sample Output 1
 *
 * 2
 *
 * Explanation 1
 *
 * We have two '1's, and '2' is unique.
 *
 * Sample Input 2
 *
 * 5
 * 0 0 1 2 1
 *
 * Sample Output 2
 *
 * 2
 *
 * Explanation 2
 *
 * We have two '0's, two '1's, and one '2'. '2' is unique.
 */

import java.util.Scanner;

public class LonelyInteger {

    static int lonelyInteger(int[] a) {
        int res = a[0];

        for (int i = 1; i < a.length; i++) {
            // Using XOR on the duplicate elements will cancel them,
            // leaving only the unique element.
            res = res ^ a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int result = 0;

        // Process input
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();

        result = lonelyInteger(a);

        // Prints output
        System.out.println(result);
    }
}
