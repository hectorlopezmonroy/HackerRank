/*
 * Louise and Richard have developed a numbers game. They pick a number and
 * check to see if it is a power of '2'. If it is, they divide it by '2'. If
 * not, they reduce it by the next lower number which is a power of '2'. Whoever
 * reduces the number to '1' wins the game. Louise always starts.
 *
 * Given an initial value, determine who wins the game.
 *
 * As an example, let the initial value 'n = 132'. It's Louise's turn so she
 * first determines that '132' is not a power of '2'. The next lower power of
 * '2' is '128', so she subtracts that from '132' and passes '4' to Richard.
 * '4' is a power of '2', so Richard divides it by '2' and passes '2' to Louise.
 * Likewise, '2' is a power of '2' so she divides it by '2' and reaches '1'. She
 * wins the game.
 *
 * Update: If they initially set counter to '1', Richard wins. Louise cannot
 * make a move so she loses.
 *
 * Function Description
 *
 * Complete the 'counterGame' function in the editor below. It should return the
 * winner's name, either "Richard" or "Louise".
 *
 * 'counterGame' has the following parameter(s):
 *
 *   * 'n': an integer to initialize the game counter.
 *
 * Input Format
 *
 * The first line contains an integer 't', the number of testcases.
 *
 * Each of the next 't' lines contains an integer 'n', the initial value for the
 * game.
 *
 * Constraints
 *
 * 1 <= t <= 10
 *
 * 1 <= n <= 2^64 - 1
 *
 * Output Format
 *
 * For each test case, print the winner's name on a new line in the form
 * "Louise" or "Richard".
 *
 * Sample Input
 *
 * 1
 * 6
 *
 * Sample Output
 *
 * Richard
 *
 * Explanation
 *
 * '6' is not a power of '2' so Louise reduces it by the largest power of '2'
 * less than '6': '6 - 4 = 2'.
 *
 * '2' is a power of '2' so Richard divides by '2' to get '1' and wins the game.
 */

import java.util.Arrays;
import java.util.Scanner;

public class CounterGame {

    public static long[] powersOfTwo = new long[63];

    CounterGame() {
        for (int i = 0; i < 63; i++) {
            powersOfTwo[i] = (long) Math.pow(2, i);
        }
    }

    static boolean isPowerOfTwo(long n) {
        int i;
        boolean res = false;

        i = Arrays.binarySearch(powersOfTwo, n);
        if ((0 <= i) && (i <= 63) && (powersOfTwo[i] == n)) {
            // 'n' was found in the 'powersOfTwo' array.
            // Therefore it is a power of '2'.
            res = true;
        }
        return res;
    }

     private static long nextLowerPowerOfTwo(long n) {
        int i = 0;
        long res = 1;

        i = Arrays.binarySearch(powersOfTwo, n);
        if (i < 0) {
            i = -1 * (i + 1);
            while (powersOfTwo[i] > n) {
                i--;
            }
        }
        res = powersOfTwo[i];
        return res;
    }

    // Complete the counterGame function below.
    static String counterGame(long n) {
        String res = "";
        String turn = "Louise";

        if (n == 1) {
            res = "Richard";
        } else {
            while (n != 1) {
                if (isPowerOfTwo(n)) {
                    n = n>>1;
                } else {
                    n = n - nextLowerPowerOfTwo(n);
                }
                if (turn == "Louise") {
                    res = "Louise";
                    turn = "Richard";
                } else {
                    res = "Richard";
                    turn = "Louise";
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] result = new String[t];
        CounterGame cg = new CounterGame();

        // Process input
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            result[i] = counterGame(n);
        }
        in.close();

        // Prints output
        for (String s : result) {
            System.out.println(s);
        }
    }
}
