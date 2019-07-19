/*
 * Given an array, of size 'n', reverse it.
 *
 * Example: If array, 'arr = [1, 2, 3, 4, 5]', after reversing it, the array
 * should be, 'arr = [5, 4, 3, 2, 1]'.
 *
 * Input Format
 *
 * The first line contains an integer, 'n', denoting the size of the array.
 * The next line contains 'n' space-separated integers denoting the elements of
 * the array.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= arr_i <= 1000, where 'arr_i' is the 'i-th' element of the array.
 *
 * Output Format
 *
 * The output is handled by the code given in the editor, which would print the
 * array.
 *
 * Sample Input 0
 *
 * 6
 * 16 13 7 2 1 12
 *
 * Sample Output 0
 *
 * 12 1 2 7 13 16
 *
 * Explanation 0
 *
 * Given array, 'arr = [16, 13, 7, 2, 1, 12]'. After reversing the array,
 * 'arr = [12, 1, 2, 7, 13, 16]'.
 *
 * Sample Input 1
 *
 * 7
 * 1 13 15 20 12 13 2
 *
 * Sample Output 1
 *
 * 2 13 12 20 15 13 1
 *
 * Sample Input 2
 *
 * 8
 * 15 5 16 15 17 11 5 11
 *
 * Sample Output 2
 *
 * 11 5 11 17 15 16 5 15
 */

#include <stdio.h>
#include <stdlib.h>

int main() {
    int num, *arr, i;

    // Process input.
    scanf("%d", &num);
    arr = (int*) malloc(num * sizeof(int));
    for(i = 0; i < num; i++) {
        scanf("%d", &arr[i]);
    }

    // Swaps the first half of the elements with the second half of the
    // elements, resulting in the reverse of the original array.
    for (i = 0; i < (num / 2); i++) {
        int swap = arr[i];

        arr[i] = arr[num - i - 1];
        arr[num - i - 1] = swap;
    }

    // Prints output as requested.
    for(i = 0; i < num; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
