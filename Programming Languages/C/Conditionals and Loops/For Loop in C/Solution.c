/*
 * Objective
 *
 * In this challenge, you will learn the usage of the 'for' loop, which is a
 * programming language statement which allows code to be repeatedly executed.
 *
 * The syntax for this is:
 *
 *   for (<expression_1>; <expression_2>; <expression_3>)
 *       <statement>
 *
 * * 'expression_1' is used for initializing variables which are generally used
 *   for controlling the terminating flag for the loop.
 *
 * * 'expression_2' is used to check for the terminating condition. If this
 *   evaluates to 'false', then the loop is terminated.
 *
 * * 'expression_3' is generally used to update the flags/variables.
 *
 * A sample loop will be:
 *
 *   for (int i = 0; i < 10; i++) {
 *       ...
 *   }
 *
 * Task
 *
 * For each integer 'n' in the interval '[a, b]' (given as input):
 *
 * If 1 <= n <= 9, then print the English representation of it in lowercase.
 * That is 'one' for '1', 'two' for '2', and so on.
 *
 * Else if 9 < n and it is an even number, then print 'even'.
 *
 * Else if 9 < n and it is an odd number, then print 'odd'.
 *
 * Input Format
 *
 * The first line contains an integer, 'a'.
 *
 * The second line contains an integer, 'b'.
 *
 * Constraints
 *
 * 1 <= a <= b <= 10^6
 *
 * Output Format
 *
 * Print the appropriate English lowercase representation, 'even' or 'odd',
 * based on the conditions described in the 'Task' section.
 *
 * Note: [a, b] = { x belongs to Z | a <= x <= b } = { a, a + 1, ... , b }
 *
 * Sample Input
 *
 * 8
 * 11
 *
 * Sample Output
 *
 * eight
 * nine
 * even
 * odd
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int a, b;
    scanf("%d\n%d", &a, &b);

    for (int i = a; i <= b; i++) {
        if (i == 1) {
            printf("one\n");
        } else if (i == 2) {
            printf("two\n");
        } else if (i == 3) {
            printf("three\n");
        } else if (i == 4) {
            printf("four\n");
        } else if (i == 5) {
            printf("five\n");
        } else if (i == 6) {
            printf("six\n");
        } else if (i == 7) {
            printf("seven\n");
        } else if (i == 8) {
            printf("eight\n");
        } else if (i == 9) {
            printf("nine\n");
        } else if (9 < i) {
            if (i % 2 == 0) {
                printf("even\n");
            } else {
                printf("odd\n");
            }
        }
    }

    return 0;
}
