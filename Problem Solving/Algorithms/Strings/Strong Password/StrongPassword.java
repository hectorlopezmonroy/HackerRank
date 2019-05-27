/*
 * Louise joined a social networking site to stay in touch with her friends. The
 * signup page required her to input a name and a password. However, the
 * password must be strong. The website considers a password to be strong if it
 * satisfies the following criteria:
 *
 *   * Its length is at least '6'.
 *
 *   * It contains at least one digit.
 *
 *   * It contains at least one lowercase English character.
 *
 *   * It contains at least one uppercase English character.
 *
 *   * It contains at least one special character. The special characters are:
 *     "!@#$%^&*()-+".
 *
 * She typed a random string of length 'n' in the password field but wasn't sure
 * if it was strong. Given the string she typed, can you find the minimum number
 * of characters she must add to make her password strong?
 *
 * Note: Here's the set of types of characters in a form you can paste in your
 * solution.
 *
 *   numbers = "0123456789"
 *   lower_case = "abcdefghijklmnopqrstuvwxyz"
 *   upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
 *   special_characters = "!@#$%^&*()-+"
 *
 * Input Format
 *
 * The first line contains an integer 'n' denoting the length of the string.
 *
 * The second line contains a string consisting of 'n' characters, the password
 * typed by Louise. Each character is either a lowercase/uppercase English
 * alphabet, a digit, or a special character.
 *
 * Constraints
 *
 * 1 <= n <= 100
 *
 * Output Format
 *
 * Print a single line containing a single integer denoting the answer to the
 * problem.
 *
 * Sample Input 0
 *
 * 3
 * Ab1
 *
 * Sample Output 0
 *
 * 3
 *
 * Explanation 0
 *
 * She can make the password strong by adding '3' characters, for example,
 * "$hk", turning the password into "Ab1$hk" which is strong.
 *
 * '2' characters aren't enough since the length must be at least '6'.
 *
 * Sample Input 1
 *
 * 11
 * #HackerRank
 *
 * Sample Output 1
 *
 * 1
 *
 * Explanation 1
 *
 * The password isn't strong, but she can make it strong by adding a single
 * digit.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {

    static boolean isAtLeast6CharsLong(String password) {
        boolean res = false;

        res = (6 <= password.length());
        return res;
    }

    static int minimumNumber(int n, String password) {
        int res = 0;
        String[] regExs = new String[4];

        // Regular Expressions for a strong password.
        regExs[0] = ".*\\d+.*";         // Contains a digit.
        regExs[1] = ".*\\p{Punct}.*";   // Contains a special character.
        regExs[2] = ".*\\p{Lower}+.*";  // Contains a lowercase character.
        regExs[3] = ".*\\p{Upper}+.*";  // Contains an uppercase character.

        for (String s : regExs) {
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(password);

            if(!m.matches()) {
                // String 's' doesn't match with this pattern,
                // another character must be added to make it a strong password.

                res++;
            }
        }

        if (!isAtLeast6CharsLong(password)) {
            // String 's' doesn't have enough characters to be a strong
            // password, we need to add the maximum between the number of
            // characters to get s' length to 6 or the number of characters
            // String 's' needs to be a strong password.

            res = Math.max(6 - password.length(), res);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result;
        int n = in.nextInt();
        String password = in.next();
        in.close();

        result = minimumNumber(n, password);

        // Prints output
        System.out.println(result);
    }
}
