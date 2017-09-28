/*
 * Colleen is turning n years old! Therefore, she has n candles of various
 * heights on her cake, and candle i has height height_i. Because the taller
 * candles tower over the shorter ones, Colleen can only blow out the tallest
 * candles.
 *
 * Given the height_i for each individual candle, find and print the number of
 * candles she can succesfully blow out.
 *
 * Input Format
 *
 * The first line contains a single integer, n, denoting the number of candles
 * on the cake.
 * The second line contains n space-separated integers, where each integer i
 * describes the height of candle i.
 *
 * Constraints
 *
 * 1 <= n <= 10^5
 * 1 <= height_i <= 10^7
 *
 * Output Format
 *
 * Print the number of candles Colleen blows out on a new line.
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
 * We have one candle of height 1, one candle of height 2, and two candles of
 * height 3. Colleen only blows out the tallest candles, meaning the candles
 * where height = 3. Because there are 2 such candles, we print 2 on a new line.
 */

import java.util.Scanner;
import java.util.HashMap;

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int tallestHeight = 0;

        for (int i = 0; i < n; i++) {
            int candle_i = in.nextInt();
            if (candle_i > tallestHeight) {
                tallestHeight = candle_i;
            }
            if (map.containsKey(candle_i)) {
                map.replace(candle_i, map.get(candle_i) + 1);
            } else {
                map.put(candle_i, 1);
            }
        }
        in.close();
        System.out.println(map.get(tallestHeight));
    }
}
