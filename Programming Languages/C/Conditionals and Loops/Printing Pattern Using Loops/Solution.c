/*
 * In this problem, you need to print the pattern of the following form
 * containing the numbers from '1' to 'n'.
 *
 *                          4 4 4 4 4 4 4
 *                          4 3 3 3 3 3 4
 *                          4 3 2 2 2 3 4
 *                          4 3 2 1 2 3 4
 *                          4 3 2 2 2 3 4
 *                          4 3 3 3 3 3 4
 *                          4 4 4 4 4 4 4
 *
 * Input Format
 *
 * The input will contain a single integer 'n'.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * Output Format
 *
 * Print the pattern mentioned in the problem statement.
 *
 * Sample Input 0
 *
 * 2
 *
 * Sample Output 0
 *
 * 2 2 2
 * 2 1 2
 * 2 2 2
 *
 * Sample Input 1
 *
 * 5
 *
 * Sample Output 1
 *
 * 5 5 5 5 5 5 5 5 5
 * 5 4 4 4 4 4 4 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 2 1 2 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 4 4 4 4 4 4 5
 * 5 5 5 5 5 5 5 5 5
 *
 * Sample Input 2
 *
 * 7
 *
 * Sample Output 2
 *
 * 7 7 7 7 7 7 7 7 7 7 7 7 7
 * 7 6 6 6 6 6 6 6 6 6 6 6 7
 * 7 6 5 5 5 5 5 5 5 5 5 6 7
 * 7 6 5 4 4 4 4 4 4 4 5 6 7
 * 7 6 5 4 3 3 3 3 3 4 5 6 7
 * 7 6 5 4 3 2 2 2 3 4 5 6 7
 * 7 6 5 4 3 2 1 2 3 4 5 6 7
 * 7 6 5 4 3 2 2 2 3 4 5 6 7
 * 7 6 5 4 3 3 3 3 3 4 5 6 7
 * 7 6 5 4 4 4 4 4 4 4 5 6 7
 * 7 6 5 5 5 5 5 5 5 5 5 6 7
 * 7 6 6 6 6 6 6 6 6 6 6 6 7
 * 7 7 7 7 7 7 7 7 7 7 7 7 7
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int n;
    int len;

    scanf("%d", &n);
    len = 2 * n - 1;

    // We need to print 2 * n - 1 rows.
    for (int i = 0; i < len; i++) {

        // We need to print 2 * n - 1 columns.
        for (int j = 0; j < len; j++) {
            int minDist = i < j ? i : j;
            minDist = minDist < len - i - 1 ? minDist : len - i - 1;
            minDist = minDist < len - j - 1 ? minDist : len - j - 1;

            // Each entry in the pattern matrix is the input 'n' minus the
            // minimum distance to each of the matrix edges from that entry.
            printf("%d ", n - minDist);
        }
        // Print a newline character at the end of each row.
        printf("\n");
    }
    return 0;
}
