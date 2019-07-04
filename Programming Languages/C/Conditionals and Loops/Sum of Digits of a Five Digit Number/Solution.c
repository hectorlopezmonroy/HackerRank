/*
 * Objective
 *
 * In order to get the last digit of a number, we the use modulo operator '%'.
 * When the number is module divided by '10' we get the last digit.
 *
 * To find the first digit of a number we divide the given number by '10' until
 * number is less than '10'. At the end we are left with the first digit.
 *
 * Task
 *
 * In this challenge, you have to input a five digit number and print the sum of
 * digits of the number.
 *
 * Input Format
 *
 * The input contains a single five digit number, 'n'.
 *
 * Constraints
 *
 * 10000 <= n <= 99999
 *
 * Output Format
 *
 * Print the sum of the digits of the five digit number.
 *
 * Sample Input
 *
 * 10564
 *
 * Sample Output
 *
 * 16
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int n;
    int result = 0;

    scanf("%d", &n);

    while (n != 0) {
        result += n % 10;
        n = n / 10;
    }

    printf("%d\n", result);
    return 0;
}
