/*
 * This challenge is part of a tutorial track by MyCodeSchool.
 *
 * You're given the pointer to the head node of a doubly linked list. Reverse
 * the order of the nodes in the list. The 'head' node might be 'null' to
 * indicate that the list is empty. Change the 'next' and 'prev' pointers of all
 * the nodes so that the direction of the list is reversed. Return a reference
 * to the 'head' node of the reversed list.
 *
 * Function Description
 *
 * Complete the 'reverse' function in the editor below. It should return a
 * reference to the 'head' of your reversed list.
 *
 * 'reverse' has the following parameter(s):
 *
 *   * 'head': a reference to the head of a DoublyLinkedList.
 *
 * Input Format
 *
 * The first line contains an integer 't', the number of test cases.
 *
 * Each test case is of the following format:
 *
 *   * The first line contains an integer 'n', the number of elements in the
 *     linked list.
 *
 *   * The next 'n' lines contain an integer each denoting an element of the
 *     linked list.
 *
 * Constraints
 *
 * 1 <= t <= 10
 *
 * 0 <= n <= 1000
 *
 * 0 <= DoublyLinkedListNode.data <= 1000
 *
 * Output Format
 *
 * Return a reference to the head of your reversed list. The provided code will
 * print the reverse array as a one line of space-separated integers for each
 * test case.
 *
 * Sample Input
 *
 * 1
 * 4
 * 1
 * 2
 * 3
 * 4
 *
 * Sample Output
 *
 * 4 3 2 1
 *
 * Explanation
 *
 * The initial doubly linked list is: 1 <-> 2 <-> 3 <-> 4 -> null.
 * The reversed doubly linked list is: 4 <-> 3 <-> 2 <-> 1 -> null.
 */

import java.util.Scanner;

public class Solution {

    static class DoublyLinkedListNode {

        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {

        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
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
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode res = null;

        if (head != null) {
            DoublyLinkedListNode tmp = head;

            while (tmp.next != null) {
                tmp = tmp.next;
            }

            // We take the new head of the reversed doubly linked list.
            res = tmp;

            while (tmp != null) {
                DoublyLinkedListNode swap = tmp.next;

                tmp.next = tmp.prev;
                tmp.prev = swap;
                tmp = tmp.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = in.nextInt();

            for (int i = 0; i < llistCount; i++) {
                int llistItem = in.nextInt();

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1);
        }
        in.close();
    }
}
