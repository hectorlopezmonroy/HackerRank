/*
 * Alice has a string of the form x+y or x-y. Here, x and y are single-digit
 * nonnegative integers. Her task is to perform the addition or subtraction
 * accordingly and print the result.
 *
 * As a newbie programmer, Alice is struggling to finish the task. Can you help
 * her?
 *
 * Input Format
 *
 * In a single line, you will be given the string.
 *
 * Constraints
 *
 * The string contains exactly 3 characters of the form x+y or x-y.
 * 0 <= x, y <= 9
 *
 * Output Format
 *
 * In a single line, print the result of the operation.
 *
 * Sample Input 0
 *
 * 0+1
 *
 * Sample Output 0
 *
 * 1
 *
 * Sample Input 1
 *
 * 0-3
 *
 * Sample Output 1
 *
 * -3
 */

import java.util.Scanner;

public class ASmallStepTowardCalculators {

    public static int solve(String opr) {
        int res = 0;

        if (opr.charAt(1) == '+') {
            res = Integer.valueOf(Character.toString(opr.charAt(0)))
                    + Integer.valueOf(Character.toString(opr.charAt(2)));
        } else {
            res = Integer.valueOf(Character.toString(opr.charAt(0)))
                    - Integer.valueOf(Character.toString(opr.charAt(2)));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opr = in.next();
        int result = solve(opr);

        System.out.println(result);
        in.close();
    }
}
