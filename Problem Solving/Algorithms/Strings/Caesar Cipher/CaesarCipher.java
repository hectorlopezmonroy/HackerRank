/*
 * Julius Caesar protected his confidential information by encrypting it using a
 * cipher. Caesar's cipher shifts each letter by a number of letters. If the
 * shift takes you past the end of the alphabet, just rotate back to the front
 * of the alphabet. In the case of a rotation by 3, w, x, y and z would map to
 * z, a, b, and c.
 *
 *    Original alphabet:      abcdefghijklmnopqrstuvwxyz
 *    Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
 *
 * For example, the given cleartext 's = There's-a-starman-waiting-in-the-sky'
 * and the alphabet is rotated by 'k = 3'.
 *
 * The encrypted string is 'Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb'.
 *
 * Note: The cipher 'only' encrypts letters; symbols, such as '-', remain
 * unencrypted.
 *
 * Function Description
 *
 * Complete the 'caesarCipher' function in the editor below. It should return
 * the encrypted string.
 *
 * 'caesarCipher' has the following parameter(s):
 *
 *    * 's': a string in cleartext.
 *
 *    * 'k': an integer, the alphabet rotation factor.
 *
 * Input Format
 *
 * The first line contains the integer, 'n', the length of the unencrypted
 * string.
 *
 * The second line contains the unencrypted string, 's'.
 *
 * The third line contains 'k', the number of letters to rotate the alphabet by.
 *
 * Constraints
 *
 * 1 <= n <= 100
 *
 * 0 <= k <= 100
 *
 *   * 's' is a valid ASCII string without any spaces.
 *
 * Output Format
 *
 * For each test case, print the encoded string.
 *
 * Sample Input
 *
 * 11
 * middle-Outz
 * 2
 *
 * Sample Output
 *
 * okffng-Qwvb
 *
 * Explanation
 *
 * Original alphabet:       abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +2:     cdefghijklmnopqrstuvwxyzab
 *
 * m -> o
 * i -> k
 * d -> f
 * d -> f
 * l -> n
 * e -> g
 * -    -
 * O -> Q
 * u -> w
 * t -> v
 * z -> b
 */

import java.util.HashMap;
import java.util.Scanner;

public class CaesarCipher {

    private static HashMap<Character, Character> map;

    CaesarCipher(int k) {
        this.map = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length(); i++) {
            char key = alphabet.charAt(i);
            char value = alphabet.charAt((i + k) % alphabet.length());

            map.put(key, value);
        }
    }

    public static char cipher(char c) {
        char res = ' ';

        if (Character.isLetter(c)) {
            //If the character is a letter, either lowercase or uppercase.

            if (Character.isUpperCase(c)) {
                // If the character is uppercase, we transform it to towercase
                // and then cipher it.

                res = map.get(Character.toLowerCase(c));
            } else {
                // If the character is lowercase, we cipher it.

                res = map.get(c);
            }
        } else {
            // If the character is not a letter, we don't cipher it.

            res = c;
        }

        return res;
    }

    public static String caesarCipher(String s, int k) {
        String res = "";
        CaesarCipher cc = new CaesarCipher(k);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                //If the character is a letter, either lowercase or uppercase.

                if (Character.isUpperCase(c)) {
                    // If the character is uppercase, we need to transform it to
                    // uppercase since cipher only works with lowercase
                    // characters.

                    res = res + Character.toUpperCase(cipher(c));
                } else {
                    // If the character is lowercase, we cipher it.

                    res = res + cipher(c);
                }
            } else {
                // If the character is not a letter, we don't transform it.

                res = res + c;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result;
        in.close();

        result = caesarCipher(s, k);

        // Prints output
        System.out.println(result);
    }
}
