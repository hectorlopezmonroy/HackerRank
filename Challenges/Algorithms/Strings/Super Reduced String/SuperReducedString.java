/*
 * Steve has a string, s, consisting of n lowercase English alphabetic letters.
 * In one operation, he can delete any pair of adjacent letters with same value.
 * For example, string "aabcc" would become either "aab" or "bcc" after 1
 * operation.
 *
 * Steve wants to reduce s as much as possible. To do this, he will repeat the
 * above operation as many times as it can be performed. Help Steve out by
 * finding and printing s' non-reducible form!
 *
 * Note: If the final string is empty, print "Empty String".
 *
 * Input Format
 *
 * A single string, s.
 *
 * Constraints
 *
 * 1 <= n <= 100
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
 * Steve can perform the following sequence of operations to get the final
 * string:
 *
 * 1. aaabccddd -> abccddd
 *
 * 2. abccddd ->abddd
 *
 * 3. abddd -> abd
 *
 * Thus, we print "abd".
 *
 * Sample Input 1
 *
 * baab
 *
 * Sample Output 1
 *
 * "Empty String"
 *
 * Explanation 1
 *
 * Steve can perform the following sequence of operations to get the final
 * string:
 *
 * 1. baab -> bb
 *
 * 2. bb -> "Empty String"
 *
 * Thus, we print "Empty String".
 *
 * Sample Input 2
 *
 * aa
 *
 * Sample Output 2
 *
* "Empty String"
*
* Explanation 2
*
* Steve can perform the following sequence of operations to get the final
* string:
*
* 1. aa - > "Empty String"
*
* Thus, we print "Empty String".
*/

import java.util.Scanner;

public class SuperReducedString {

    static boolean is_reducible(String s) {
        boolean res = false;

        if (s.length() <= 1) {
            res = false;
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    static String super_reduced_string(String s) {

        while (is_reducible(s)) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    if (s.length() <= 2) {
                        s = "Empty String";
                    } else {
                        if (i == 1) {
                            s = s.substring(i + 1, s.length());
                        } else if (i == s.length() - 1) {
                            s = s.substring(0, i - 1);
                        } else {
                            s = s.substring(0, i - 1) +
                                s.substring(i + 1, s.length());
                        }
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
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
