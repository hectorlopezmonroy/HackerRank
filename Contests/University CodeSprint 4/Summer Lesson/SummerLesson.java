/*
 * Among all students planning to enroll to summer school at a university, each
 * student wants to take exactly one out of all available classes. To help the
 * university in planning, your task is to find out how many students are taking
 * each class.
 *
 * Complete the function 'howManyStudents' which takes in an integer denoting
 * the number of available classes, and an integer array denoting index of each
 * class as input. The function must return an integer array where each element
 * in the array represents the number of students that want to take each class.
 *
 * Input Format
 *
 * The first line contains two space-separated integers 'n', denoting the total
 * number of students and 'm', denoting the number of available classes.
 *
 * The second line contains 'n' space-separated integers c[0], c[1], ... ,
 * c[n - 1], where c[i] represents the index of the class that student 'i' wants
 * to take.
 *
 * Note: We index the students 0 to n - 1 and we index the classes 0 to m - 1.
 *
 * Constraints
 *
 * 1 <= n, m <= 1000
 *
 * 0 <= c[i] < m
 *
 * Output Format
 *
 * Print a single line containing 'm' space-separated integers s[0], s[1], ... ,
 * s[m - 1], where s[j] represents the number of students that want to take
 * class 'j'.
 *
 * Sample Input
 *
 * 4 3
 * 2 2 0 2
 *
 * Sample Output
 *
 * 1 0 3
 *
 * Explanation
 *
 * There are n = 4 students and m = 3 classes. We have c = [2, 2, 0, 2], which
 * means that:
 *
 *   * Student 0 wants to take class 2.
 *
 *   * Student 1 wants to take class 2.
 *
 *   * Student 2 wants to take class 0.
 *
 *   * Student 3 wants to take class 2.
 *
 * This means that:
 *
 *   * 1 student wants to take class 0.
 *
 *   * 0 students want to take class 1.
 *
 *   * 3 students want to take class 2.
 *
 * Hence, we must print the array s = [1, 0, 3].
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SummerLesson {

    /*
     * Complete the howManyStudents function below.
     */
    static int[] howManyStudents(int m, int[] c) {
        // Return an array denoting the number of students taking each class.
        int[] res = new int[m];

        for (int cItr = 0; cItr < c.length; cItr++) {
            int lesson = c[cItr];
            res[lesson]++;
        }
        return res;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scan.nextLine().split(" ");
        int n = Integer.parseInt(nm[0].trim());
        int m = Integer.parseInt(nm[1].trim());
        int[] c = new int[n];
        String[] cItems = scan.nextLine().split(" ");

        for (int cItr = 0; cItr < n; cItr++) {
            int cItem = Integer.parseInt(cItems[cItr].trim());
            c[cItr] = cItem;
        }

        int[] result = howManyStudents(m, c);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write(" ");
            }
        }

        bw.newLine();
        bw.close();
    }
}
