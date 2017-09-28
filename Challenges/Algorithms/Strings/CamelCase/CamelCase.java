/*
 * Alice wrote a sequence of words in CamelCase as a string of letters, s,
 * having the following properties:
 *
 *  * It is a concatenation of one or more words consisting of English letters.
 *
 *  * All letters in the first word are lowercase.
 *
 *  * For each of the subsequent words, the first letter is uppercase and the
 *    rest of the letters are lowercase.
 *
 * Given s, print the number of words in s on a new line.
 *
 * Input Format
 *
 * A single line containing string s.
 *
 * Constraints
 *
 * 1 <= |s| <= 10^5
 *
 * Output Format
 *
 * Print the number of words in string s.
 *
 * Sample Input
 *
 * saveChangesInTheEditor
 *
 * Sample Output
 *
 * 5
 *
 * Explanation
 *
 * String s contains five words:
 *
 * 1. save
 * 2. Changes
 * 3. In
 * 4. The
 * 5. Editor
 *
 * Thus, we print 5 on a new line.
 */

import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int wordsCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                wordsCount++;
            }
        }
        in.close();
        System.out.println(wordsCount);
    }
}
