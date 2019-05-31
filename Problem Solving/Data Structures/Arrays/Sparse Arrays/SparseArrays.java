/*
 * There is a collection of input strings and a collection of query strings. For
 * each query string, determine how many times it occurs in the list of input
 * strings.
 *
 * For example, given input 'strings = ['ab', 'ab', 'abc']' and
 * 'queries = ['ab, 'abc', 'bc']', we find '2' instances of 'ab', '1' of 'abc'
 * and '0' of 'bc'. For each query, we add an element to our return array,
 * 'results = [2, 1, 0]'.
 *
 * Function Description
 *
 * Complete the function 'matchingStrings' in the editor below. The function
 * must return an array of integers representing the frequency of occurrence of
 * each 'query' string in 'strings'.
 *
 * 'matchingStrings' has the following parameter(s):
 *
 *   * 'strings': an array of strings to search.
 *
 *   * 'queries': an array of query strings.
 *
 * Input Format
 *
 * The first line contains an integer 'n', the size of 'strings'.
 *
 * Each of the next 'n' lines contains a string 'strings[i]'.
 *
 * The next line contains 'q', the size of 'queries'.
 *
 * Each of the next 'q' lines contains a string 'q[i]'.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= q <= 1000
 *
 * 1 <= |strings[i]|, |queries[i]| <= 20
 *
 * Output Format
 *
 * Return an integer array of the results of all queries in order.
 *
 * Sample Input 0
 *
 * 4
 * aba
 * baba
 * aba
 * xzxb
 * 3
 * aba
 * xzxb
 * ab
 *
 * Sample Output 0
 *
 * 2
 * 1
 * 0
 *
 * Explanation 0
 *
 * Here, "aba" occurs twice, in the first and third string. The string "xzxb"
 * occurs once in the fourth string, and "ab" does not occur at all.
 *
 * Sample Input 1
 *
 * 3
 * def
 * de
 * fgh
 * 3
 * de
 * lmn
 * fgh
 *
 * Sample Output 1
 *
 * 1
 * 0
 * 1
 *
 * Sample Input 2
 *
 * 13
 * abcde
 * sdaklfj
 * asdjf
 * na
 * basdn
 * sdaklfj
 * asdjf
 * na
 * asdjf
 * na
 * basdn
 * sdaklfj
 * asdjf
 * 5
 * abcde
 * sdaklfj
 * asdjf
 * na
 * basdn
 *
 * Sample Output 2
 *
 * 1
 * 3
 * 4
 * 3
 * 2
 */

import java.util.HashMap;
import java.util.Scanner;

public class SparseArrays {

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] res = new int[queries.length];
        HashMap<String, Integer> stringsCount = new HashMap<>();

        for (String s : strings) {
            int count;

            if (stringsCount.containsKey(s)) {
                count = stringsCount.get(s) + 1;
            } else {
                count = 1;
            }
            stringsCount.put(s, count);
        }

        for (int i = 0; i < queries.length; i++) {
            if (stringsCount.containsKey(queries[i])) {
                res[i] = stringsCount.get(queries[i]);
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n];
        String[] queries;
        int[] result;
        int q;

        // Process input
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        q = in.nextInt();
        queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = in.next();
        }
        in.close();

        result = matchingStrings(strings, queries);

        // Prints output
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
