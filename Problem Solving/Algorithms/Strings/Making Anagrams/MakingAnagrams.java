/*
 * We consider two strings to be anagrams of each other if the first string's
 * letters can be rearranged to form the second string. In others words, both
 * strings must contain the same exact letters in he same exact frequency. For
 * example, 'bacdc' and 'dcbac' are anagrams, but 'bacdc' and 'dcbad' are not.
 *
 * Alice is taking a cryptography class and finding anagrams to be very useful.
 * She decides on an encryption scheme involving two large strings where
 * encryption is dependent on the minimum number of character deletions required
 * to make the two strings anagrams. Can you help her find this number?
 *
 * Given two strings, 's1' and 's2', that may not be of the same length,
 * determine the minimum number of character deletions required to make 's1' and
 * 's2' anagrams. Any characters can be deleted from either of the strings.
 *
 * For example, 's1 = abc' and 's2 = amnop'. The only characters that match are
 * the 'a's so we have to remove 'bc' from 's1' and 'mnop' from 's2' for a total
 * of '6' deletions.
 *
 * Function Description
 *
 * Complete the 'makingAnagrams' function in the editor below. It should return
 * an integer representing the minimum number of deletions needed to make the
 * strings anagrams.
 *
 * 'makingAnagrams' has the following parameter(s):
 *
 *   * 's1': a string.
 *
 *   * 's2': a string.
 *
 * Input Format
 *
 * The first line contains a single string, 's1'.
 *
 * The second line contains a single string, 's2'.
 *
 * Constraints
 *
 * 1 <= |s1|, |s2| <= 10^4
 *
 * It is guaranteed that 's1' and 's2' consist of lowercase English letters,
 * ascii[a-z].
 *
 * Output Format
 *
 * Print a single integer denoting the minimum number of characters which must
 * be deleted to make the two strings anagrams of each other.
 *
 * Sample Input
 *
 * cde
 * abc
 *
 * Sample Output
 *
 * 4
 *
 * Explanation
 *
 * We delete the following characters from our two strings to turn them into
 * anagrams of each other:
 *
 *   1.- Remove 'd' and 'e' from 'cde' to get 'c'.
 *
 *   2.- Remove 'a' and 'b' from 'abc' to get 'c'.
 *
 * We had to delete '4' characters to make both strings anagrams.
 */

import java.util.HashMap;
import java.util.Scanner;

public class MakingAnagrams {

    private static HashMap<Character, Integer> setCharCounts(String s) {
        HashMap<Character, Integer> res = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int charCount = 0;
            char c = s.charAt(i);

            if (res.containsKey(c)) {
                charCount = res.get(c) + 1;
            } else {
                charCount = 1;
            }
            res.put(c, charCount);
        }
        return res;
    }

    public static int makingAnagrams(String s1, String s2) {
        int res = 0;
        String longest = s1.length() > s2.length() ? s1 : s2;
        String shortest = s1.equals(longest) ? s2 : s1;
        HashMap<Character, Integer> countStr1 = setCharCounts(s1);
        HashMap<Character, Integer> countStr2 = setCharCounts(s2);

        for (int i = 0; i < longest.length(); i++) {
            char c = longest.charAt(i);
            int charCountStr1 = countStr1.containsKey(c) ? countStr1.get(c) : 0;
            int charCountStr2 = countStr2.containsKey(c) ? countStr2.get(c) : 0;

            if (charCountStr1 != charCountStr2) {
                res += Math.max(charCountStr1, charCountStr2) -
                       Math.min(charCountStr1, charCountStr2);
            }
            countStr1.remove(c);
            countStr2.remove(c);
        }

        for (int i = 0; i < shortest.length(); i++) {
            char c = shortest.charAt(i);

            if (shortest.equals(s1) &&
                !countStr2.containsKey(c) && countStr1.containsKey(c)) {
                res += countStr1.get(c);
                countStr1.remove(c);
            } else if (shortest.equals(s2) &&
                       !countStr1.containsKey(c) && countStr2.containsKey(c)) {
                res += countStr2.get(c);
                countStr2.remove(c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = 0;
        in.close();

        result = makingAnagrams(s1, s2);

        // Prints output
        System.out.println(result);
    }
}
