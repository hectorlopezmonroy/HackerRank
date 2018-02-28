/*
 * Sometimes it's better to use dynamic size arrays. Java's Arraylist can
 * provide you this feature. Try to solve this problem using Arraylist.
 *
 * You are given 'n' lines. In each line there are zero or more integers. You
 * need to answer a few queries where you need to tell the number located in
 * y-th position of x-th line.
 *
 * Take your input from System.in.
 *
 * Input Format
 *
 * The first line has an integer 'n'. In each of the next 'n' lines there will
 * be an integer 'd' denoting the number of integers on that line and then there
 * will be 'd' space-separated integers. In the next line there will be an
 * integer 'q' denoting number of queries. Each query will consist of two
 * integers 'x' and 'y'.
 *
 * Constraints
 *
 * 1 <= n <= 20000
 *
 * 0 <= d <= 50000
 *
 * 1 <= q <= 1000
 *
 * 1 <= x <= n
 *
 * Each number will fit in signed integer.
 * Total number of integers in 'n' lines will not cross 10^5.
 *
 * Output Format
 *
 * In each line, output the number located in y-th position of x-th line. If
 * there is no such position, just print "ERROR!".
 *
 * Sample Input
 *
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 *
 * Sample Output
 *
 * 74
 * 52
 * 37
 * ERROR!
 * ERROR!
 */

import java.util.Scanner;
import java.util.ArrayList;

public class JavaArrayList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = 0;
        int n = in.nextInt();
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();

        // First we must save the 'n' lines
        for (int i = 0; i < n; i++) {
            int d = in.nextInt();
            ArrayList<Integer> line = new ArrayList<Integer>();

            // Saving the 'd' elements of each line
            for (int j = 0; j < d; j++) {
                line.add(in.nextInt());
            }
            lines.add(line);
        }

        q = in.nextInt();
        // Saving the 'q' queries
        for (int i = 0; i < q; i++) {
            int x = in.nextInt() - 1; // Note the queries first index is 1 but
            int y = in.nextInt() - 1; // Java's ArrayList first index is 0.

            if (0 <= x && x < lines.size() &&
                0 <= y && y < lines.get(x).size()) {
                res.add(lines.get(x).get(y).toString());
            } else {
                res.add("ERROR!");
            }
        }
        in.close();

        // Prints output as requested
        for (String s : res) {
            System.out.println(s);
        }
    }
}
