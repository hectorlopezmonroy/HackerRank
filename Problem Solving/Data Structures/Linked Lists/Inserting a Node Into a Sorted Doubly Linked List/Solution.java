/*
 * Given a reference to the head of a doubly-linked list and an integer, 'data',
 * create a new DoublyLinkedListNode object having data value 'data' and insert
 * it into a sorted linked list while maintaining the sort.
 *
 * Function Description
 *
 * Complete the 'sortedInsert' function in the editor below. It must return a
 * reference to the head of your modified 'DoublyLinkedList'.
 *
 * 'sortedInsert' has two parameters:
 *
 *   1.- 'head': A reference to the head of a doubly-linked list of
 *       DoublyLinkedListNode objects.
 *
 *   2.- 'data': An integer denoting the value of the 'data' field for the
 *       DoublyLinkedListNode you must insert into the list.
 *
 * Note: Recall that an empty list (i.e., where 'head == null') and a list with
 * one element are sorted lists.
 *
 * Input Format
 *
 * The first line contains an integer 't', the number of test cases.
 *
 * Each of the test cases is in the following format:
 *
 *   * The first line contains an integer 'n', the number of elements in the
 *     linked list.
 *
 *   * Each of the next 'n' lines contains an integer, the data for each node of
 *     the linked list.
 *
 *   * The last line contains an integer 'data' which needs to be inserted into
 *     the sorted doubly-linked list.
 *
 * Constraints
 *
 * 1 <= t <= 10
 *
 * 1 <= n <= 1000
 *
 * 1 <= DoublyLinkedListNode.data <= 1000
 *
 * Output Format
 *
 * 'Do not print anything to stdout'. Your method must return a reference to the
 * 'head' of the same list that was passed to it as a parameter.
 *
 * The output is handled by the code in the editor and is as follows:
 *
 * For each test case, print the elements of the sorted doubly-linked list
 * separated by spaces on a new line.
 *
 * Sample Input
 *
 * 1
 * 4
 * 1
 * 3
 * 4
 * 10
 * 5
 *
 * Sample Output
 *
 * 1 3 4 5 10
 *
 * Explanation
 *
 * The initial doubly-linked list is: 1 <-> 3 <-> 4 <-> 10 -> null.
 * The doubly-linked list after insertion is: 1 <-> 3 <-> 4 <-> 5 <-> 10 -> null.
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
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode res = head;

        if (head == null) {
            // Empty list.
            res = new DoublyLinkedListNode(data);
        } else {
            // Non-empty list.
            DoublyLinkedListNode tmp = head;
            DoublyLinkedListNode myNode = new DoublyLinkedListNode(data);

            while (tmp.data < data && tmp.next != null) {
                tmp = tmp.next;
            }

            if (data <= tmp.data) {
                // There's a node with a data value greater than myNode.
                myNode.next = tmp;
                myNode.prev = tmp.prev;

                if (head == tmp) {
                    // myNode.data is less than head.data.
                    // Now myNode is should be the head of the list.
                    head = myNode;
                    res = myNode;
                } else {
                    tmp.prev.next = myNode;
                }
                tmp.prev = myNode;
            } else {
                // There isn't a node with a data value greater than myNode.
                myNode.next = tmp.next;
                myNode.prev = tmp;
                tmp.next = myNode;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int data = 0;
            int llistCount = in.nextInt();
            DoublyLinkedList llist = new DoublyLinkedList();

            for (int j = 0; j < llistCount; j++) {
                int llistItem = in.nextInt();

                llist.insertNode(llistItem);
            }
            data = in.nextInt();

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1);
        }
        in.close();
    }
}
