/*
 * Objective
 *
 * The fundamental data types in C are int, float and char. Today, we're
 * discussing int and float data types.
 *
 * The 'printf()' function prints the given statement to the console. The syntax
 * is 'printf("format string", argument_list);'. In the function, if we are
 * using an integer, character, string or float as argument, then in the format
 * string we have to write '%d' (integer), '%c' (character), '%s' (string), '%f'
 * (float) respectively.
 *
 * The 'scanf()' function reads the input data from the console. The syntax is
 * 'scanf("format string", argument_list);'. For example: The
 * 'scanf(%d, &number)' statement reads an integer number from the console and
 * stores the given value in variable 'number'.
 *
 * To input two integers separated by a space on a single line, the command is
 * 'scanf("%d %d", &n, &m);', where 'n' and 'm' are the two integers.
 *
 * Task
 *
 * Your task is to take two numbers of int data type, two numbers of float data
 * type as input and output their sum and difference:
 *
 *   1.- Declare '4' variables: two of type int and two of type float.
 *
 *   2.- Read '2' lines of input from stdin (according to the sequence given in
 *       the 'Input Format' section below) and initialize your '4' variables.
 *
 *   3.- Use the '+' and '-' operators to perform the following operations:
 *
 *       * Print the sum and difference of two int variables on a new line.
 *
 *       * Print the sum and difference of two float variables rounded to one
 *         decimal place on a new line.
 *
 * Input Format
 *
 * The first line contains two integers.
 * The second line contains two floating-point numbers.
 *
 * Constraints
 *
 * 1 <= integer variables <= 10^4
 *
 * 1 <= float variables <= 10^4
 *
 * Output Format
 *
 * Print the sum and difference of both integers separated by a space on the
 * first line, and the sum and difference of both floats (scaled to '1' decimal
 * place) separated by a space on the second line.
 *
 * Sample Input
 *
 * 10 4
 * 4.0 2.0
 *
 * Sample Output
 *
 * 14 6
 * 6.0 2.0
 *
 * Explanation
 *
 * When we sum the integers '10' and '4', we get the integer '14'. When we
 * subtract the second number '4' from the first number '10', we get '6' as
 * their difference.
 *
 * When we sum the floating-point numbers '4.0' and '2.0', we get '6.0'. When we
 * subtract the second number '2.0' from the first number '4.0', we get '2.0' as
 * their difference.
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int i1, i2;
    float f1, f2;

    // Proces input
    scanf("%d %d", &i1, &i2);
    scanf("%f %f", &f1, &f2);

    // Prints output
    printf("%d %d\n", i1 + i2, i1 - i2);
    printf("%.1f %.1f\n", f1 + f2, f1 - f2);
    return 0;
}
