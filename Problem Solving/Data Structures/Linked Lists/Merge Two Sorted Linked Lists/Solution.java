/*
 * This challenge is part of a tutorial track by MyCodeSchool.
 *
 * You are given the pointer to the 'head' nodes of two sorted linked list. The
 * data in both lists will be sorted in ascending order. Change the 'next'
 * pointers to obtain a single, merged linked list which also has data in
 * ascending order. Either head pointer given may be 'null' meaning that the
 * corresponding list is empty.
 *
 * Input Format
 *
 * You have to complete the
 *
 * 'SinglyLinkedListNode MergeLists(SinglyLinkedListNode headA,
 *                                  SinglyLinkedListNode headB)'
 *
 * method which takes two arguments - the heads of the two sorted linked lists
 * to merge. You should NOT read any input from stdin/console.
 *
 * The input is handled by the code in the editor and the format is as follows:
 *
 * The first line contains an integer 't', denoting the number of test cases.
 *
 * The format for each test case is as follows:
 *
 *   * The first line contains an integer 'n', denoting the length of the first
 *     linked list.
 *
 *   * The next 'n' lines contain an integer each, denoting the elements of the
 *     linked list.
 *
 *   * The next line contains an integer 'm', denoting the length of the second
 *     linked list.
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
 * Change the 'next' pointer of individual nodes so that nodes from both lists
 * are merged into a single list. Then 'return' the 'head' of this merged list.
 * Do NOT print anything to stdout/console.
 *
 * The output is handled by the code in the editor and the format is as follows:
 *
 * For each test case, print in a new line, the linked list after merging them
 * separated by spaces.
 *
 * Sample Input
 *
 * 1
 * 3
 * 1
 * 2
 * 3
 * 2
 * 3
 * 4
 *
 * Sample Output
 *
 * 1 2 3 3 4
 *
 * Explanation
 *
 * The first linked list is: 1 -> 2 -> 3 -> null.
 *
 * The second linked list is: 3 -> 4 -> null.
 *
 * Hence, the merged linked list is: 1 -> 2 -> 3 -> 3 -> 4 -> null.
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
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1,
                                           SinglyLinkedListNode head2) {
        SinglyLinkedListNode res = null;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = null;
        SinglyLinkedListNode tmp1 = head1;
        SinglyLinkedListNode tmp2 = head2;

        if (head1 == null && head2 != null) {
            // First linked list is empty.
            res = head2;
        } else if (head1 != null && head2 == null) {
            // Second linked list is empty.
            res = head1;
        } else if (head1 != null && head2 != null) {
            // Both linked list are non-empty.

            while (tmp1 != null && tmp2 != null) {
                if (res == null) {
                    // First node is added to the merge of both linked lists.
                    res = tmp1.data < tmp2.data ? tmp1 : tmp2;

                    if (res == tmp1) {
                        tmp1 = tmp1.next;
                    } else {
                        tmp2 = tmp2.next;
                    }
                    prev = res;
                } else {
                    // While both linked lists have elements, add the smaller
                    // element to the merge of both linked lists.
                    curr = tmp1.data < tmp2.data ? tmp1 : tmp2;

                    if (curr == tmp1) {
                        tmp1 = tmp1.next;
                    } else {
                        tmp2 = tmp2.next;
                    }
                    prev.next = curr;
                    prev = curr;
                }
            }

            if (tmp1 != null && tmp2 == null) {
                // Linked list 1 still has some elements but all elements from
                // linked list 2 were added to the merge of both linked lists.
                prev.next = tmp1;
                tmp1 = null;
            } else if (tmp1 == null && tmp2 != null) {
                // Linked list 2 still has some elements but all elements from
                // linked list 1 were added to the merge of both linked lists.
                prev.next = tmp2;
                tmp2 = null;
            }
        }

        head1 = null;
        head2 = null;

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SinglyLinkedList l1, l2, result;
        int t = in.nextInt();

        // Process input
        for (int i = 0; i < t; i++) {
            int n, m;
            l1 = new SinglyLinkedList();
            l2 = new SinglyLinkedList();
            result = new SinglyLinkedList();

            n = in.nextInt();
            for (int j = 0; j < n; j++) {
                int data = in.nextInt();

                l1.insertNode(data);
            }

            m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int data = in.nextInt();

                l2.insertNode(data);
            }

            result.head = mergeLists(l1.head, l2.head);

            // Prints output
            printSinglyLinkedList(result.head);
        }
        in.close();
    }
}
