/*
 * Objective
 * Today we're discussing Generics; be aware that 'not all languages support
 * this construct', so fewer languages are enabled for this challenge. Check out
 * the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Write a single generic function named 'printArray'; this function must take
 * an array of generic elements as a parameter (the exception to this is C++,
 * which takes a 'vector'). The locked 'Generics' class in your editor tests
 * your function.
 *
 * Note: You must use generics to solve this challenge. 'Do not' write
 * overloaded functions.
 *
 * Input Format
 *
 * The locked 'Generics' class in your editor will pass different types of
 * arrays to your 'printArray' function.
 *
 * Constraints
 *
 * You must have exactly 1 function named 'printArray'.
 *
 * Output Format
 *
 * Your 'printArray' function should print each element of its generic array
 * parameter on a new line.
 */

import java.util.Scanner;

class Printer <T> {

    /**
     * Method Name: printArray
     * Print each element of the generic array on a new line. Do not return
     * anything.
     * @param array A generic array
     **/
    public void printArray(T[] array) {
        for (T elem : array) {
            System.out.println(elem);
        }
    }
}

public class Generics {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] intArray = new Integer[n];

        // Process input
        for (int i = 0; i < n; i++) {
            intArray[i] = in.nextInt();
        }

        // Process more input
        n = in.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = in.next();
        }
        in.close();

        Printer<Integer> intPrinter = new Printer<>();
        Printer<String> stringPrinter = new Printer<>();
        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);

        if (Printer.class.getDeclaredMethods().length > 1) {
            System.out.println("The Printer class should only have 1 method " +
                               "named printArray");
        }
    }
}
