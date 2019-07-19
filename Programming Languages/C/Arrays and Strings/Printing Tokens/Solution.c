/*
 * Given a sentence, 's', print each word of the sentence in a new line.
 *
 * Input Format
 *
 * The first and only line contains a sentence, 's'.
 *
 * Constraints
 *
 * 1 <= len(s) <= 1000
 *
 * Output Format
 *
 * Print each word of the sentence in a new line.
 *
 * Sample Input 0
 *
 * This is C
 *
 * Sample Output 0
 *
 * This
 * is
 * C
 *
 * Explanation 0
 *
 * In the given string, there are three words ["This", "is", "C"]. We have to
 * print each of these words in a new line.
 *
 * Sample Input 1
 *
 * Learning C is fun
 *
 * Sample Output 1
 *
 * Learning
 * C
 * is
 * fun
 *
 * Sample Input 2
 *
 * How is that
 *
 * Sample Output 2
 *
 * How
 * is
 * that
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char *s;
    s = malloc(1024 * sizeof(char));
    scanf("%[^\n]", s);
    s = realloc(s, strlen(s) + 1);

    // Loops through the length of the input sentence.
    for (int i = 0; i < strlen(s); i++) {
        char c = s[i];

        if (c == ' ') {
            // A space character was found, this means the token has ended.
            // Therefore, we print a new line.
            printf("\n");
        } else {
            // We print the character part of the token.
            printf("%c", c);
        }
    }
    printf("\n");

    return 0;
}
