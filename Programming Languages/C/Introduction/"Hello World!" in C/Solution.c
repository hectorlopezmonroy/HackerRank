/*
 * Objective
 *
 * In this challenge, we will learn some basic concepts of C that will get you
 * started with the language. You will need to use the same syntax to read and
 * write output in many C challenges.
 *
 * Task
 *
 * This challenge requires you to print "Hello, World!" on a single line, and
 * then print the already provided input string to stdout.
 *
 * Note: You do not need to read any input in this challenge.
 *
 * Input Format
 *
 * You do not need to read any input in this challenge.
 *
 * Output Format
 *
 * Print "Hello, World!" on the first line, and the string from the given input
 * on the second line.
 *
 * Sample Input
 *
 * Welcome to C programming.
 *
 * Sample Output
 *
 * Hello, World!
 * Welcome to C programming.
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char s[100];

    scanf("%[^\n]%*c", &s);
    printf("Hello, World!\n");
    printf("%s\n", &s);
    return 0;
}
