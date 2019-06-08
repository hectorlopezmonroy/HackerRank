/*
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied
 * by a video lesson.
 *
 * You are given the pointer to the head node of a linked list. Change the 'next'
 * pointers of the nodes so that their order is reversed. The head pointer may
 * be 'null' meaning that the list is empty.
 *
 * Input Format
 *
 * You have to complete the
 * 'SinglyLinkedListNode reverse(SinglyLinkedListNode head)' method which takes
 * one argument - the head of the linked list. You should NOT read any input
 * from stdin/console.
 *
 * The first line contains an integer 't', denoting the number of test cases.
 *
 * Each test case is of the following format:
 *
 *   * The first line contains an integer 'n', denoting the number of elements
 *     in the list.
 *
 *   * The next 'n' lines contain one element each, denoting the elements of the
 *     linked list in their order.
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
 * Change the 'next' pointers of the nodes that their order is reversed and
 * 'return' the 'head' of the reversed linked list. Do NOT print anything to
 * stdout/console.
 *
 * The output is handled by the code in the editor. The output format is as
 * follows:
 *
 * For each test case, print in a new line the elements of the linked list after
 * reversing it, separated by spaces.
 *
 * Sample Input
 *
 * 1
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * Sample Output
 *
 * 5 4 3 2 1
 *
 * Explanation
 *
 * The initial linked list is: 1 -> 2 -> 3 -> 4 -> 5 -> null.
 *
 * The reversed linked list is: 5 -> 4 -> 3 -> 2 -> 1 -> null.
 */

import java.util.Stack;
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
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode res;
        Stack<SinglyLinkedListNode> myStack = new Stack<>();

        if (head == null) {
            // Empty Linked List.
            res = head;
        } else {
            // Non-empty Linked List.
            SinglyLinkedListNode tmp = head;

            while (tmp != null) {
                myStack.push(tmp);
                tmp = tmp.next;
            }

            // The 'head' of the reversed linked list is now the last element of
            // the initial linked list.
            head = myStack.peek();

            while (!myStack.empty()) {
                tmp = myStack.pop();
                if (myStack.empty()) {
                    // Arrived to the last element of the Stack, the 'head' of
                    // the original list. Update its 'next' element to 'null'.
                    tmp.next = null;
                } else {
                    // Update node's next element.
                    tmp.next = myStack.peek();
                }
            }
            res = head;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SinglyLinkedList llist;
        int t = in.nextInt();

        // Process input
        for (int i = 0; i < t; i++) {
            llist = new SinglyLinkedList();
            int n = in.nextInt();

            for (int j = 0; j < n; j++) {
                int data = in.nextInt();

                llist.insertNode(data);
            }

            llist.head = reverse(llist.head);

            // Prints output
            printSinglyLinkedList(llist.head);
        }
        in.close();
    }
}
