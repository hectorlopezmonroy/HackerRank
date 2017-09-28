/*
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the
 * two challenges, awarding points on a scale from 1 to 100 for three
 * categories: problem clarity, originality and difficulty.
 *
 * We define the rating for Alice's challenge to be the triplet A = (a0, a1, a2)
 * and the rating for Bob's challenge to be the triplet B = (bo, b1, b2).
 *
 * Your task is to find their comparison points by comparing a0 with b0, a1 with
 * b1 and a2 with b2.
 *
 * If ai > bi, then Alicia is awarded 1 point.
 *
 * If ai < bi, then Bob is awarded 1 point.
 *
 * If ai = bi, then neither person receives a point.
 *
 * Comparison points is the total points a person earned.
 *
 * Input Format
 *
 * The first line constains 3 space-separated integers, a0, a1 and a2 describing
 * the respective values in triplet A.
 * The second line constains 3 space-separated integers, b0, b1 and b2
 * describing the respective values in triplet B.
 *
 * Constraints
 *
 * 1 <= ai <= 100
 * 1 <= bi <= 100
 *
 * Output Format
 *
 * Print two space-separated integers denoting the respective comparison points
 * earned by Alice and Bob.
 *
 * Sample Input
 *
 * 5 6 7
 * 3 6 10
 *
 * Sample Output
 *
 * 1 1
 *
 * Explanation
 *
 * In this example:
 *
 * A = (a0, a1, a2) = (5, 6, 7)
 * B = (b0, b1, b2) = (3, 6, 10)
 *
 * Alice's comparison score is 1, and Bob's comparison score is 1. Thus we
 * print 1 1 (Alice's comparison score followed by Bob's comparison score) on a
 * single line.
 */

import java.util.Scanner;

public class CompareTheTriplets {

	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        int[] res = {0, 0};

        if (a0 > b0) {
            res[0]++;
        } else if (a0 < b0) {
            res[1]++;
        }
        if (a1 > b1) {
            res[0]++;
        } else if (a1 < b1) {
            res[1]++;
        }
        if (a2 > b2) {
            res[0]++;
        } else if (a2 < b2) {
            res[1]++;
        }
        return res;
    }

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();

		int[] result = solve(a0, a1, a2, b0, b1, b2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");
		in.close();
    }
}
