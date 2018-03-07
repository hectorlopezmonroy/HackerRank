/*
 * Java Iterator class can help you to iterate through every element in a
 * collection. Here is a simple example:
 *
 *   import java.util.*;
 *
 *   public class Example {
 *
 *       public static void main(String[] args) {
 *           ArrayList myList = new ArrayList();
 *
 *           myList.add("Hello");
 *           myList.add("Java");
 *           myList.add("4");
 *
 *           Iterator it = myList.iterator();
 *           while (it.hasNext()) {
 *               Object element = it.next();
 *               System.out.println((String) element);
 *           }
 *       }
 *   }
 *
 * In this problem you need to complete a method 'func'. The method takes an
 * 'ArrayList' as input. In that 'ArrayList' there is one or more integer
 * numbers, then there is a special string "###", after that there are one or
 * more other strings. A sample 'ArrayList' may look like this:
 *
 *   element[0]=>42
 *   element[1]=>10
 *   element[2]=>"###"
 *   element[3]=>"Hello"
 *   element[4]=>"Java"
 *
 * You have to modify the 'func' method by editing at most 2 lines so that the
 * code only prints the elements after the special string "###". For the sample
 * above the output will be:
 *
 *   Hello
 *   Java
 *
 * Note: The stdin doesn't contain the string "###", it is added in the 'main'
 * method.
 *
 * Sample Input
 *
 * 2 2
 * 42
 * 10
 * hello
 * java
 *
 * Sample Output
 *
 * hello
 * java
 */

import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

public class JavaIterator {

    static Iterator func(ArrayList myList) {
        Iterator it = myList.iterator();

        while (it.hasNext()) {
            Object element = it.next();

            if (element instanceof String) {
                break;
            }
        }
        return it;
    }

    @SuppressWarnings({ "unchecked" })
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // Process input
        for (int i = 0; i < n; i++) {
            myList.add(in.nextInt());
        }
        myList.add("###");
        for (int i = 0; i < m; i++) {
            myList.add(in.next());
        }

        Iterator it = func(myList);
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println((String) element);
        }
    }
}
