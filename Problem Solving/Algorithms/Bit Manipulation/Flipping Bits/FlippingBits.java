/*
 * You will be given a list of 32 bit unsigned integers. Flip all the bits
 * ('1'-> '0' and '0' -> '1') and print the results as an unsigned integer.
 *
 * For example, your decimal input 'n = 9_10 = 1001_2'. We're working with 32
 * bits, so:
 *
 * 00000000000000000000000000001001_2 = 9_10
 * 11111111111111111111111111110110_2 = 4294967286_10
 *
 * Function Description
 *
 * Complete the 'flippingBits' function in the editor below. It should return
 * the unsigned decimal integer result.
 *
 * 'flippingBits' has the following parameter(s):
 *
 *   * 'n': an integer.
 *
 * Input Format
 *
 * The first line of the input contains 'q', the number of queries.
 *
 * Each of the next 'q' lines contain an integer, 'n', to process.
 *
 * Constraints
 *
 * 1 <= q <= 100
 *
 * 0 <= n < 2^32
 *
 * Output Format
 *
 * Output one line per element from the list with the decimal value of the
 * resulting unsigned integer.
 *
 * Sample Input 0
 *
 * 3
 * 2147483647
 * 1
 * 0
 *
 * Sample Output 0
 *
 * 2147483648
 * 4294967294
 * 4294967295
 *
 * Explanation 0
 *
 * 01111111111111111111111111111111_2 = 2147483647_10
 * 10000000000000000000000000000000_2 = 2147483648_10
 * 00000000000000000000000000000001_2 = 1_10
 * 11111111111111111111111111111110_2 = 4294967294_10
 * 00000000000000000000000000000000_2 = 0_10
 * 11111111111111111111111111111111_2 = 4294967295_10
 *
 * Sample Input 1
 *
 * 2
 * 4
 * 123456
 *
 * Sample Output 1
 *
 * 4294967291
 * 4294843839
 *
 * Explanation 1
 *
 * 00000000000000000000000000000100_2 = 4_10
 * 11111111111111111111111111111011_2 = 4294967291_10
 * 00000000000000011110001001000000_2 = 4_10
 * 11111111111111100001110110111111_2 = 4294843839_10
 *
 * Sample Input 2
 *
 * 3
 * 0
 * 802743475
 * 35601423
 *
 * Sample Output 2
 *
 * 4294967295
 * 3492223820
 * 4259365872
 *
 * Explanation 2
 *
 * 00000000000000000000000000000000_2 = 0_10
 * 11111111111111111111111111111111_2 = 4294967295_10
 * 00101111110110001110010010110011_2 = 802743475_10
 * 11010000001001110001101101001100_2 = 3492223820_10
 * 00000010000111110011110000001111_2 = 35601423_10
 * 11111101111000001100001111110000_2 = 4259365872_10
 */

import java.util.Arrays;
import java.util.Scanner;

public class FlippingBits {

    public static long allOnes;

    FlippingBits() {

        for (int i = 0; i < 32; i++) {
            allOnes += (long) Math.pow(2, i);
        }
    }

     private static long flippingBits(long n) {
        long res;

        res = n ^ allOnes;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] result = new long[t];
        FlippingBits fb = new FlippingBits();

        // Process input
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            result[i] = flippingBits(n);
        }
        in.close();

        // Prints output
        for (long l : result) {
            System.out.println(l);
        }
    }
}
