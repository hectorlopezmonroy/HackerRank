/*
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied
 * by a video lesson.
 *
 * You're given the pointer to the head node of a linked list and the position
 * of a node to delete. Delete the node at the given position and return the
 * head node. A position of '0' indicates head, a position of '1' indicates one
 * node away from the head and so on. The list may become empty after you delete
 * the node.
 *
 * Input Format
 *
 * You have to complete the
 * 'deleteNode(SinglyLinkedListNode* llist, int position)' method which takes
 * two arguments - the head of the linked list and the position of the node to
 * delete. You should NOT read any input from stdin/console. 'position' will
 * always be at least '0' and less than the number of elements in the list.
 *
 * The first line of input contains an integer 'n', denoting the number of
 * elements in the linked list.
 *
 * The next 'n' lines contain an integer each in a new line, denoting the
 * elements of the linked list in their order.
 *
 * The last line contains an integer 'position' denoting the position of the
 * node that has to be deleted from the linked list.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= list_i <= 1000, where 'list_i' is the 'i-th' element of the linked list.
 *
 * Output Format
 *
 * Delete the node at the given position and 'return' the head of the updated
 * linked list. Do NOT print anything to stdout/console.
 *
 * The code in the editor will print the updated linked list in a single line
 * separated by spaces.
 *
 * Sample Input
 *
 * 8
 * 20
 * 6
 * 2
 * 19
 * 7
 * 4
 * 15
 * 9
 * 3
 *
 * Sample Output
 *
 * 20 6 2 7 4 15 9
 *
 * Explanation
 *
 * The given linked list is '20 -> 6 -> 2 -> 19 -> 7 -> 4 -> 15 -> 9'. We have
 * to delete the node at position '3', which is '19'. After deleting that node,
 * the updated linked list is: '20 -> 6 -> 2 -> 7 -> 4 -> 15 -> 9'.
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
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode res = head;

        if (head != null) {
            // Non-empty list.
            if (position == 0) {
                // Deleting the first element of the list (head).
                if (head.next != null) {
                    // There are more elements after the head of the list.
                    res = head.next;
                    head.next = null;
                    head = res;
                } else {
                    // There's only one element in the list, the head to be
                    // removed.
                    head = null;
                }
            } else {
                // Deleting an element different than the head of the list.
                int i = 0;
                SinglyLinkedListNode tmp = head;
                SinglyLinkedListNode restOfList = null;

                // Searches the element previous to the element we're about to
                // delete.
                while (i < position - 1) {
                    tmp = tmp.next;
                    i++;
                }
                if (tmp.next != null) {
                    // There are other elements after the element we're about to
                    // delete.
                    restOfList = tmp.next.next;
                    tmp.next.next = null;
                }
                tmp.next = restOfList;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int data, position;

        // Process input
        for (int i = 0; i < n; i++) {
            data = in.nextInt();

            llist.insertNode(data);
        }
        position = in.nextInt();
        llist.head = deleteNode(llist.head, position);
        in.close();

        // Prints output
        printSinglyLinkedList(llist.head);
    }
}
