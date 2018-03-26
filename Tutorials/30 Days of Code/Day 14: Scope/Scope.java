/*
 * Objective
 * Today we're discussing 'scope'. Check out the Tutorial tab for learning
 * materials and an instructional video!
 *
 * The 'absolute difference' between two integers, 'a' and 'b', is written as
 * |a - b|. The 'maximum absolute difference' between two integers in a set of
 * positive integers, 'elements', is the largest absolute difference between any
 * two integers in 'elements'.
 *
 * The 'Difference' class is started for you in the editor. It has a private
 * integer array ('elements') for storing 'N' non-negative integers, and a
 * public integer ('maximumDifference') for storing the maximum absolute
 * difference.
 *
 * Task
 * Complete the 'Difference' class by writing the following:
 *
 *   * A class constructor that takes an array of integers as a parameter and
 *     saves it to the 'elements' instance variable.
 *
 *   * A 'computeDifference' method that finds the maximum absolute difference
 *     between any 2 numbers in 'N' and stores it in the 'maximumDifference'
 *     instance variable.
 *
 * Input Format
 *
 * You are not responsible for reading any input from stdin. The locked 'Scope'
 * class in your editor reads in 2 lines of input; the first line contains 'N',
 * and the second line describes the 'elements' array.
 *
 * Constraints
 *
 * 1 <= N <= 10
 *
 * 1 <= elements[i] <= 100, where 0 <= i <= N - 1
 *
 * Output Format
 *
 * You are not responsible for printing any output; the 'Scope' class will print
 * the value of the 'maximumDifference' instance variable.
 *
 * Sample Input
 *
 * 3
 * 1 2 5
 *
 * Sample Output
 *
 * 4
 *
 * Explanation
 *
 * The scope of the 'elements' array and 'maximumDifference' integer is the
 * entire class instance. The class constructor saves the argument passed to the
 * constructor as the 'elements' instance variable (where the
 * 'computeDifference' method can access it).
 *
 * To find the maximum difference, 'computeDifference' checks each element in
 * the array and finds the maximum difference between any 2 elements:
 *
 *   |1 - 2| = 1
 *   |1 - 5| = 4
 *   |2 - 5| = 3
 *
 * The maximum of these differences is 4, so it saves the value 4 as the
 * 'maximumDifference' instance variable. The locked stub code in the editor
 * then prints the value stored as 'maximumDifference', which is 4.
 */

import java.util.Scanner;

class Difference {

    private int[] elements;
    public int maximumDifference;

    Difference(int[] a) {
        this.maximumDifference = -1;
        this.elements = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            elements[i] = a[i];
        }
    }

    public void computeDifference() {
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                int tmp = Math.abs(elements[i] - elements[j]);

                if (tmp > this.maximumDifference) {
                    this.maximumDifference = tmp;
                }
            }
        }
    }
}

public class Scope {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];

        // Process input
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }
        in.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        // Prints output as requested
        System.out.println(difference.maximumDifference);
    }
}
