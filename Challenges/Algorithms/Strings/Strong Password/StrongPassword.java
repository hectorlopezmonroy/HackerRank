/*
 * Louise joined a social networking site to stay in touch with her friends. The
 * signup page required her to input a 'name' and a 'password'. However, the
 * password must be 'strong'. The website considers a password to be 'strong' if
 * it satisfies the following criteria:
 *
 *   * Its length is at least 6.
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
 * She can make the password strong by adding 3 characters, for example, "$hk",
 * turning the password into "Ab1$hk" which is strong. 2 characters aren't
 * enough since the length must be at least 6.
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
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StrongPassword {

    static boolean isAtLeast6CharsLong(String password) {
        return 6 <= password.length();
    }

    static int minimumNumber(int n, String password) {
        int res = 0;
        String[] regExs = new String[4];
        regExs[0] = ".*\\d+.*";
        regExs[1] = ".*\\p{Punct}.*";
        regExs[2] = ".*\\p{Lower}+.*";
        regExs[3] = ".*\\p{Upper}+.*";

        for (String s : regExs) {
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(password);

            if(!m.matches()) {
                res++;
            }
        }
        if (!isAtLeast6CharsLong(password)) {
            res = Math.max(6 - password.length(), res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        in.close();

        int answer = minimumNumber(n, password);
        System.out.println(answer);
    }
}
