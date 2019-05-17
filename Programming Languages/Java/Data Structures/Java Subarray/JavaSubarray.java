/*
 * We define the following:
 *
 *   * A 'subarray' of an n-element array is an array composed from a contiguous
 *     block of the original array's elements. For example, if 'array' =
 *     [1, 2, 3], then the subarrays are [1], [2], [3], [1, 2], [2, 3], and
 *     [1, 2, 3]. Something like [1, 3] would 'not' be a subarray as it's not a
 *     contiguous subsection of the original array.
 *
 *   * The sum of an array is the total sum of its elements.
 *
 *     * An array's sum is 'negative' if the total sum of its elements is
 *       negative.
 *
 *     * An array's sum is 'positive' if the total sum of its elements is
 *       positive.
 *
 * Given an array of 'n' integers, find and print its number of 'negative
 * subarrays' on a new line.
 *
 * Input Format
 *
 * The first line contains a single integer, 'n', denoting the length of array
 * A = [a_0, a_1, ... , a_(n - 1)].
 * The second line contains 'n' space-separated integers describing each
 * respective element, 'a_i', in array 'A'.
 *
 * Constraints
 *
 * 1 <= n <= 100
 *
 * -10^4 <= a_i <= 10^4
 *
 * Output Format
 *
 * Print the number of subarrays of 'A' having negative sums.
 *
 * Sample Input
 *
 * 5
 * 1 -2 4 -5 1
 *
 * Sample Output
 *
 * 9
 *
 * Explanation
 *
 * There are nine negative subarrays of A = [1, -2, 4, -5, 1]:
 *
 * 1. [1:1] -> -2
 * 2. [3:3] -> -5
 * 3. [0:1] -> 1 + -2 = -1
 * 4. [2:3] -> 4 + -5 = -1
 * 5. [3:4] -> -5 + 1 = -4
 * 6. [1:3] -> -2 + 4 + -5 = -3
 * 7. [0:3] -> 1 + -2 + 4 + -5 = -2
 * 8. [1:4] -> -2 + 4 + -5 + 1 = -2
 * 9. [0:4] -> 1 + -2 + 4 + -5 + 1 = -1
 *
 * Thus, we print 9 on a new line.
 */

import java.util.Scanner;

public class JavaSubarray {

    /** Returns the sum of the subarray of A denoted by the indices.
     * @param A an integer array.
     * @param start the start index (inclusive) of the subarray.
     * @param end the end index (inclusive) of the subarray.
     * @return the sum of the subarray denoted by the indices.
     */
    public static int subArraySum(int[] A, int start, int end) {
        int res = 0;

        if ((0 <= start) && (start < A.length) &&
            (0 <= end) && (end < A.length) && (start <= end)) {
            for (int i = start; i <= end; i++) {
                res += A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];

        // Initializes input array
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        in.close();

        // Loops through all possible 'start' indices of the subarray
        for (int start = 0; start < n; start++) {

            // Loops through all possible 'end' indices of the subarray
            for (int end = start; end < n; end++) {
                if (subArraySum(A, start, end) < 0) {
                    // The sum of the subarray is negative
                    res++;
                }
            }
        }

        // Prints output as requested
        System.out.println(res);
    }
}
