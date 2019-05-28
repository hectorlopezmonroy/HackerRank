/*
 * Java has 8 primitive data types; char, boolean, byte, short, int, long,
 * float, and double. For this exercise, we'll work with the primitives used to
 * hold integer values (byte, short, int, and long):
 *
 *   * A byte is an 8-bit signed integer.
 *
 *   * A short is a 16-bit signed integer.
 *
 *   * An int is a 32-bit signed integer.
 *
 *   * A long is a 64-bit signed integer.
 *
 * Given an input integer, you must determine which primitive data types are
 * capable of properly storing that input.
 *
 * To get you started, a portion of the solution is provided for you in the
 * editor.
 *
 * Reference:
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 *
 * Input Format
 *
 * The first line contains an integer, 'T', denoting the number of test cases.
 * Each test case, is comprised of a single line with an integer, 'n', which can
 * be arbitrarily large or small.
 *
 * Output Format
 *
 * For each input variable 'n' and appropriate primitive 'dataType', you must
 * determine if the given primitives are capable of storing it. If yes, then
 * print:
 *
 * n can be fitted in:
 * * dataType
 *
 * If there is more than one appropriate data type, print each one on its own
 * line and order them by size (i.e.: byte < short < int < long).
 *
 * If the number cannot be stored in one of the four aforementioned primitives,
 * print the line:
 *
 * n can't be fitted anywhere.
 *
 * Sample Input
 *
 * 5
 * -150
 * 150000
 * 1500000000
 * 213333333333333333333333333333333333
 * -100000000000000
 *
 * Sample Output
 *
 * -150 can be fitted in:
 * * short
 * * int
 * * long
 * 150000 can be fitted in:
 * * int
 * * long
 * 1500000000 can be fitted in:
 * * int
 * * long
 * 213333333333333333333333333333333333 can't be fitted anywhere.
 * -100000000000000 can be fitted in:
 * * long
 *
 * Explanation
 *
 * -150 can be stored in a short, an int, or a long.
 * 213333333333333333333333333333333333 is very large and is outside of the
 * allowable range of values for the primitive data types discussed in this
 * problem.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.LinkedList;

class Pair {
    public String num;
    public byte datatypesRep;
}

public class JavaDatatypes {

    public static void printResults(LinkedList<Pair> datatypesList) {
        for (Pair p: datatypesList) {
            if ((byte) p.datatypesRep == (byte) 0) {
                System.out.println(p.num + " can't be fitted anywhere.");
            } else if ((byte) p.datatypesRep == (byte) 8) {
                System.out.println(p.num + " can be fitted in:");
                System.out.println("* long");
            } else if ((byte) p.datatypesRep == (byte) 12) {
                System.out.println(p.num + " can be fitted in:");
                System.out.println("* int");
                System.out.println("* long");
            } else if ((byte) p.datatypesRep == (byte) 14) {
                System.out.println(p.num + " can be fitted in:");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            } else if ((byte) p.datatypesRep == (byte) 15) {
                System.out.println(p.num + " can be fitted in:");
                System.out.println("* byte");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        LinkedList<Pair> res = new LinkedList<Pair>();

        for (int i = 0; i < T; i++) {
            byte b = 0;
            String s = in.next();
            Pair tmp = new Pair();

            try {
                /* In order to represent which datatypes can store string s'
                 * numerical value, we use a byte in a similar fashion to the
                 * files permissions representation in linux (octal numbers).
                 *
                 * An integer that can be stored as a byte (the smallest size)
                 * can also be stored in a short, an int and a long. But not
                 * necessarily an integer that can be stored in a long fits in
                 * a byte. Therefore, the order is
                 * long  (2^3),
                 * int   (2^2),
                 * short (2^1),
                 * byte  (2^0).
                 */

                long l = Long.parseLong(s);
                if (-Math.pow(2,7) <= l && l <= Math.pow(2,7) - 1 ) {
                    /* If s can be fitted in a byte, then it can also be fitted
                     * in a short, int and long.
                     */
                    b = 15; // 2^3 + 2^2 + 2^1 + 2^0
                } else if (-Math.pow(2,15) <= l && l <= Math.pow(2,15) - 1) {
                    /* If s can't be fitted in a byte, but it can be fitted in a
                     * short, then it can also be fitted in an int and long.
                     */
                    b = 14; // 2^3 + 2^2 + 2^1
                } else if (-Math.pow(2,31) <= l && l <= Math.pow(2,31) - 1) {
                    /* If s can't be fitted in a byte nor a short, but it can be
                     * fitted in an int then it can also be fitted in a long.
                     */
                    b = 12; // 2^3 + 2^2
                } else if (-Math.pow(2,63) <= l && l <= Math.pow(2,63) - 1) {
                    /* If s can't be fitted in a byte, short, int, but it can be
                     * fitted in a long.
                     */
                    b = 8;  // 2^3
                }
            } catch (NumberFormatException e) {
                // If s can't be parsed as a long.
                b = 0;
            }
            tmp.num = s;
            tmp.datatypesRep = b;
            res.add(tmp);
        }
        in.close();

        // Prints output
        printResults(res);
    }
}
