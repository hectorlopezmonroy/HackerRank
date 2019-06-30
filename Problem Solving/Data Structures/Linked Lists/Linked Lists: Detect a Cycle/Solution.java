/*
 * A linked list is said to contain a cycle if any node is visited more than
 * once while traversing the list. For example, in the following graph there is
 * a cycle formed when node '5' points back to node '3'.
 *
 *   1->2->3->4->5
 *         ^____/
 *
 * Function Description
 *
 * Complete the function 'hasCycle' in the editor below. It must return a
 * boolean 'true' if the graph contains a cycle, or 'false' otherwise.
 *
 * 'hasCycle' has the following parameter(s):
 *
 *   * 'head': a pointer to a Node object that points to the head of a linked
 *             list.
 *
 * Note: If the list is empty, 'head' will be 'null'.
 *
 * Input Format
 *
 * There is no input for this challenge. A random linked list is generated at
 * runtime and passed to your function.
 *
 * Constraints
 *
 * 0 <= list size <= 100
 *
 * Output Format
 *
 * If the list contains a cycle, your function must return 'true'. If the list
 * does not contain a cycle, it must return 'false'. The binary integer
 * corresponding to the boolean value returned by your function is printed to
 * stdout by our hidden code checker.
 *
 * Sample Input
 *
 * The following linked lists are passed as arguments to your function:
 *
 *   1->null
 *
 *   1->2->3
 *      ^_/
 *
 * Sample Output
 *
 * 0
 * 1
 *
 * Explanation
 *
 * 1.- The first list has no cycle, so we return 'false' and the hidden code
 *     checker prints '0' to stdout.
 *
 * 2.- The second list has a cycle, so we return 'true' and the hidden code
 *     checker prints '1' to stdout.
 */

/*
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if
 * the list is empty.
 *
 * A Node is defined as:
 *   class Node {
 *       int data;
 *       Node next;
 *   }
 */

import java.util.Set;
import java.util.HashSet;

boolean hasCycle(Node head) {
    boolean res = false;
    Set<Node> nodesVisited = new HashSet<>();

    if (head != null) {
        Node tmp = head;

        while (tmp.next != null) {
            if (nodesVisited.contains(tmp)) {
                res = true;
                break;
            } else {
                nodesVisited.add(tmp);
            }
            tmp = tmp.next;
        }
    }
    return res;
}
