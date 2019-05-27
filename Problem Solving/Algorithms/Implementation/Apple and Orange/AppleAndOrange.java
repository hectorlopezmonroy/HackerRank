/*
 * Sam's house has an apple tree and an orange tree that yield an abundance of
 * fruit. In the diagram below, the +++ region denotes his house, where 's' is
 * the start point and 't' is the end point. The apple tree is to the left of
 * his house, and the orange tree is to its right. You can assume the trees are
 * located on a single point, where the apple tree is at point 'a' and the
 * orange tree is at point 'b'.
 *
 *                a------->s<++++++++++++++++++>t<----------b
 *
 * When a fruit falls from its tree, it lands 'd' units of distance from its
 * tree of origin along the 'x'-axis. A negative value of 'd' means the fruit
 * fell 'd' units to the tree's left, and a positive value of 'd' means it falls
 * 'd' units to the tree's right.
 *
 * Given the value of 'd' for 'm' apples and 'n' oranges, determine how many
 * apples and oranges will fall on Sam's house (i.e., in the inclusive range
 * ['s','t'])?
 *
 * For example, Sam's house is between 's = 7' and 't = 10'. The apple tree is
 * located at 'a = 4' and the orange tree at 'b = 12'. There are 'm = 3' apples
 * and 'n = 3' oranges. Apples are thrown 'apples = [2, 3, -4]' units distance
 * from 'a', and 'oranges = [3, -2, -4]' units distance. Adding each apple
 * distance to the position of the tree, they land at '[4 + 2, 4 + 3, 4 + -4] =
 * [6, 7, 0]'. Oranges land at '[12 + 3, 12 + -2, 12 + -4] = [15, 10, 8]'. One
 * apple and two oranges land in the inclusive range '[7, 10]' so we print:
 *
 *   1
 *   2
 *
 * Function Description
 *
 * Complete the 'countApplesAndOranges' function in the editor below. It should
 * print the number of apples and oranges that land on Sam's house, each on a
 * separate line:
 *
 * 'countApplesAndOranges' has the following parameter(s):
 *
 *   * 's': integer, starting point of Sam's house location.
 *
 *   * 't': integer, ending point of Sam's house location.
 *
 *   * 'a': integer, location of the Apple tree.
 *
 *   * 'b': integer, location of the Orange tree.
 *
 *   * 'apples': integer array, distances at which each apple falls from the
 *               tree.
 *
 *   * 'oranges': integer array, distances at which each orange falls from the
 *                tree.
 *
 * Input Format
 *
 * The first line contains two space-separated integers denoting the respective
 * values of 's' and 't'.
 *
 * The second line contains two space-separated integers denoting the respective
 * values of 'a' and 'b'.
 *
 * The third line contains two space-separated integers denoting the respective
 * values of 'm' and 'n'.
 *
 * The fourth line contains 'm' space-separated integers denoting the respective
 * distances that each apple falls from point 'a'.
 *
 * The fifth line contains 'n' space-separated integers denoting the respective
 * distances that each orange falls from point 'b'.
 *
 * Constraints
 *
 * 1 <= s, t, a, b, m, n <= 10^5
 *
 * -10^5 <= d <= 10^5
 *
 * a < s < t < b
 *
 * Output Format
 *
 * Print two integers on two different lines:
 *
 *   1.- The first integer: the number of apples that fall on Sam's house.
 *
 *   2.- The second integer: the number of oranges that fall on Sam's house.
 *
 * Sample Input
 *
 * 7 11
 * 5 15
 * 3 2
 * -2 2 1
 * 5 -6
 *
 * Sample Output
 *
 * 1
 * 1
 *
 * Explanation
 *
 * The first apple falls at position '5 - 2 = 3'.
 *
 * The second apple falls at position '5 + 2 = 7'.
 *
 * The third apple falls at position '5 + 1 = 6'.
 *
 * The first orange falls at position '15 + 5 = 20'.
 *
 * The second orange falls at position '15 - 6 = 9'.
 *
 * Only one fruit (the second apple) falls within the region between '7' and
 * '11', so we print '1' as our first line of output.
 *
 * Only the second orange falls within the region between '7' and '11', so we
 * print '1' as our second line of output.
 */

import java.util.Scanner;

public class AppleAndOrange {

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int applesInside = 0;
        int orangesInside = 0;

        // This loop counts the apples that fell inside of Sam's house location.
        for (int i = 0; i < apples.length; i++) {

            if ((apples[i] >= 0) &&
                (s <= (a + apples[i])) &&
                ((a + apples[i]) <= t)) {
                // The apple fell in the right side of the tree (towards Sam's
                // house) and the apple fell between Sam's house start and end
                // points.

                applesInside++;
            }
        }

        // This loop counts the oranges that fell inside of Sam's house
        // location.
        for (int i = 0; i < oranges.length; i++) {

            if ((oranges[i] < 0) &&
                (s <= (b + oranges[i])) &&
                ((b + oranges[i]) <= t)) {
                // The orange fell in the left side of the tree (towards Sam's
                // house) and the orange fell between Sam's house start and end
                // points.

                orangesInside++;
            }
        }

        // Prints output
        System.out.println(applesInside);
        System.out.println(orangesInside);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apples = new int[m];
        int[] oranges = new int[n];

        // Process input
        for (int i = 0; i < apples.length; i++) {
            apples[i] = in.nextInt();
        }

        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = in.nextInt();
        }
        in.close();

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}
