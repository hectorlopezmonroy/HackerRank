/*
 * Given a string, 's', consisting of alphabet characters and digits, find the
 * frequency of each digit in the given string.
 *
 * Input Format
 *
 * The first line contains a string, 's', which is the given string.
 *
 * Constraints
 *
 * 1 <= len(s) <= 1000
 *
 * All the elements of 's' consist of English alphabet characters and digits.
 *
 * Output Format
 *
 * Print ten space-separated integers in a single line denoting the frequency of
 * each digit from '0' to '9'.
 *
 * Sample Input 0
 *
 * a11472o5t6
 *
 * Sample Output 0
 *
 * 0 2 1 0 1 1 1 1 0 0
 *
 * Explanation 0
 *
 * In the given string:
 *
 * * '1' occurs two times.
 * * '2', '4', '5', '6' and '7' occur one time each.
 * * The remaining digits '0', '3', '8' and '9' don't occur at all.
 *
 * Sample Input 1
 *
 * lw4n88j12n1
 *
 * Sample Output 1
 *
 * 0 2 1 0 1 0 0 0 2 0
 *
 * Sample Input 2
 *
 * 1v88886l256338ar0ekk
 *
 * Sample Output 2
 *
 * 1 1 1 2 0 1 2 0 5 0
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int i;
    char* s;
    int frequencies[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Process input.
    s = malloc(1024 * sizeof(char));
    scanf("%[^\n]", s);
    s = realloc(s, strlen(s) + 1);

    // Loops through the input string and updates the digits' frequencies.
    for (i = 0; i < strlen(s); i++) {
        char c = s[i];

        switch(c) {
            case '0':
                frequencies[0]++;
                break;
            case '1':
                frequencies[1]++;
                break;
            case '2':
                frequencies[2]++;
                break;
            case '3':
                frequencies[3]++;
                break;
            case '4':
                frequencies[4]++;
                break;
            case '5':
                frequencies[5]++;
                break;
            case '6':
                frequencies[6]++;
                break;
            case '7':
                frequencies[7]++;
                break;
            case '8':
                frequencies[8]++;
                break;
            case '9':
                frequencies[9]++;
                break;
            default:
                break;
        }
    }

    // Prints output as requested.
    for (i = 0; i < 10; i++) {
        printf("%d ", frequencies[i]);
    }
    printf("\n");

    return 0;
}
