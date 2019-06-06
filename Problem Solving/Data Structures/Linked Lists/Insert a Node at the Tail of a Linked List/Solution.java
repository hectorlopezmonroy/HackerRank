/*
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied
 * by a video lesson.
 *
 * You are given the pointer to the head node of a linked list and an integer to
 * add to the list. Create a new node with the given integer. Insert this node
 * at the tail of the linked list and return the head node of the linked list
 * formed after inserting this new node. The given head pointer may be 'null',
 * meaning that the initial list is empty.
 *
 * Input Format
 *
 * You have to complete the
 * 'SinglyLinkedListNode insertAtTail(SinglyLinkedListNode head, int data)'
 * method. It takes two arguments: the head of the linked list and the integer
 * to insert at the tail. You should 'not' read any input from the
 * stdin/console.
 *
 * The input is handled by the locked code below and is as follows:
 *
 * The first line contains an integer 'n', denoting the number of elements of
 * the linked list.
 *
 * The next 'n' lines contain an integer each, denoting the element that needs
 * to be inserted at the tail.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= list_i <= 1000
 *
 * Output Format
 *
 * Insert the new node at the tail and just 'return' the head of the updated
 * linked list. Do 'not' print anything to stdout/console.
 *
 * The output is handled by code in the editor and is as follows:
 *
 * Print the elements of the linked list from head to tail, each in a new line.
 *
 * Sample Input
 *
 * 5
 * 141
 * 302
 * 164
 * 530
 * 474
 *
 * Sample Output
 *
 * 141
 * 302
 * 164
 * 530
 * 474
 *
 * Explanation
 *
 * First the linked list is 'null'. After inserting '141', the list is
 * 141 -> null.
 *
 * After inserting '302', the list is 141 -> 302 -> null.
 *
 * After inserting '164', the list is 141 -> 302 -> 164 -> null.
 *
 * After inserting '530', the list is 141 -> 302 -> 164 -> 530 -> null.
 *
 * After inserting '474', the list is 141 -> 302 -> 164 -> 530 -> 474 -> null,
 * which is the final list.
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

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        if (node == null) {
            System.out.println("Empty Linked List");
        } else {
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
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
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode res = head;

        if (head == null) {
            // List is empty.
            res = new SinglyLinkedListNode(data);
        } else {
            // Non-empty list.
            SinglyLinkedListNode tmp = head;
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

            // Loops through the non-empty list and finds the last element.
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            // Links the newly created node at the end of the list.
            tmp.next = newNode;
        }
        return res;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Process input
        for (int i = 0; i < n; i++) {
            int elem = in.nextInt();
            llist.head = insertNodeAtTail(llist.head, elem);
        }
        in.close();

        // Prints output
        printSinglyLinkedList(llist.head);
    }
}
