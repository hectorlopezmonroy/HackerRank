/*
 * You are given a program written on Simple Language. There's only one variable
 * called 'x' in this programming language. Initially, x = 0. The program
 * consists of 'n' lines. Each line is one of the following:
 *
 *   * add y ('y' is an integer) -- add 'y' to 'x'.
 *
 *   * set y ('y' is an integer) -- set the value of 'x' to 'y'.
 *
 * Here's an example program and also illustrates what happens to 'x' after
 * running each line:
 *
 *          x = 0
 *   add 5
 *          x = 5
 *   add -3
 *          x = 2
 *   set 1
 *          x = 1
 *   add -2
 *          x = -1
 *   add 5
 *          x = 4
 *
 * Given a program, your task is to remove some lines (possibly none or all of
 * them) in such way that the value of 'x' after running the resulting program
 * will be the maximum. Find this maximum value.
 *
 * Complete the function 'maximumProgramValue' which takes in an integer 'n'
 * denoting the number of lines of the program and returns the maximum value.
 * You will need to take the program's lines from the standard input.
 *
 * Input Format
 *
 * The first line contains a single integer 'n'.
 *
 * The next 'n' lines describe the program. Each of these lines contains a
 * string 't' and an integer 'y' separated by a space, where t = add or t = set.
 *
 * Constraints
 *
 * 1 <= n <= 2 * 10^5
 *
 * -10^9 <= y <= 10^9
 *
 * Output Format
 *
 * Print a single integer denoting the answer.
 *
 * Sample Input 0
 *
 * 3
 * add 2
 * set 1
 * add -1
 *
 * Sample Output 0
 *
 * 2
 *
 * Explanation 0
 *
 * In this test case, the second and third lines of code are removed.
 *
 * Sample Input 1
 *
 * 2
 * set 5
 * add 6
 *
 * Sample Output 1
 *
 * 11
 *
 * Explanation 1
 *
 * In this test case, no line of code is removed.
 *
 * Sample Input 2
 *
 * 3
 * add -1
 * set -3
 * add -2
 *
 * Sample Output 2
 *
 * 0
 *
 * Explanation 2
 *
 * In this test case, all lines of code are removed.
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.Scanner;
import java.io.IOException;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static long maximumProgramValue(int n) {
        long res = 0;

        while (n-- > 0) {
            String[] line = scanner.nextLine().split(" ");

            if (line[0].equals("add")) {
                if (Integer.valueOf(line[1]) + res > res) {
                    res = res + Integer.valueOf(line[1]);
                }
            } else if (line[0].equals("set")) {
                if (Integer.valueOf(line[1]) > res) {
                    res = Integer.valueOf(line[1]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            long result = maximumProgramValue(n);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
