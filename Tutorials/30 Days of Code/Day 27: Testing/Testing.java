/*
 * Objective
 * This challenge is very different from the others we've completed because it
 * requires you to 'generate a valid test case' for a problem 'instead of'
 * solving the problem. There is no input to read, you simply have to generate
 * and print test values for the problem that satisfy both the problem's 'Input
 * Format' and the criteria laid out in the 'Task' section. Check out the
 * Tutorial tab for an instructional video on testing!
 *
 * Consider the following problem ('but do not solve it'):
 *
 *   Problem Statement
 *
 *   A Discrete Mathematics professor has a class of 'n' students. Frustrated
 *   with their lack of discipline, the professor decides to cancel class if
 *   fewer than 'k' students are present when class starts. Given the arrival
 *   time of each student, determine if the class is canceled.
 *
 *   Input Format
 *
 *   The first line of input contains 't', the number of lectures.
 *   The information for each lecture spans two lines. The first line has
 *   two space-separated integers, 'n' (the number of students in the class) and
 *   'k' (the cancelation threshold). The second line contains 'n'
 *   space-separated integers describing the array of students' arrival times
 *   (A = a_0, a_1, ... , a_(n - 1)).
 *
 *   Note: Non-positive arrival times (a_i <= 0) indicate the student arrived
 *   early or on time; positive arrival times (a_i > 0) indicate the student
 *   arrived a_i minutes late. If a student arrives exactly on time (a_i = 0),
 *   the student is considered to have entered before the class started.
 *
 *   Output Format
 *
 *   For each test case, print the word "YES" if the class is canceled or "NO"
 *   if it is not.
 *
 *   Example
 *
 *   When properly solved, this input:
 *
 *     2
 *     4 3
 *     -1 -3 4 2
 *     4 2
 *     0 -1 2 1
 *
 *   Produces this output:
 *
 *     YES
 *     NO
 *
 *   For the first test case, k = 3. The professor wants at least 3 students in
 *   attendance, but only 2 arrive on time (-3 and -1). Thus, the class is
 *   canceled.
 *
 *   For the second test case, k = 2. The professor wants at least 2 students in
 *   attendance, and 2 do arrive on time (0 and -1). Thus, the class is 'not'
 *   canceled.
 *
 * Task
 * Create and print a test case for the problem above that meet the following
 * criteria:
 *
 * t <= 5
 *
 * 3 <= n <= 200
 *
 * 1 <= k <= n
 *
 * -10^3 <= a_i <= 10^3, where i belongs [1, n]
 *
 * The value of 'n' must be 'distinct' across all the test cases.
 *
 * Array 'A' must have at least 1 zero, 1 positive integer, and 1 negative
 * integer.
 *
 * Scoring
 *
 * If you submit 'x' correct test cases, you will earn (20 * x) % of the maximum
 * score. 'You must submit 5 test cases to earn the maximum possible score'.
 *
 * Input Format
 *
 * You are not responsible for reading anything from stdin.
 *
 * Output Format
 *
 * Print 11 lines of output that can be read by the Professor challenge as valid
 * input. Your test case must result in the following output when fed as input
 * to the Professor challenge's solution:
 *
 *   YES
 *   NO
 *   YES
 *   NO
 *   YES
 *
 * Explanation
 *
 * Your code must print lines of output that follow the 'Input Format' in the
 * Professor challenge above. For example, this partial solution to this
 * challenge:
 *
 *   print('2')
 *   print('4 3')
 *   print('-1 -3 4 2')
 *   print('5 2')
 *   print('0 -1 2 1 4')
 *
 * prints the following output that can be used as valid input for the Professor
 * challenge:
 *
 *   2
 *   4 3
 *   -1 -3 4 2
 *   5 2
 *   0 -1 2 1 4
 *
 * When read by a valid solution to the Professor challenge, it produces the
 * following output:
 *
 *   YES
 *   NO
 *
 * You must do something similar to this, except that the test case you develop
 * must meet the constraints set in the 'Task' section above.
 */

import java.util.Set;
import java.util.Random;
import java.util.HashSet;

class TestCase {

    public int n;                   // Number of students
    public int k;                   // Minimum attendance required by Professor
    public int[] A;                 // Students' arrival times
    public int indexOfZero;
    public int indexOfPosInteger;
    public int indexOfNegInteger;
    public boolean isClassCanceled;

    TestCase(Testing t, boolean b) {
        this.n = t.pickRandomN();
        this.A = new int[this.n];
        this.isClassCanceled = b;
        this.k = this.isClassCanceled ? (t.rand.nextInt(this.n) + 1) :
                 (t.rand.nextInt(this.n - 1) + 1);

        this.indexOfZero = t.rand.nextInt(this.n);
        this.indexOfPosInteger = generateRandomIndexPosInteger(t.rand);
        this.indexOfNegInteger = generateRandomIndexNegInteger(t.rand);
        generateRandomArrivalTimes(t.rand);
    }

    private int generateRandomIndexPosInteger(Random rand) {
        int res = this.indexOfZero;

        // Generating a random index for the positive integer that MUST be
        // in array A.
        while (res == this.indexOfZero) {
            res = rand.nextInt(this.n);
        }
        return res;
    }

    private int generateRandomIndexNegInteger(Random rand) {
        int res = this.indexOfZero;

        // Generating a random index for the negative integer that MUST be
        // in array A.
        while (res == this.indexOfZero ||
               res == this.indexOfPosInteger) {
            res = rand.nextInt(this.n);
        }
        return res;
    }

    private int generateRandomPosArrivalTime(Random rand) {
        return rand.nextInt((int) Math.pow(10, 3)) + 1;
    }

    private int generateRandomNegArrivalTime(Random rand) {
        return -1 * (rand.nextInt((int) Math.pow(10, 3)) + 1);
    }

    private void generateClassArrivalTimes(Random rand) {
        int negIntegersCount = 2; // There is at least two students on time in A
        int negIntegersBound = this.isClassCanceled ?
                               rand.nextInt(this.k - 2) + 2 :
                               (rand.nextInt(this.n - this.k) + this.k);

        for (int i = 0; i < this.A.length; i++) {
            if (i != this.indexOfZero &&
                i != this.indexOfPosInteger &&
                i != this.indexOfNegInteger) {
                if (negIntegersCount < negIntegersBound) {
                    this.A[i] = generateRandomNegArrivalTime(rand);
                    negIntegersCount++;
                } else {
                    this.A[i] = generateRandomPosArrivalTime(rand);
                }
            }
        }
    }

    private void generateRandomArrivalTimes(Random rand) {
        this.A[this.indexOfPosInteger] = generateRandomPosArrivalTime(rand);
        this.A[this.indexOfNegInteger] = generateRandomNegArrivalTime(rand);

        generateClassArrivalTimes(rand);
    }

    public void display() {
        System.out.println(this.n + " " + this.k);
        for (int i : this.A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class Testing {

    int t;
    public Random rand;
    public Set<Integer> nValues;

    Testing(int t) {
        this.t = t;
        this.rand = new Random();
        this.nValues = new HashSet<>();
    }

    public int pickRandomN() {
        int n = this.rand.nextInt((200 - 3) + 1) + 3;

        // Making sure all our test cases have a different value of n.
        while (this.nValues.contains(n)) {
            n = this.rand.nextInt((200 - 3) + 1) + 3;
        }
        this.nValues.add(n);
        return n;
    }

    public TestCase generateCanceledClass() {
        // Since the class is canceled, the boolean parameter is true.
        return new TestCase(this, true);
    }

    public TestCase generateNonCanceledClass() {
        // Since the class isn't canceled, the boolean parameter is false.
        return new TestCase(this, false);
    }

    public void generateTestCase() {
        TestCase tc;

        System.out.println(this.t);
        for (int i = 0; i < this.t; i++) {
            if (i % 2 != 0) {
                tc = generateNonCanceledClass();
            } else {
                tc = generateCanceledClass();
            }
            tc.display();
        }
    }

    public static void main(String[] args) {
        int t = 5;
        Testing solution = new Testing(t);

        solution.generateTestCase();
    }
}
