/*
 * In computer science, a set is an abstract data type that can store certain
 * values, without any particular order, and no repeated values (Wikipedia).
 * {1, 2, 3} is an example of a set, but {1, 2, 2} is not a set. Today you will
 * learn how to use sets in java by solving this problem.
 *
 * You are given 'n' pairs of strings. Two pairs (a, b) and (c, d) are identical
 * if a = c and b = d. That also implies (a, b) is 'not' same as (b, a). After
 * taking each pair as input, you need to print the number of unique pairs you
 * currently have.
 *
 * Complete the code in the editor to solve this problem.
 *
 * Input Format
 *
 * In the first line, there will be an integer 'T' denoting the number of pairs.
 * Each of the next 'T' lines will contain two strings separated by a single
 * space.
 *
 * Constraints
 *
 * 1 <= T <= 100000
 *
 * Length of each string is at most 5 and will consist of lower case letters
 * only.
 *
 * Output Format
 *
 * Print 'T' lines. In the i-th line, print the number of unique pairs you have
 * after taking i-th pair as input.
 *
 * Sample Input
 *
 * 5
 * john tom
 * john mary
 * john tom
 * mary anna
 * mary anna
 *
 * Sample Output
 *
 * 1
 * 2
 * 2
 * 3
 * 3
 *
 * Explanation
 *
 * After taking the first input, you have only one pair: (john, tom).
 * After taking the second input, you have two pairs: (john, tom) and
 * (john, mary).
 * After taking the third input, you still have two unique pairs.
 * After taking the fourth input, you have three unique pairs: (john, tom),
 * (john, mary) and (mary, anna).
 * After taking the fifth input, you still have three unique pairs.
 */

import java.util.Scanner;
import java.util.HashSet;

public class JavaHashSet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] res = new int[T];
        String[] pair_left = new String[T];
        String[] pair_right = new String[T];
        HashSet<String> mySet = new HashSet<String>();
        in.nextLine();

        // Keeps all input pairs in memory (Code by this challenge's author)
        for (int i = 0; i < T; i++) {
            pair_left[i] = in.next();
            pair_right[i] = in.next();
        }
        in.close();

        // Set up the element pair and adds it to the set
        for (int i = 0; i < T; i++) {
            String elem = pair_left[i] + ", " + pair_right[i];
            mySet.add(elem);
            res[i] = mySet.size();
        }

        // Prints how many unique pairs we have after processing each input pair
        for (int i : res) {
            System.out.println(i);
        }
    }
}
