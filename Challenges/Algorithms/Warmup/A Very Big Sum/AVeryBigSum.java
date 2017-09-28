/*
 * You are given an array of integers of size N. You need to print the sum of
 * the elements in the array, keeping in mind that some of those integers may be
 * quite large.
 *
 * Input Format
 *
 * The first line of the input consists of an integer N. The next line contains
 * N space-separated integers contained in the array.
 *
 * Output Format
 *
 * Print a single value equal to the sum of the elements in the array.
 *
 * Constraints
 *
 * 1 <= N <= 10
 * 0 <= A[i] <= 10^10
 *
 * Sample Input
 *
 * 5
 * 1000000001 1000000002 1000000003 1000000004 1000000005
 *
 * Sample Output
 *
 * 5000000015
 *
 * Note: The range of the 32-bit integer is (-2^31) to (2^31 - 1). When we add
 * several integer values, the resulting sum might exceed the above range. You
 * might need touse long long int in C/C++ or long data type in Java to store
 * such sums.
 */

import java.util.Scanner;

public class AVeryBigSum {

    public static long aVeryBigSum(int n, long[] ar) {
        long res = 0;

        for (int i = 0; i < n; i++) {
            try {
                res = Math.addExact(res, ar[i]);
            } catch (ArithmeticException e){
                System.out.println("The values provided caused an overflow.");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];

        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        in.close();
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }
}
