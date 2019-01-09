/*
 * Objective
 * Today, we're learning about the Array data structure. Check out the Tutorial
 * tab for learning materials and an instructional video!
 *
 * Task
 * Given an array, 'A', of 'N' integers, print A's elements in reverse order as
 * a single line of space-separated numbers.
 *
 * Input Format
 *
 * The first line contains an integer, 'N' (the size of our array).
 * The second line contains 'N' space-separated integers describing array A's
 * elements.
 *
 * Constraints
 *
 * 1 <= N <= 1000
 *
 * 1 <= A_i <= 10000, where A_i is the i-th integer in the array.
 *
 * Output Format
 *
 * Print the elements of array 'A' in reverse order as a single line of
 * space-separated numbers.
 *
 * Sample Input
 *
 * 4
 * 1 4 3 2
 *
 * Sample Output
 *
 * 2 3 4 1
 */

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        // Process input
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        // Loops through the input array in reverse order and prints its
        // elements
        for (int i = arr.length - 1; 0 <= i; i--) {
            System.out.print(arr[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
