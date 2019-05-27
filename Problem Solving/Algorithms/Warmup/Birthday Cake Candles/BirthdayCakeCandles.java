/*
 * You are in charge of the cake for your niece's birthday and have decided the
 * cake will have one candle for each year of her total age. When she blows out
 * the candles, she'll only be able to blow out the tallest ones. Your task is
 * to find out how many candles she can succesfully blow out.
 *
 * For example, if your niece is turning '4' years old, and the cake will have
 * '4' candles of height '4', '4', '1', '3', she will be able to blow out '2'
 * candles successfully, since the tallest candles are of height '4' and there
 * are '2' such candles.
 *
 * Function Description
 *
 * Complete the function 'birthdayCakeCandles' in the editor below. It must
 * return an integer representing the number of candles she can blow out.
 *
 * 'birthdayCakeCandles' has the following parameter(s):
 *
 *   * 'ar': an array of integers representing candle heights.
 *
 * Input Format
 *
 * The first line contains a single integer, 'n', denoting the number of candles
 * on the cake.
 *
 * The second line contains 'n' space-separated integers, where each integer 'i'
 * describes the height of candle 'i'.
 *
 * Constraints
 *
 * 1 <= n <= 10^5
 *
 * 1 <= ar[i] <= 10^7
 *
 * Output Format
 *
 * Print the number of candles that can be blown out on a new line.
 *
 * Sample Input
 *
 * 4
 * 3 2 1 3
 *
 * Sample Output
 *
 * 2
 *
 * Explanation
 *
 * We have one candle of height '1', one candle of height '2', and two candles
 * of height '3'. Your niece only blows out the tallest candles, meaning the
 * candles where 'height = 3'. Because there are '2' such candles, we print '2'
 * on a new line.
 */

import java.util.HashMap;
import java.util.Scanner;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] ar) {
        int res = 0;
        int tallestHeight = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {
            int candle_i = ar[i];

            if (candle_i > tallestHeight) {
                tallestHeight = candle_i;
            }
            if (map.containsKey(candle_i)) {
                map.replace(candle_i, map.get(candle_i) + 1);
            } else {
                map.put(candle_i, 1);
            }
        }
        res = map.get(tallestHeight);

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result;
        int n = in.nextInt();
        int[] ar = new int[n];

        // Process input
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();

        result = birthdayCakeCandles(ar);

        // Prints output
        System.out.println(result);
    }
}
