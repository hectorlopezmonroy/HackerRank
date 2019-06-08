/*
 * Given two strings, determine if they share a common substring. A substring
 * may be as small as one character.
 *
 * For example, the words "a", "and", "art" share the common substring 'a'. The
 * words "be" and "cat" do not share a substring.
 *
 * Function Description
 *
 * Complete the function 'twoStrings' in the editor below. It should return a
 * string, either "YES" or "NO" based on whether the strings share a common
 * substring.
 *
 * 'twoStrings' has the following parameter(s):
 *
 *   * 's1', 's2': two strings to analyze.
 *
 * Input Format
 *
 * The first line contains a single integer 'p', the number of test cases.
 *
 * The following 'p' pairs of lines are as follows:
 *
 *   * The first line contains string 's1'.
 *
 *   * The second line contains string 's2'.
 *
 * Constraints
 *
 * For each pair of strings, return "YES" or "NO".
 *
 * Sample Input
 *
 * 2
 * hello
 * world
 * hi
 * world
 *
 * Sample Output
 *
 * YES
 * NO
 *
 * Explanation
 *
 * We have 'p = 2' pairs to check:
 *
 *   1.- 's1 = "hello", s2 = "world"'. The substrings "o" and "l" are common to
 *       both strings.
 *
 *   2.- 's1 = "hi", s2 = "world"'. 's1' and 's2' share no common substrings.
 */

import java.util.HashMap;
import java.util.Scanner;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        char c;
        String res = "NO";
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            c = s1.charAt(i);
            int count = charCounts.containsKey(c) ? charCounts.get(c) : 0;

            charCounts.put(c, count++);
        }

        for (int i = 0; i < s2.length(); i++) {
            c = s2.charAt(i);

            if (charCounts.containsKey(c)) {
                res = "YES";
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;
        int p = in.nextInt();
        String[] results = new String[p];

        // Process input
        for (int i = 0; i < p; i++) {
            s1 = in.next();
            s2 = in.next();

            results[i] = twoStrings(s1, s2);
        }
        in.close();

        // Prints output
        for (String res : results) {
            System.out.println(res);
        }
    }
}
