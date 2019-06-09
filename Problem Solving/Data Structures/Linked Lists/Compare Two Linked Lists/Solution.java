/*
 * This challenge is part of a tutorial track by MyCodeSchool.
 *
 * You are given the pointer to the 'head' of two linked lists. Compare the data
 * in the nodes of the linked lists to check if they are equal. The lists are
 * equal only if they have the same number of nodes and corresponding nodes
 * contain the same data. Either 'head' pointer given may be 'null' meaning that
 * the corresponding list is empty.
 *
 * Input Format
 *
 * You have to complete the 'int CompareLists(Node* headA, Node* headB)' method
 * which takes two arguments - the heads of the two linked lists to compare. You
 * should NOT read any input from stdin/console.
 *
 * The input is handled by the code in the editor and the format is as follows:
 *
 * The first line contains 't', the number of test cases.
 *
 * The format for each test case is as follows:
 *
 *   * The first line contains an integer 'n', denoting the number of elements
 *     in the first linked list.
 *
 *   * The next 'n' lines contain an integer each, denoting the elements of the
 *     first linked list.
 *
 *   * The next line contains an integer 'm', denoting the number of elements
 *     in the second linked list.
 *
 *   * The next 'm' lines contain an integer each, denoting the elements of the
 *     second linked list.
 *
 * Constraints
 *
 * 1 <= t <= 10
 *
 * 1 <= n <= 1000
 *
 * 1 <= list_i <= 1000, where 'list_i' is the 'i-th' element in the list.
 *
 * Output Format
 *
 * Compare the two linked lists and 'return' '1' if the lists are equal.
 * Otherwise, 'return' '0'. Do NOT print anything to stdout/console.
 *
 * The output is handled by the code in the editor and is as follows:
 *
 * For each test case, in a new line, print '1' if the two lists are equal, else
 * print '0'.
 *
 * Sample Input
 *
 * 2
 * 2
 * 1
 * 2
 * 1
 * 1
 * 2
 * 1
 * 2
 * 2
 * 1
 * 2
 *
 * Sample Output
 *
 * 0
 * 1
 *
 * Explanation
 *
 * In the first case, linked lists are: 1 -> 2 -> null and 1 -> null.
 *
 * In the second case, linked lists are: 1 -> 2 -> null and 1 -> 2 -> null.
 */

import java.util.Scanner;

public class Solution {

    static class SinglyLinkedListNode {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {

        if (node == null) {
            System.out.println("Empty Linked List");
        } else {
            while (node != null) {
                System.out.print(node.data);
                node = node.next;

                if (node != null) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        boolean res = true;
        SinglyLinkedListNode tmp1 = head1;
        SinglyLinkedListNode tmp2 = head2;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.data != tmp2.data) {
                res = false;
                break;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        if (tmp1 != null || tmp2 != null) {
            res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SinglyLinkedList l1, l2;
        int t = in.nextInt();
        int[] results = new int[t];

        // Process input
        for (int i = 0; i < t; i++) {
            l1 = new SinglyLinkedList();
            l2 = new SinglyLinkedList();
            int n, m;

            n = in.nextInt();
            for (int j = 0; j < n; j++) {
                l1.insertNode(in.nextInt());
            }

            m = in.nextInt();
            for (int j = 0; j < m; j++) {
                l2.insertNode(in.nextInt());
            }

            results[i] = compareLists(l1.head, l2.head) ? 1 : 0;
        }
        in.close();

        // Prints output
        for (Integer res : results) {
            System.out.println(res);
        }
    }
}
