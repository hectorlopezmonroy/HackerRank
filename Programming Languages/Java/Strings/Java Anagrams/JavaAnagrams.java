/*
 * Two strings, 'a' and 'b', are called anagrams if they contain all the same
 * characters in the same frequencies. For example, the anagrams of "CAT" are
 * "CAT", "ACT", "TAC", "TCA", "ATC", and "CTA".
 *
 * Complete the function in the editor. If 'a' and 'b' are case-insensitive
 * anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.
 *
 * Input Format
 *
 * The first line contains a string denoting 'a'.
 * The second line contains a string denoting 'b'.
 *
 * Constraints
 *
 * 1 <= length(a), length(b) <= 50
 *
 * Strings 'a' and 'b' consist of English alphabetic characters.
 *
 * The comparison should NOT be case sensitive.
 *
 * Output Format
 *
 * Print "Anagrams" if 'a' and 'b' are case-insensitive anagrams of each other;
 * otherwise, print "Not Anagrams" instead.
 *
 * Sample Input 0
 *
 * anagram
 * margana
 *
 * Sample Output 0
 *
 * Anagrams
 *
 * Explanation 0
 *
 * Character    Frequency: anagram  Frequency: margana
 *  A or a              3                   3
 *  G or g              1                   1
 *  N or n              1                   1
 *  M or m              1                   1
 *  R or r              1                   1
 *
 * The two strings contain all the same letters in the same frequencies, so we
 * print "Anagrams".
 *
 * Sample Input 1
 *
 * anagramm
 * marganaa
 *
 * Sample Output 1
 *
 * Not Anagrams
 *
 * Explanation 1
 *
 * Character    Frequency: anagram  Frequency: margana
 *  A or a              3                   4
 *  G or g              1                   1
 *  N or n              1                   1
 *  M or m              2                   1
 *  R or r              1                   1
 *
 * The two strings don't contain the same number of a's and m's, so we print
 * "Not Anagrams".
 *
 * Sample Input 2
 *
 * Hello
 * hello
 *
 * Sample Output 2
 *
 * Anagrams
 *
 * Explanation 2
 *
 * Character    Frequency: anagram  Frequency: margana
 *  E or e              1                   1
 *  H or h              1                   1
 *  L or l              2                   2
 *  O or o              1                   1
 *
 * The two strings contain all the same letters in the same frequencies, so we
 * print "Anagrams".
 */

import java.util.Scanner;
import java.util.HashMap;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        boolean res = false;
        HashMap<Character, Integer> myMap = new HashMap<>();

        if (a.length() == b.length()) {
            /* Loops through the first input string. For each character it finds
             * either adds it to the map of characters and their count or
             * updates the count for that character.
             */
            for (int i = 0; i < a.length(); i++) {
                char c = Character.toLowerCase(a.charAt(i));
                if (myMap.containsKey(c)) {
                    // Updates this character's count
                    myMap.put(c, myMap.get(c) + 1);
                } else {
                    // Newly found character
                    myMap.put(c, 1);
                }
            }

            /* Loops through the second input string. For each character it
             * finds either removes it completely from the map of characters and
             * their count (this character count == 1) or decreases the count
             * for that character.
             */
            for (int i = 0; i < b.length(); i++) {
                char c = Character.toLowerCase(b.charAt(i));
                if (myMap.containsKey(c)) {
                    if (myMap.get(c) > 1) {
                        // Decreases this character's count
                        myMap.put(c, myMap.get(c) - 1);
                    } else if (myMap.get(c) == 1) {
                        // Removes this character's count
                        myMap.remove(c);
                    }
                } else {
                    /* This character isn't in input string 'a' or they count is
                     * different. Therefore, 'a' and 'b' are not anagrams.
                     */
                    res = false;
                    break;
                }
            }

            if (myMap.size() == 0) {
                /* All characters found in 'a' were also found in string 'b' and
                 * their count is the same. 'a' and 'b' are anagrams.
                 */
                res = true;
            } else {
                /* The count of the characters from 'a' is different than those
                 * in 'b'. 'a' and 'b' aren't anagrams.
                 */
                res = false;
            }
        } else {
            // Input strings have different lenghts. They can't be anagrams.
            res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        boolean ret = isAnagram(a, b);

        // Prints output
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
