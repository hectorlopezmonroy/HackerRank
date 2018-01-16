/*
 * "In computing, End Of File (commonly abbreviated EOF) is a condition in a
 * computer operating system where no more data can be read from a data source."
 * - (Wikipedia: End-of-file)
 *
 * The here is to read 'n' lines of input until you reach EOF, then number and
 * print all 'n' lines of content.
 *
 * Hint: Java's Scanner.hasNext() method is helpful for this problem.]
 *
 * Input Format
 *
 * Read some unknown 'n' lines of input from stdin(System.in) until you reach
 * EOF; each line of input contains a non-empty String.
 *
 * Output Format
 *
 * For each line, print the line number, followed by a single space, and then
 * the line content received as input.
 *
 * Sample Input
 *
 * Hello World
 * I am a file
 * Read me until end-of-file.
 *
 * Sample Output
 *
 * 1 Hello World
 * 2 I am a file
 * 3 Read me until end-of-file.
 */

import java.util.Scanner;
import java.util.LinkedList;

public class JavaEndOfFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<String> myList = new LinkedList<String>();

        while (in.hasNext()) {
            myList.add(in.nextLine());
        }
        in.close();
        for (int i = 0; i < myList.size();i++) {
            System.out.println((i + 1) + " " + myList.get(i));
        }
    }
}
