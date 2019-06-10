/*
 * Sherlock considers a string to be valid if all characters of the string
 * appear the same number of times. It is also valid if he can remove just '1'
 * character at '1' index in the string, and the remaining characters will occur
 * the same number of times. Given a string 's', determine if it is valid. If
 * so, return "YES", otherwise return "NO".
 *
 * For example, if 's = abc', it is a valid string because frequencies are
 * '{a: 1, b: 1, c: 1}'. So is 's = abcc' because we can remove one 'c' and have
 * '1' of each character in the remaining string. If 's = abccc' however, the
 * string is not valid as we can only remove '1' occurrence of 'c'. That would
 * leave character frequencies of '{a: 1, b: 1, c: 2}'.
 *
 * Function Description
 *
 * Complete the 'isValid' function in the editor below. It should return either
 * the string "YES" or the string "NO".
 *
 * 'isValid' has the following parameter(s):
 *
 *   * 's': a string.
 *
 * Input Format
 *
 * A single string 's'.
 *
 * Constraints
 *
 * 1 <= |s| <= 10^5
 *
 * * Each character 's[i]' belongs to ascii[a-z].
 *
 * Output Format
 *
 * Print "YES" if string 's' is valid, otherwise, print "NO".
 *
 * Sample Input 0
 *
 * aabbcd
 *
 * Sample Output 0
 *
 * NO
 *
 * Explanation 0
 *
 * Given "s = aabbcd", we would need to remove two characters, both 'c' and 'd'
 * -> "aabb" or 'a' and 'b' -> "abcd", to make it valid. We are limited to
 * removing only one character, so 's' is invalid.
 *
 * Sample Input 1
 *
 * aabbccddeefghi
 *
 * Sample Output 1
 *
 * NO
 *
 * Explanation 1
 *
 * Frequency counts for the letters are as follows:
 *
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * There are two ways to make the valid string:
 *
 *   * Remove '4' characters with a frequency of '1': '{fghi}'.
 *
 *   * Remove '5' characters with a frequency of '2': '{abcde}'.
 *
 * Neither of these is an option.
 *
 * Sample Input 2
 *
 * abcdefghhgfedecba
 *
 * Sample Output 2
 *
 * YES
 *
 * Explanation 2
 *
 * All characters occur twice except for 'e' which occurs '3' times. We can
 * delete one instance of 'e' to have a valid string.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static void creatingCounts(String s,
                                       HashMap<Character, Integer> charCounts,
                                       HashMap<Integer, Integer> diffCounts) {

        // Loops through the characters of the input string.
        // Updates the frequency of each character seen, using 'charCounts'.
        // Also updates a "count of counts", using 'diffCounts'.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = charCounts.containsKey(c) ? charCounts.get(c) + 1 : 1;

            charCounts.put(c, count);

            if (!diffCounts.containsKey(count - 1)) {
                // If the previous count of the current character was zero, '0'.
                int newCount = diffCounts.containsKey(count) ?
                               diffCounts.get(count) + 1 : 1;

                diffCounts.put(count, newCount);
            } else {
                // There are other counts equal to the previous count of the
                // current character.
                int prevCount = diffCounts.get(count - 1) - 1;
                int newCount = diffCounts.containsKey(count) ?
                               diffCounts.get(count) + 1 : 1;

                if (0 < prevCount) {
                    diffCounts.put(count - 1, prevCount);
                } else if (0 == prevCount) {
                    diffCounts.remove(count - 1);
                }
                diffCounts.put(count, newCount);
            }
        }
    }

    public static String isValid(String s) {
        String res = "NO";
        HashMap<Integer, Integer> diffCounts = new HashMap<>();
        HashMap<Character, Integer> charCounts = new HashMap<>();

        creatingCounts(s, charCounts, diffCounts);

        if (diffCounts.size() == 1) {
            // All characters have the same frequency.
            res = "YES";
        } else if (diffCounts.size() == 2) {
            // All characters except one should have the same frequency.
            boolean found = false;
            int[] keys    = new int[2];
            int[] values  = new int[2];

            for (Map.Entry<Integer, Integer> entry : diffCounts.entrySet()) {
                if (entry.getValue() == 1) {
                    // If there's a count with count of one; '1', we keep it in
                    // a special location..
                    keys[1] = entry.getKey();
                    values[1] = entry.getValue();
                    found = true;
                } else {
                    keys[0] = entry.getKey();
                    values[0] = entry.getValue();
                }
            }

            if (found && (keys[1] == 1 || Math.abs(keys[0] - keys[1]) == 1)) {
                // All distinct characters in the string but one have the same
                // count.
                res = "YES";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result;
        in.close();

        result = isValid(s);

        // Prints output
        System.out.println(result);
    }
}
