/*
 * Objective
 * Today we're expanding our knowledge of Strings and combining it with what
 * we've already learned about loops. Check out the Tutorial tab for learning
 * materials and an instructional video!
 *
 * Task
 * Given a string, S, of length N that is indexed from 0 to N - 1, print its
 * even-indexed and odd-indexed characters as 2 space-separated strings on a
 * single line (see the Sample below for more detail).
 *
 * Note: 0 is considered to be an even index.
 *
 * Input Format
 *
 * The first line contains an integer, T (the number of test cases).
 * Each line i of the T subsequent lines contain a String, S.
 *
 * Constraints
 *
 * 1 <= T <= 10
 *
 *  2 <= length of S <= 10000
 *
 * Output Format
 *
 * For each String S_j (where 0 <= j <= T - 1), print S_j's even-indexed
 * characters, followed by a space, followed by S_j's odd-indexed characters.
 *
 * Sample Input
 *
 * 2
 * Hacker
 * Rank
 *
 * Sample Output
 *
 * Hce akr
 * Rn ak
 *
 * Explanation
 *
 * Test Case 0: S = "Hacker"
 * S[0] = 'H'
 * S[1] = 'a'
 * S[2] = 'c'
 * S[3] = 'k'
 * S[4] = 'e'
 * S[5] = 'r'
 *
 * The even indices are 0, 2, and 4, and the odd indices are 1, 3, and 5. We
 * then print a single line of 2 space-separated strings; the first string
 * contains the ordered characters from S' even indices (Hce), and the second
 * string contains the ordered characters from S' odd indices (akr).
 *
 * Test Case 1/; S = "Rank"
 * S[0] = 'R'
 * S[1] = 'a'
 * S[2] = 'n'
 * S[3] = 'k'
 *
 * The even indices are 0 and 2, and the odd indices are 1 and 3. We then print
 * a single line of 2 space-separated strings; the first string contains the
 * ordered characters from S' even indices (Rn), and the second string contains
 * the ordered characters from S' odd indices (ak).
 */

import java.util.Scanner;

public class LetsReview {

    public static String splitEvenAndOddChars(String word) {
        String res = "";
        String odd = "";
        String even = "";

        // Loops through the word's length
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                // Even characters
                even = even + word.charAt(i);
            } else {
                // Odd characters
                odd = odd + word.charAt(i);
            }
        }
        res = even + " " + odd;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] res = new String[T];

        // Process input
        for (int i = 0; i < T; i++) {
            String word = in.next();
            res[i] = splitEvenAndOddChars(word);
        }
        in.close();

        // Prints output
        for (String s : res) {
            System.out.println(s);
        }
    }
}
