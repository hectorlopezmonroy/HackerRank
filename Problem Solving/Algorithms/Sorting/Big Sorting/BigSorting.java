/*
 * Consider an array of numeric strings where each string is a positive number
 * with anywhere from '1' to '10^6' digits. Sort the array's elements in
 * non-decreasing, or ascending order of their integer values and print each
 * element of the sorted array on a new line.
 *
 * Function Description
 *
 * Complete the 'bigSorting' function in the editor below. It should return the
 * sorted string array.
 *
 * 'bigSorting' has the following parameter(s):
 *
 *   * 'unsorted': an unsorted array of integers as strings.
 *
 * Input Format
 *
 * The first line contains an integer, 'n', denoting the number of strings in
 * 'unsorted'. Each of the 'n' subsequent lines contains an integer string
 * 'unsorted[i]'.
 *
 * Constraints
 *
 * 1 <= n <= 2 * 10^5
 *
 *   * Each string is guaranteed to represent a positive integer without leading
 *     zeros.
 *
 *   * The total number of digits across all strings in 'unsorted' is between
 *     '1' and '10^6' (inclusive).
 *
 * Output Format
 *
 * Print each element of the sorted array on a new line.
 *
 * Sample Input 0
 *
 * 6
 * 31415926535897932384626433832795
 * 1
 * 3
 * 10
 * 3
 * 5
 *
 * Sample Output 0
 *
 * 1
 * 3
 * 3
 * 5
 * 10
 * 31415926535897932384626433832795
 *
 * Explanation 0
 *
 * The initial array of strings is unsorted = [31415926535897932384626433832795,
 * 1, 3, 10, 3, 5]. When we order each string by the real-world integer value it
 * represents, we get:
 *
 *         1 <= 3 <= 3 <= 5 <= 10 <= 31415926535897932384626433832795
 *
 * We then print each value on a new line, from smallest to largest.
 *
 * Sample Input 1
 *
 * 8
 * 1
 * 2
 * 100
 * 12303479849857341718340192371
 * 3084193741082937
 * 3084193741082938
 * 111
 * 200
 *
 * Sample Output 1
 *
 * 1
 * 2
 * 100
 * 111
 * 200
 * 3084193741082937
 * 3084193741082938
 * 12303479849857341718340192371
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class MyComparator implements Comparator<String> {

    public int compare(String x, String y) {
        int res = 0;

        if (x.length() == y.length()) {
            // If the lengths of both strings is the same, then we compare them
            // lexicographically.

            res =  x.compareTo(y);
        } else {
            // Since one of the constraints is that each string is guaranteed to
            // represent a positive integer without leading zeros, then a string
            // 'x' with a length greater than string 'y' is going to be stricly
            // greater in their integer values as well.

            res = x.length() - y.length();
        }
        return res;
    }
}

public class BigSorting {

    static String[] bigSorting(String[] unsorted) {
        String[] res = unsorted;

        Arrays.sort(res, new MyComparator());
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] sorted;
        String[] unsorted = new String[n];

        // Process input
        for (int i = 0; i < n; i++) {
            unsorted[i] = in.next();
        }
        in.close();

        sorted = bigSorting(unsorted);

        // Prints output
        for (String s : sorted) {
            System.out.println(s);
        }
    }
}
