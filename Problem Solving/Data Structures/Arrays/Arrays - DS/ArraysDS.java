/*
 * An array is a type of data structure that stores elements of the same type in
 * a contiguous block of memory. In an array, 'A', of size 'N', each memory
 * location has some unique index, 'i' (where '0 <= i < N'), that can be
 * referenced as 'A[i]' (you may also see it written as 'A_i').
 *
 * Given an array, 'A', of 'N' integers, print each element in reverse order as
 * a single line of space-separated integers.
 *
 * Note: If you've already solved our C++ domain's Arrays Introduction
 * challenge, you may want to skip this.
 *
 * Input Format
 *
 * The first line contains an integer, 'N' (the number of integers in 'A').
 *
 * The second line contains 'N' space-separated integers describing 'A'.
 *
 * Constraints
 *
 * 1 <= N <= 10^3
 *
 * 1 <= A_i <= 10^4, where A_i is the i-th integer in A.
 *
 * Output Format
 *
 * Print all 'N' integers in 'A' in reverse order as a single line of
 * space-separated integers.
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

public class ArraysDS {

    static int[] reverseArray(int[] a) {
        int[] res = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            res[i] = a[a.length - 1 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        int[] result = new int[N];

        // Process input
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        in.close();

        result = reverseArray(A);

        // Prints output
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
