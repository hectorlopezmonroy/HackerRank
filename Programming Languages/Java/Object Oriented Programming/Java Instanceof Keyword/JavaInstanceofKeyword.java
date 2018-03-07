/*
 * The Java 'instanceof' operator is used to test if the object or instance is
 * an instanceof the specified type.
 *
 * In this problem we have given you three classes in the editor:
 *
 *   * Student class
 *   * Rockstar class
 *   * Hacker class
 *
 * In the main method, we populated an 'ArrayList' with several instances of
 * these classes. 'count' method calculates how many instances of each type is
 * present in the ArrayList. The code prints three integers, the number of
 * instances of Student class, the number of instances of Rockstar class, and
 * the number of instances of Hacker class.
 *
 * But some lines of the code are missing, and you have to fix it by modifying
 * only 3 lines! Don't add, delete or modify any extra line.
 *
 * Sample Input
 *
 * 5
 * Student
 * Student
 * Rockstar
 * Student
 * Hacker
 *
 * Sample Output
 *
 * 3 1 1
 */

import java.util.Scanner;
import java.util.ArrayList;

class Hacker {}
class Student {}
class Rockstar {}

public class JavaInstanceofKeyword {

    @SuppressWarnings({ "unchecked" })
    static String count(ArrayList myList) {
        int a = 0;
        int b = 0;
        int c = 0;
        String ret = "";

        for (int i = 0; i < myList.size(); i++) {
            Object element = myList.get(i);

            if (element instanceof Student) {
                a++;
            }
            if (element instanceof Rockstar) {
                b++;
            }
            if (element instanceof Hacker) {
                c++;
            }
        }
        ret = Integer.toString(a) + " " +
              Integer.toString(b) + " " +
              Integer.toString(c);
        return ret;
    }

    @SuppressWarnings({ "unchecked" })
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        // Process input
        for (int i = 0; i < t; i++) {
            String s = in.next();

            if (s.equals("Student")) {
                myList.add(new Student());
            } else if (s.equals("Rockstar")) {
                myList.add(new Rockstar());
            } else if (s.equals("Hacker")) {
                myList.add(new Hacker());
            }
        }

        System.out.println(count(myList));
    }
}
