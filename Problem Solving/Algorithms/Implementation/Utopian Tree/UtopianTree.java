/*
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it
 * doubles in height. Each summer, its height increases by 1 meter.
 *
 * Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of
 * spring. How tall will her tree be after 'n' growth cycles?
 *
 * For example, if the number of growth cycles is 'n = 5', the calculations are
 * as follows:
 *
 * Period | Height
 *    0   |    1
 *    1   |    2
 *    2   |    3
 *    3   |    6
 *    4   |    7
 *    5   |   14
 *
 * Function Description
 *
 * Complete the 'utopianTree' function in the editor below. It should return the
 * integer height of the tree after the input number of growth cycles.
 *
 * 'utopianTree' has the following parameter(s):
 *
 *   * 'n': an integer, the number of growth cycles to simulate.
 *
 * Input Format
 *
 * The first line contains an integer, 't', the number of test cases.
 *
 * 't' subsequent lines each contain an integer, 'n', denoting the number of
 * cycles for that test case.
 *
 * Constraints
 *
 * 1 <= t <= 10
 *
 * 0 <= n <= 60
 *
 * Output Format
 *
 * For each test case, print the height of the Utopian Tree after 'n' cycles.
 * Each height must be printed on a new line.
 *
 * Sample Input
 *
 * 3
 * 0
 * 1
 * 4
 *
 * Sample Output
 *
 * 1
 * 2
 * 7
 *
 * Explanation
 *
 * There are 3 test cases.
 *
 * In the first case ('n = 0'), the initial height ('H = 1') of the tree remains
 * unchanged.
 *
 * In the second case ('n = 1'), the tree doubles in height and is '2' meters
 * tall after the spring cycle.
 *
 * In the third case ('n = 4'), the tree doubles its height in spring
 * ('n = 1', 'H = 2'), then grows a meter in summer ('n = 2', 'H = 3'), then
 * doubles after the next spring ('n = 3', 'H = 6'), and grows another meter
 * after summer ('n = 4', 'H = 7'). Thus, at the end of 4 cycles, its height is
 * '7' meters.
 */

import java.util.Scanner;

public class UtopianTree {

    private static int[] resultsTable = new int[61];

    /** Builds a table with the results of growth cycles up to a maximum of 61.
     * Using Dynamic Programming, builds a table of growth cycles' results
     * accesible via the 'utopianTree' function.
     * @param integer max denoting the maximum growth cycle in the test cases.
     */
    UtopianTree(int max) {

        resultsTable[0] = 1;

        for (int i = 1; i <= max; i++) {
            if (i % 2 == 0) {
                // if the growth cycle is even it denotes a summer.
                resultsTable[i] = resultsTable[i - 1] + 1;
            } else {
                // if the growth cycle is odd it denotes a spring.
                resultsTable[i] = resultsTable[i - 1] * 2;
            }
        }
    }

    static int utopianTree(int n) {
        int res = 0;

        res = resultsTable[n];
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UtopianTree laurasTree;
        int maxGrowthCycle = -1;
        int testCasesCount = in.nextInt();
        int[] testCases = new int[testCasesCount];

        // Process input
        for (int i = 0; i < testCasesCount; i++) {
            testCases[i] = in.nextInt();

            if (testCases[i] > maxGrowthCycle) {
                // Updates the maximum growth cycle found
                maxGrowthCycle = testCases[i];
            }
        }
        in.close();

        laurasTree = new UtopianTree(maxGrowthCycle);

        // Prints output
        for (int x: testCases) {
            System.out.println(laurasTree.utopianTree(x));
        }
    }
}
