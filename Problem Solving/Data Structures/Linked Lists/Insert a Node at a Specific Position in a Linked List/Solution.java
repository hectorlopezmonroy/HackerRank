/*
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied
 * by a video lesson.
 *
 * You're given the pointer to the head node of a linked list, an integer to add
 * to the list and the position at which the integer must be inserted. Create a
 * new node with the given integer, insert this node at the desired position and
 * return the head node.
 *
 * A position of '0' indicates head, a position of '1' indicates one node away
 * from the head and so on. The head pointer given may be 'null', meaning that
 * the initial list is empty.
 *
 * As an example, if your list starts as '1 -> 2 -> 3' and you want to insert a
 * node at position '2' with 'data = 4', your new list should be
 * '1 -> 2 -> 4 -> 3'.
 *
 * Function Description
 *
 * Complete the function 'insertNodeAtPosition' in the editor below. It must
 * return a reference to the head node of your finished list.
 *
 * 'insertNodeAtPosition' has the following parameter(s):
 *
 *   * 'head': a 'SinglyLinkedListNode' pointer to the head of the list.
 *
 *   * 'data': an integer value to insert as data in your new node.
 *
 *   * 'position': an integer position to insert the new node, zero based
 *                 indexing.
 *
 * Input Format
 *
 * The first line contains an integer 'n', the number of elements in the linked
 * list.
 *
 * Each of the next 'n' lines contains an integer 'SinglyLinkedListNode[i].data'.
 *
 * The last line contains an integer 'position'.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= SinglyLinkedListNode[i].data <= 1000, where 'SinglyLinkedListNode[i]' is
 * the 'i-th' element of the linked list.
 *
 * 0 <= position <= n
 *
 * Output Format
 *
 * Return a reference to the list head. Locked code prints the list for you.
 *
 * Sample Input
 *
 * 3
 * 16
 * 13
 * 7
 * 1
 * 2
 *
 * Sample Output
 *
 * 16 13 1 7
 *
 * Explanation
 *
 * The initial linked list is '16 -> 13 -> 7'. We have to insert '1' at the
 * position '2' which currently has '7' in it. The updated linked list will be
 * '16 -> 13 -> 1 -> 7'.
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
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode res = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            // List is empty.
            res = newNode;
        } else {
            // Non-empty list.
            int i = 0;
            SinglyLinkedListNode tmp = head;

            // Loops through the non-empty list and finds the element previous
            // to the new element.
            while (i < position - 1) {
                tmp = tmp.next;
                i++;
            }

            // Links the newly created node at the position indicated.
            newNode.next = tmp.next;
            tmp.next = newNode;

            // In case the head is replaced.
            if (position == 0) {
                res = newNode;
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
            position = i;

            llist.head = insertNodeAtPosition(llist.head, data, position);
        }
        data = in.nextInt();
        position = in.nextInt();
        llist.head = insertNodeAtPosition(llist.head, data, position);
        in.close();

        // Prints output
        printSinglyLinkedList(llist.head);
    }
}
