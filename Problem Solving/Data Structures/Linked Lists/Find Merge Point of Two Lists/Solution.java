/*
 * This challenge is part of a tutorial track by MyCodeSchool.
 *
 * Given pointers to the head nodes of '2' linked lists that merge together at
 * some point, find the Node where the two lists merge. It is guaranteed that
 * the two head Nodes will be different, and neither will be 'null'.
 *
 * In the diagram below, the two lists converge at Node 'x':
 *
 *   [List #1] a-->b-->c
 *                   \
 *                    x-->y-->z-->null
 *                   /
 *       [List #2] p-->q
 *
 * Complete the
 * 'int findMergeNode(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2)'
 * method so that it finds and returns the data value of the Node where the two
 * lists merge.
 *
 * Input Format
 *
 * Do not read any input from stdin/console.
 *
 * The 'findMergeNode(SinglyLinkedListNode, SinglyLinkedListNode)' method has
 * two parameters, 'head1' and 'head2', which are the non-null head Nodes of two
 * separate linked lists that are guaranteed to converge.
 *
 * Constraints
 *
 * The lists will merge.
 *
 * 'head1', 'head2' != 'null'
 *
 * 'head1' != 'head2'
 *
 * Output Format
 *
 * Do not write any output to stdout/console.
 *
 * Each Node has a data field containing an integer. Return the integer data for
 * the Node where the two lists merge.
 *
 * Sample Input
 *
 * The diagrams below are graphical representations of the lists that input
 * Nodes 'headA' and 'headB' are connected to. Recall that this is a method-only
 * challenge; the method only has initial visibility to those '2' Nodes and must
 * explore the rest of the Nodes using some algorithm of your own design.
 *
 * Test Case 0
 *
 *   1
 *    \
 *     2-->3-->null
 *    /
 *   1
 *
 * Test Case 1
 *
 *   1-->2
 *        \
 *         3-->null
 *        /
 *       1
 *
 * Sample Output
 *
 * 2
 * 3
 *
 * Explanation
 *
 * Test Case 0: As demonstrated in the diagram above, the merge Node's data
 * field contains the integer '2'.
 *
 * Test Case 1: As demonstrated in the diagram above, the merge Node's data
 * field contains the integer '3'.
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
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(" ");
            }
        }
        System.out.println("");
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
    static int findMergeNode(SinglyLinkedListNode head1,
                             SinglyLinkedListNode head2) {
        int res = 0;
        boolean mergeIsFound = false;
        SinglyLinkedListNode tmp1 = head1;
        SinglyLinkedListNode tmp2 = head2;

        while (!mergeIsFound && tmp1 != null) {

            tmp2 = head2;
            while (!mergeIsFound && tmp2 != null) {

                if (tmp1 == tmp2) {
                    res = tmp1.data;
                    mergeIsFound = true;
                }
                tmp2 = tmp2.next;
            }
            tmp1 = tmp1.next;
        }

        return res;
    }

    public static void main(String[] args) {
        int result;
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int llist1Count;
            int llist2Count;
            int index = in.nextInt();
            SinglyLinkedListNode ptr1;
            SinglyLinkedListNode ptr2;
            SinglyLinkedList llist1 = new SinglyLinkedList();
            SinglyLinkedList llist2 = new SinglyLinkedList();

            // Initialize list1.
            llist1Count = in.nextInt();
            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = in.nextInt();

                llist1.insertNode(llist1Item);
            }

            // Initialize list2.
            llist2Count = in.nextInt();
            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = in.nextInt();

                llist2.insertNode(llist2Item);
            }

         	ptr1 = llist1.head;
            ptr2 = llist2.head;

            for (int i = 0; i < llist1Count; i++) {
                if (i < index) {
                    ptr1 = ptr1.next;
                }
            }

            for (int i = 0; i < llist2Count; i++) {
                if (i != llist2Count - 1) {
                    ptr2 = ptr2.next;
                }
            }

            ptr2.next = ptr1;

            result = findMergeNode(llist1.head, llist2.head);

            System.out.println(result);
        }
        in.close();
    }
}
