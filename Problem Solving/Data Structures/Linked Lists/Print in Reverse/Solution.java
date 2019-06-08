/*
 * This challenge is part of a tutorial track by MyCodeSchool and is accompanied
 * by a video lesson.
 *
 * You are given the pointer to the head node of a linked list and you need to
 * print all its elements in reverse order from tail to head, one element per
 * line. The head pointer may be 'null' meaning that the list is empty - in
 * that case, do not print anything!
 *
 * Input Format
 *
 * You have to complete the 'void reversePrint(SinglyLinkedListNode* head)'
 * method which takes one argument - the head of the linked list. You should NOT
 * read any input from stdin/console.
 *
 * The first line of input contains 't', the number of test cases.
 *
 * The input of each test case is as follows:
 *
 *   * The first line contains an integer 'n', denoting the number of elements
 *     in the list.
 *
 *   * The next 'n' lines contain one element each, denoting the elements of the
 *     linked list in their order.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= list_i <= 1000, where 'list_i' is the 'i-th' element in the list.
 *
 * Output Format
 *
 * Complete the 'reversePrint' function in the editor below and print the
 * elements of the linked list in the reverse order, each in a new line.
 *
 * Sample Input
 *
 * 3
 * 5
 * 16
 * 12
 * 4
 * 2
 * 5
 * 3
 * 7
 * 3
 * 9
 * 5
 * 5
 * 1
 * 18
 * 3
 * 13
 *
 * Sample Output
 *
 * 5
 * 2
 * 4
 * 12
 * 16
 * 9
 * 3
 * 7
 * 13
 * 3
 * 18
 * 1
 * 5
 *
 * Explanation
 *
 * There are three test cases.
 *
 * The first linked list has '5' elements: 16 -> 12 -> 4 -> 2 -> 5. Printing
 * this in reverse order will produce: 5 -> 2 -> 4 -> 12 -> 16.
 *
 * The second linked list has '3' elements: 7 -> 3 -> 9. Printing this in
 * reverse order will produce: 9 -> 3 -> 7.
 *
 * The third linked list has '5' elements: 5 -> 1 -> 18 -> 3 -> 13. Printing
 * this in reverse order will produce: 13 -> 3 -> 18 -> 1 -> 5.
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

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void reversePrint(SinglyLinkedListNode head) {
        Stack<Integer> myStack = new Stack<>();
        SinglyLinkedListNode tmp = head;

        while (tmp != null) {
            myStack.push(tmp.data);
            tmp = tmp.next;
        }

        while (!myStack.empty()) {
            System.out.println(myStack.pop());
        }
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

            // Prints output
            reversePrint(llist.head);
        }
        in.close();
    }
}
