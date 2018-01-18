/*
 * We define the following terms:
 *
 *   * Lexicographical Order, also known as 'alphabetic' or 'dictionary' order,
 *     orders characters as follows:
 *
 *                   A < B < ... < Y < Z < a < b < ... < y < z
 *
 *     For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
 *
 *   * A substring of a string is a contiguous block of characters in the
 *     string. For example, the substrings of "abc" are "a", "b", "c", "ab",
 *     "bc", and "abc".
 *
 * Given a string, 's', and an integer, 'k', complete the function so that it
 * finds the lexicographically 'smallest' and 'largest' substrings of length
 * 'k'.
 *
 * Input Format
 *
 * The first line contains a string denoting 's'.
 * The second line contains an integer denoting 'k'.
 *
 * Constraints
 *
 * 1 <= |s| <= 1000
 * 's' consists of English alphabetic letters only (i.e., [a-zA-Z]).
 *
 * Output Format
 *
 * Return the respective lexicographically smallest and largest substrings as a
 * single newline-separated string.
 *
 * Sample Input
 *
 * welcometojava
 * 3
 *
 * Sample Output
 *
 * ava
 * wel
 *
 * Explanation
 *
 * String 's' = "welcometojava" has the following lexicographically-ordered
 * substrings of length k = 3:
 *
 * ["ava", "com", "elc", "eto", "jav", "lco", "met", "oja", "ome", "toj", "wel"]
 *
 * We then return the first (lexicographically smallest) substring and the last
 * (lexicographically largest) substring as two newline-separated values
 * (i.e., "ava\nwel").
 *
 * The stub code in the editor then prints "ava" as our first line of output and
 * "wel" as our second line of output.
 */

import java.util.Scanner;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String tmp = "";
        String largest = "";
        String smallest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = 0; i < s.length() - k + 1; i++) {
            tmp = s.substring(i, i + k);
            if (i == 0) {
                smallest = s.substring(i, i + k);
                largest = s.substring(i, i + k);
            }
            if (tmp.compareTo(smallest) < 0) {
                smallest = tmp;
            }
            if (tmp.compareTo(largest) > 0) {
                largest = tmp;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        in.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
