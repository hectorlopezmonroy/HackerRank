/*
 * Consider an array of numeric strings, unsorted, where each string is a
 * positive number with anywhere from 1 to 10^6 digits. Sort the array's
 * elements in non-decreasing (i.e., ascending) order of their real-world
 * integer values and print each element of the sorted array on a new line.
 *
 * Input Format
 *
 * The first line contains an integer, n, denoting the number of strings in
 * unsorted. Each of the n subsequent lines contains a string of integers
 * describing an element of the array.
 *
 * Constraints
 *
 * 1 <= n <= 2 * 10^5
 *
 * Each string is guaranteed to represent a positive integer without leading
 * zeros.
 *
 * The total number of digits across all strings in unsorted is between 1 and
 * 10^6 (inclusive).
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
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class MyComparator implements Comparator<String> {
    public int compare(String x, String y) {
        int res = 0;
        if (x.length() == y.length()) {
            res =  x.compareTo(y);
        } else {
            res = x.length() - y.length();
        }
        return res;
    }
}

public class BigSorting {

    static String[] bigSorting(String[] arr) {
        String[] res = arr;
        Arrays.sort(res, new MyComparator());
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];

        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.next();
        }
        String[] result = bigSorting(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        in.close();
    }
}
