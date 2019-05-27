/*
 * Steve has a string of lowercase characters in range 'ascii['a'...'z']'. He
 * wants to reduce the string to its shortest length by doing a series of
 * operations. In each operation he selects a pair of adjacent lowercase letters
 * that match, and he deletes them. For instance, the string 'aab' could be
 * shortened to 'b' in one operation.
 *
 * Steve's task is to delete as many characters as possible using this method
 * and print the resulting string. If the final string is empty, print
 * "Empty String".
 *
 * Function Description
 *
 * Complete the 'superReducedString' function in the editor below. It should
 * return the super reduced string or "Empty String" if the final string is
 * empty.
 *
 * 'superReducedString' has the following parameter(s):
 *
 *   * 's': a string to reduce.
 *
 * Input Format
 *
 * A single string, 's'.
 *
 * Constraints
 *
 * 1 <= |s| <= 100
 *
 * Output Format
 *
 * If the final string is empty, print "Empty String"; otherwise, print the
 * final non-reducible string.
 *
 * Sample Input 0
 *
 * aaabccddd
 *
 * Sample Output 0
 *
 * abd
 *
 * Explanation 0
 *
 * Steve performs the following sequence of operations to get the final string:
 *
 * aaabccddd -> abccddd -> abddd -> abd
 *
 * Sample Input 1
 *
 * aa
 *
 * Sample Output 1
 *
 * "Empty String"
 *
 * Explanation 1
 *
 * aa - > "Empty String"
 *
 * Sample Input 2
 *
 * baab
 *
 * Sample Output 2
 *
 * "Empty String"
 *
 * Explanation 2
 *
 * baab -> bb -> "Empty String"
 */

import java.util.Scanner;

public class SuperReducedString {

    /** Determines if a given String can be reduced and returns a boolean value.
     * An input String 's' can be reduced if it has two adjacent letters
     * that match.
     * @param s a String to be determined if it can be reduced or not.
     * @return a boolean value "true" if the string is reducible, "false"
     * otherwise.
     */
    public static boolean isReducible(String s) {
        boolean res = false;

        if (s.length() > 1) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    static String superReducedString(String s) {

        while (isReducible(s)) {

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    // The indices of the characters to be reduced are 'i' and
                    // 'i - 1'.

                    if (s.length() == 2) {
                        // Once the two characters are reduced, the string will
                        // be empty.

                        s = "Empty String";
                    } else {
                        s = s.substring(0, i - 1) +
                            s.substring(i + 1, s.length());
                    }
                    break;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result;
        in.close();

        result = superReducedString(s);

        System.out.println(result);
    }
}
