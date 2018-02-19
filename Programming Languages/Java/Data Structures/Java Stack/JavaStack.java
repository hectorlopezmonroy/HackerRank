/*
 * In computer science, a stack or LIFO (last in, first out) is an abstract data
 * type that serves as a collection of elements, with two principal operations:
 * push, which adds an element to the collection, and pop, which removes the
 * last element that was added. - Wikipedia.
 *
 * A string containing only parentheses is balanced if the following is true:
 *
 *   1. If it is an empty string.
 *   2. If A and B are correct, AB is correct,
 *   3. If A is correct, (A) and {A} and [A] are also correct.
 *
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})".
 *
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{", etc.
 *
 * Given a string, determine if it is balanced or not.
 *
 * Input Format
 *
 * There will be multiple lines in the input file, each having a single
 * non-empty string. You should read input till end-of-file.
 *
 * The part of the code that handles input operation is already provided in the
 * editor.
 *
 * Output Format
 *
 * For each case, print 'true' if the string is balanced, 'false' otherwise.
 *
 * Sample Input
 *
 * {}()
 * ({()})
 * {}(
 * []
 *
 * Sample Output
 *
 * true
 * true
 * false
 * true
 */

import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;

public class JavaStack {

    public static boolean isBalanced(String s) {
        boolean res = false;
        Stack<Character> myStack = new Stack<Character>();

        if (s.length() == 0) {
            // An empty string is balanced
            res = true;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '{' || c == '[' || c == '(') {
                    // If an opening character is found, add it to the stack
                    myStack.push(c);
                } else if (myStack.size() > 0) {
                    // If the stack have elements, check if the character found
                    // correctly closes a previously found opening character.
                    if ((c == '}' && myStack.peek() == '{') ||
                        (c == ']' && myStack.peek() == '[') ||
                        (c == ')' && myStack.peek() == '(')) {
                        myStack.pop();
                    }
                } else if ((myStack.size() == 0) &&
                           (c == '}' || c == ']' || c == ')')) {
                    // If the stack is empty and a closing character is found,
                    // there won't be an opening character to pop. Therefore,
                    // push a character and break the cycle. The string is
                    // unbalanced.
                    myStack.push('x');
                    break;
                }
            }
            if (myStack.size() == 0) {
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Boolean> res = new LinkedList<Boolean>();

        // Checking if each string is balanced
        while (in.hasNext()) {
            res.add(isBalanced(in.nextLine()));
        }
        in.close();

        // Print results
        for (boolean b : res) {
            System.out.println(b ? "true" : "false");
        }
    }
}
