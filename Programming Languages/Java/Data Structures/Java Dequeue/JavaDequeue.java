/*
 * In computer science, a double-ended queue (dequeue, often abbreviated to
 * deque, pronounced deck) is an abstract data type that generalizes a queue,
 * for which elements can be added to or removed from either the front (head) or
 * back (tail).
 *
 * Deque interfaces can be implemented using various types of collections such
 * as 'LinkedList' or 'ArrayDeque' classes. For example, deque can be declared
 * as:
 *
 *   Deque deque = new LinkedList<>();
 *
 *   or
 *
 *   Deque deque = new ArrayDeque<>();
 *
 * You can find more details about Deque here:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
 *
 * In this problem, you are given 'N' integers. You need to find the maximum
 * number of unique integers among all the possible contiguous subarrays of size
 * 'M'.
 *
 * Note: Time limit is 3 seconds for this problem.
 *
 * Input Format
 *
 * The first line of input contains two integers 'N' and 'M': representing the
 * total number of integers and the size of the subarray, respectively. The next
 * line contains 'N' space-separated integers.
 *
 * Constraints
 *
 * 1 <= N <= 100000
 *
 * 1 <= M <= 100000
 *
 * M <= N
 *
 * The numbers in the array will range between [0, 10000000].
 *
 * Output Format
 *
 * Print the 'maximum' number of unique integers among all possible contiguous
 * subarrays of size 'M'.
 *
 * Sample Input
 *
 * 6 3
 * 5 3 5 2 3 2
 *
 * Sample Output
 *
 * 3
 *
 * Explanation
 *
 * In the sample testcase, there are 4 subarrays of contiguous numbers.
 *
 * s1 = <5, 3, 5> - Has 2 unique numbers.
 *
 * s2 = <3, 5, 2> - Has 3 unique numbers.
 *
 * s3 = <5, 2, 3> - Has 3 unique numbers.
 *
 * s4 = <2, 3, 2> - Has 2 unique numbers.
 *
 * In these subarrays, there are 2, 3, 3, 2 unique numbers, respectively. The
 * maximum amount of unique numbers among all possible contiguous subarrays is
 * 3.
 */

import java.util.Deque;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayDeque;

public class JavaDequeue {

    public static void main(String[] args) {
        int max = 0;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        HashSet<Integer> mySet = new HashSet<Integer>();
        Deque<Integer> myDequeue = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            int elem = in.nextInt();

            myDequeue.add(elem);
            mySet.add(elem);
            if (myDequeue.size() == M) {
                if (mySet.size() > max) {
                    max = mySet.size();
                }
                if (max == M) {
                    while (in.hasNext()) {
                        in.nextLine();
                    }
                    break;
                }
                int first = myDequeue.remove();
                if (!myDequeue.contains(first)) {
                    mySet.remove(first);
                }
            }
        }
        in.close();
        System.out.println(max);
    }
}
