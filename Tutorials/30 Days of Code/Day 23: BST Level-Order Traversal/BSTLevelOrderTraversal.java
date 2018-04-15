/*
 * Objective
 * Today, we're going further with Binary Search Trees. Check out the Tutorial
 * tab for learning materials and an instructional video!
 *
 * Task
 * A level-order traversal, also known as a breadth-first search, visits each
 * level of a tree's nodes from left to right, top to bottom. You are given a
 * pointer, 'root', pointing to the root of a binary search tree. Complete the
 * 'levelOrder' function provided in your editor so that it prints the
 * level-order traversal of the binary search tree.
 *
 * Hint: You'll find a queue helpful in completing this challenge.
 *
 * Input Format
 *
 * The locked stub code in your editor reads the following inputs and assembles
 * them into a BST:
 *
 * The first line contains an integer, 'T' (the number of nodes in the tree).
 *
 * The 'T' subsequent lines each contain an integer, 'data', denoting the value
 * of an element that must be added to the BST.
 *
 * Output Format
 *
 * Print the 'data' value of each node in the tree's level-order traversal as a
 * single line of 'N' space-separated integers.
 *
 * Sample Input
 *
 * 6
 * 3
 * 5
 * 4
 * 7
 * 2
 * 1
 *
 * Sample Output
 *
 * 3 2 5 1 4 7
 *
 * Explanation
 *
 * The input forms the following binary search tree:
 *
 *                              3          Level 0
 *                            /   \
 *                           2     5       Level 1
 *                          /     / \
 *                         1     4   7     Level 2
 *
 * We traverse each level of the tree from the root downward, and we process the
 * nodes at each level from left to right. The resulting level-order traversal
 * is 3 -> 2 -> 5 -> 1 -> 4 -> 7, and we print these data values as a single
 * line of space-separated integers.
 */

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTLevelOrderTraversal {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    static void levelOrder(Node root) {
        String res = "";
        Queue<Node> q = new LinkedList<Node>();

        if (root != null) {
            q.add(root);

            while (!q.isEmpty()) {
                Node cur = q.remove();
                if (res.equals("")) {
                    res = res + cur.data;
                } else {
                    res = res + " " + cur.data;
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        System.out.println(res);
    }

     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Node root = null;

        // Process input
        while (T-- > 0) {
            int data = in.nextInt();
            root = insert(root, data);
        }
        in.close();

        levelOrder(root);
    }
}
