/*
 * HackerLand University has the following grading policy:
 *
 *   * Every student receives a 'grade' in the inclusive range from '0' to '100'.
 *
 *   * Any 'grade' less than '40' is a failing grade.
 *
 * Sam is a professor at the university and likes to round each student's
 * 'grade' according to these rules:
 *
 *   * If the difference between the 'grade' and the next multiple of '5' is
 *     less than '3', round 'grade' up to the next multiple of '5'.
 *
 *   * If the value of 'grade' is less than '38', no rounding occurs as the
 *     result will still be a failing grade.
 *
 * For example, 'grade = 84' will be rounded to '85' but 'grade = 29' will not
 * be rounded because the rounding would result in a number that is less than
 * '40'.
 *
 * Given the initial value of 'grade' for each of Sam's 'n' students, write code
 * to automate the rounding process.
 *
 * Function Description
 *
 * Complete the function 'gradingStudents' in the editor below. It should return
 * an integer array consisting of rounded grades.
 *
 * 'gradingStudents' has the following parameter(s):
 *
 *   * 'grades': an array of integers representing grades before rounding.
 *
 * Input Format
 *
 * The first line contains a single integer, 'n', the number of students.
 *
 * Each line 'i' of the 'n' subsequent lines contains a single integer,
 * 'grades[i]', denoting student i's grade.
 *
 * Constraints
 *
 * 1 <= n <= 60
 *
 * 0 <= grades[i] <= 100
 *
 * Output Format
 *
 * For each 'grades[i]', print the rounded grade on a new line.
 *
 * Sample Input
 *
 * 4
 * 73
 * 67
 * 38
 * 33
 *
 * Sample Output
 *
 * 75
 * 67
 * 40
 * 33
 *
 * Explanation
 *
 * ID | Original Grade | Final Grade
 *  1 |       73       |      75
 *  2 |       67       |      67
 *  3 |       38       |      40
 *  4 |       33       |      33
 *
 * 1. Student '1' received a '73', and the next multiple of '5' from '73' is
 *    '75'. Since '75 - 73 < 3', the student's grade is rounded to '75'.
 *
 * 2. Student '2' received a '67', and the next multiple of '5' from '67' is
 *    '70'. Since '70 - 67 = 3', the grade will not be modified and the
 *    student's final grade is '67'.
 *
 * 3. Student '3' received a '38', and the next multiple of '5' from '38' is
 *    '40'. Since '40 - 38 < 3', the student's grade will be rounded to '40'.
 *
 * 4. Student '4' received a grade below '38', so the grade will no be modified
 *    and the student's final grade is '33'.
 */

import java.util.Scanner;

public class GradingStudents {

    public static int[] gradingStudents(int[] grades) {
        int[] res = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 38) {
                // grade[i] could be rounded up and make a difference in the
                // student's final grade.

                if ((grades[i] % 5) == 3 || (grades[i] % 5) == 4) {
                    // grade[i] is close enough to round up to the closest
                    // multiple of 5.

                    res[i] = grades[i] + (5 - (grades[i] % 5));
                } else {
                    // grade[i] is NOT close enough to round up.

                    res[i] = grades[i];
                }
            } else {
                // grade[i] is not close enough to round up to a passing grade.
                // Therefore, no rounding is applied.

                res[i] = grades[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        int[] result = new int[n];

        // Process input
        for(int i = 0; i < n; i++){
            grades[i] = in.nextInt();
        }
        in.close();

        result = gradingStudents(grades);

        // Prints output
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
