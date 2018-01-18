/*
 * Static initialization blocks are executed when the class is loaded, and you
 * can initialize static variables in those blocks.
 *
 * It's time to test your knowledge of 'Static initialization blocks'. You can
 * read about it here:
 *          https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
 *
 * You are given a class 'JavaStaticInitializerBlock' with a main method.
 * Complete the given code so that it outputs the area of a parallelogram with
 * breadth 'B' and heigth 'H'. You should read the variables from the standard
 * input.
 *
 * If B <= 0 or H <= 0, the output should be "java.lang.Exception: Breadth and
 * heigth must be positive" without quotes.
 *
 * Input Format
 *
 * There are two lines of input. The first line contains 'B': the breadth of the
 * parallelogram. The next line contains 'H': the height of the parallelogram.
 *
 * Constraints
 *
 * -100 <= B <= 100
 *
 * -100 <= H <= 100
 *
 * Output Format
 *
 * If both values are greater than zero, then the 'main' method must output the
 * area of the 'parallelogram'. Otherwise, print "java.lang.Exception: Breadth
 * and height must be positive" without quotes.
 *
 * Sample Input 0
 *
 * 1
 * 3
 *
 * Sample Output 0
 *
 * 3
 *
 * Sample Input 1
 *
 * -1
 * 2
 *
 * Sample Output 1
 *
 * java.lang.Exception: Breadth and height must be positive
 */

import java.util.Scanner;

public class JavaStaticInitializerBlock {

    public static int B = 0;
    public static int H = 0;
    public static boolean flag = false;

    static {
        Scanner in = new Scanner(System.in);
        B = in.nextInt();
        H = in.nextInt();
        in.close();

        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be"
                                + " positive");
        } else {
            flag = true;
        }

    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.println(area);
        }
    }
}
