/*
 * Let's play a game on an array! You're standing at index 0 of an n-element
 * array named 'game'. From some index 'i' (where 0 <= i < n), you can perform
 * one of the following moves:
 *
 *   * Move Backward: If cell i - 1 exists and contains a 0, you can walk back
 *     to cell i - 1.
 *
 *   * Move Forward:
 *
 *     * If cell i + 1 contains a zero, you can walk to cell i + 1.
 *
 *     * If cell i + leap contains a zero, you can jump to cell i + leap.
 *
 *     * If you're standing in cell n - 1 or the value of i + leap >= n, you can
 *       walk or jump off the end of the array and win the game.
 *
 * In other words, you can move from index 'i' to index i + 1, i - 1, or
 * i + 'leap' as long as the destination index is a cell containing a 0. If the
 * destination index is greater than n - 1, you win the game.
 *
 * Given 'leap' and 'game', complete the function in the editor below so that it
 * returns 'true' if you can win the game (or 'false' if you cannot).
 *
 * Input Format
 *
 * The first line contains an integer, 'q', denoting the number of queries
 * (i.e., function calls). The 2 * q subsequent lines describe each query over
 * two lines:
 *
 * 1. The first line contains two space-separated integers describing the
 * respective values of 'n' and 'leap'.
 *
 * 2. The second line contains 'n' space-separated binary integers (i.e., zeroes
 * and ones) describing the respective values of game_0, game_1, ... ,
 * game_(n - 1).
 *
 * Constraints
 *
 * 1 <= q <= 5000
 *
 * 2 <= n <= 100
 *
 * 0 <= leap <= 100
 *
 * It is guaranteed that the value of game[0] is always 0.
 *
 * Output Format
 *
 * Return 'true' if you can win the game; otherwise, return 'false'.
 *
 * Sample Input
 *
 * 4
 * 5 3
 * 0 0 0 0 0
 * 6 5
 * 0 0 0 1 1 1
 * 6 3
 * 0 0 1 1 1 0
 * 3 1
 * 0 1 0
 *
 * Sample Output
 *
 * YES
 * YES
 * NO
 * NO
 *
 * Explanation
 *
 * We perform the following q = 4 queries:
 *
 * 1. For game = [0, 0, 0, 0, 0] and leap = 3, we can walk and/or jump to the
 * end of the array because every cell contains a 0. Because we can win, we
 * return 'true'.
 *
 * 2. For game = [0, 0, 0, 1, 1, 1] and leap = 5, we can walk to index 1 and
 * then jump i + leap = 1 + 5 = 6 units to the end of the array. Because we can
 * win, we return 'true'.
 *
 * 3. For game = [0, 0, 1, 1, 1, 0] and leap = 3, there is no way for us to get
 * past the three consecutive ones. Because we cannot win, we return 'false'.
 *
 * 4. For game = [0, 1, 0] and leap = 1, there is no way for us to get past the
 * one at index 1. Because we cannot win, we return 'false'.
 */

import java.util.Scanner;

public class Java1DArray {

    public static boolean isSolvable(int leap, int[] game, int pos) {
        boolean res = false;

        if (pos < 0) {
            return false;
        } else if (0 <= pos && pos < game.length && game[pos] == 1) {
            return false;
        } else if (game.length - 1 <= pos) {
            return true;
        }
        game[pos] = 1;
        return isSolvable(leap, game, pos + 1) ||
               isSolvable(leap, game, pos - 1) ||
               isSolvable(leap, game, pos + leap);
    }

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        boolean res = true;

        res = isSolvable(leap, game, 0);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        boolean[] res = new boolean[q];

        for (int i = 0; i < q; i++){
            int n = in.nextInt();
            int leap = in.nextInt();

            int[] game = new int[n];
            for (int j = 0; j < n; j++) {
                game[j] = in.nextInt();
            }
            res[i] = canWin(leap, game);
        }
        in.close();

        for (boolean b : res) {
            System.out.println( b ? "YES" : "NO");
        }
    }
}
