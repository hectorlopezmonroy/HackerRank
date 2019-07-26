/*
 * You are given an array of integers, 'marks', denoting the marks scored by
 * students in a class.
 *
 *   * The alternating elements 'marks[0]', 'marks[2]', 'marks[4]' and so on
 *     denote the marks of boys.
 *
 *   * Similarly, 'marks[1]', 'marks[3]', 'marks[5]' and so on denote the marks
 *     of girls.
 *
 * The array name, 'marks' works as a pointer which stores the base address of
 * that array. In other words, 'marks' contains the address where 'marks[0]' is
 * stored in the memory.
 *
 * For example, let 'marks = [3, 2, 5]' and 'marks' stores 0x7fff9575c05f.
 * Then, 0x7fff9575c05f is the memory address of 'marks[0]'.
 *
 *     marks
 *       |
 *       v
 *   --------- --------- ---------
 *  |    3    |    2    |    5    |
 *   --------- --------- ---------
 *    marks[0]  marks[1]  marks[2]
 *
 * Complete the function,
 * 'marks_summation(int* marks, char gender, int number_of_Students)' which
 * returns the total sum of:
 *
 *   * marks of boys if 'gender = b'.
 *
 *   * marks of girls if 'gender = g'.
 *
 * The locked code stub reads the elements of 'marks' along with 'gender'. Then,
 * it calls the function 'marks_summation(marks, gender, number_of_students)' to
 * get the sum of alternate elements as explained above and then prints the sum.
 *
 * Input Format
 *
 * The first line contains 'number_of_students', denoting the number of students
 * in the class, hence the number of elements in 'marks'.
 *
 * Each of the 'number_of_students' subsequent lines contains 'marks[i]'.
 *
 * The next line contains 'gender'.
 *
 * Constraints
 *
 * 1 <= number_of_students <= 10^3
 *
 * 1 <= marks[i] <= 10^3, where 0 <= i < number_of_students.
 *
 * gender = 'g' or 'b'.
 *
 * Output Format
 *
 * The output should contain the sum of all the alternate elements in 'marks' as
 * explained above.
 *
 * Sample Input 0
 *
 * 3
 * 3
 * 2
 * 5
 * b
 *
 * Sample Output 0
 *
 * 8
 *
 * Explanation 0
 *
 * 'marks' = [3, 2, 5] and 'gender = b'.
 * So, 'sum = marks[0] + marks[2] = 3 + 5 = 8'.
 *
 * Sample Input 1
 *
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 * g
 *
 * Sample Output 1
 *
 * 6
 *
 * Explanation 1
 *
 * 'marks' = [1, 2, 3, 4, 5] and 'gender = g'.
 * So, 'sum = marks[1] + marks[3] = 2 + 4 = 6'.
 *
 * Sample Input 2
 *
 * 1
 * 5
 * g
 *
 * Sample Output 2
 *
 * 0
 *
 * Explanation 2
 *
 * 'marks' = [5] and 'gender = g'.
 * Here, 'marks[1]' does not exist. So, 'sum = 0'.
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int marks_summation(int* marks, int number_of_students, char gender) {
    int res = 0;
    int index = gender == 'b' ? 0 : 1;

    while (index < number_of_students) {
        res += marks[index];
        index += + 2;
    }
    return res;
}

int main() {
    int sum;
    char gender;
    int number_of_students;

    scanf("%d", &number_of_students);
    int *marks = (int *) malloc(number_of_students * sizeof (int));

    for (int student = 0; student < number_of_students; student++) {
        scanf("%d", (marks + student));
    }

    scanf(" %c", &gender);
    sum = marks_summation(marks, number_of_students, gender);
    printf("%d\n", sum);
    free(marks);

    return 0;
}
