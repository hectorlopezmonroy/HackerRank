/*
 * This challenge is part of a MyCodeSchool tutorial track and is accompanied by
 * a video lesson.
 *
 * If you're new to linked lists, this is a great exercise for learning about
 * them. Given a pointer to the head node of a linked list, print its elements
 * in order, one element per line. If the head pointer is null (indicating the
 * list is empty), don't print anything.
 *
 * Input Format
 *
 * The first line of input contains 'n', the number of elements in the linked
 * list.
 *
 * The next 'n' lines contain one element each, which are the elements of the
 * linked list.
 *
 * Note: Do not read any input from stdin/console. Complete the
 * 'printLinkedList' function in the editor below.
 *
 * Constraints
 *
 * 1 <= n <= 1000
 *
 * 1 <= list_i <= 1000, where 'list_i' is the 'i-th' element of the linked list.
 *
 * Output Format
 *
 * Print the integer data for each element of the linked list to stdout/console
 * (e.g.: using printf, cout, etc.). There should be one element per line.
 *
 * Sample Input
 *
 * 2
 * 16
 * 13
 *
 * Sample Output
 *
 * 16
 * 13
 *
 * Explanation
 *
 * There are two elements in the linked list. They are represented as
 * 16 -> 13 -> NULL. So, the 'printLinkedList' function should print '16' and
 * '13' each in a new line.
 */

import java.util.Scanner;

public class PrintTheElementsOfALinkedList {

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

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        printLinkedList(llist.head);

        scanner.close();
    }
}
