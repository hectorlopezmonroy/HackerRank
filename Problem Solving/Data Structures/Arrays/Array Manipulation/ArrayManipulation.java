/*
 * Starting with a 1-indexed array of zeros and a list of operations, for each
 * operation add a value to each element of the array between two given indices,
 * inclusive. Once all operations have been performed, return the maximum value
 * in your array.
 *
 * For example, the length of your array of zeros 'n = 10'. Your list of queries
 * is as follows:
 *
 *   a b k
 *   1 5 3
 *   4 8 7
 *   6 9 1
 *
 * Add the values of 'k' between the indices 'a' and 'b' inclusive:
 *
 *   index ->    1   2   3   4   5   6   7   8   9  10
 *            [  0,  0,  0,  0,  0,  0,  0,  0,  0,  0]
 *            [  3,  3,  3,  3,  3,  0,  0,  0,  0,  0]
 *            [  3,  3,  3, 10, 10,  7,  7,  7,  0,  0]
 *            [  3,  3,  3, 10, 10,  8,  8,  8,  1,  0]
 *
 * Function Description
 *
 * Complete the function 'arrayManipulation' in the editor below. It must return
 * an integer (long), the maximum value in the resulting array.
 *
 * 'arrayManipulation' has the following parameter(s):
 *
 *   * 'n': the number of elements in your array.
 *
 *   * 'queries': a two dimensional array of queries where each 'queries[i]'
 *                contains three integers, 'a', 'b', and 'k'.
 *
 * Input Format
 *
 * The first line contains two space-separated integers 'n' and 'm', the size of
 * the array and the number of operations.
 *
 * Each of the next 'm' lines contains three space-separated integers 'a', 'b',
 * and 'k', the left index, right index and summand.
 *
 * Constraints
 *
 * 3 <= n <= 10^7
 *
 * 1 <= m <= 2 * 10^5
 *
 * 1 <= a <= b <= n
 *
 * 0 <= k <= 10^9
 *
 * Output Format
 *
 * Return the integer maximum value in the finished array.
 *
 * Sample Input
 *
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 *
 * Sample Output
 *
 * 200
 *
 * Explanation
 *
 * After the first update list will be '[100, 100, 0, 0, 0]'.
 *
 * After the second update list will be '[100, 200, 100, 100, 100]'.
 *
 * After the third update list will be '[100, 200, 200, 200, 100]'.
 *
 * The required answer will be '200'.
 */

import java.util.Scanner;

/** To solve this challenge we'll use a "Difference Array" solution approach.
 *
 *
 *
 * Sources:
 *
 *   1.- https://www.hackerrank.com/challenges/crush/forum
 *
 *   2.- https://www.geeksforgeeks.org/difference-array-range-update-query-o1/
 */
public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        long res = 0;
        long temp = 0;
        int[] array = new int[n];

        // First loop goes through each of the 'm' queries.
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            array[a - 1] += k; // Substract 1 to offset the 1-indexing.

            if (b < n) {
                array[b] -= k;
            }
        }

        // Search for the maximum value in the array.
        for (int i = 0; i < n; i++) {
            temp += array[i];
            if (res < temp) {
                // New maximum is found, update the result accordingly.
                res = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] queries = new int[m][3];
        long result;

        // Process input
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            queries[i][0] = a;
            queries[i][1] = b;
            queries[i][2] = k;
        }
        in.close();

        result = arrayManipulation(n, queries);

        System.out.println(result);
    }
}
