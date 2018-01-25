/*
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backward or forward. (Wikipedia)
 *
 * Given a string 'A', print "Yes" if it is a palindrome, print "No" otherwise.
 *
 * Constraints
 *
 * 'A' will consist at most 50 lower case english letters.
 *
 * Sample Input
 *
 * madam
 *
 * Sample Output
 *
 * Yes
 */

import java.util.Scanner;

public class JavaStringReverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        boolean res = true;
        in.close();

        for (int i = 0; i < (A.length() / 2); i++) {
            if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
                res = false;
                break;
            }
        }
        if (res) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
