/*
 * A Java interface can only contain method signatures and fields. The interface
 * can be used to achieve polymorphism. In this problem, you will practice your
 * knowledge on interfaces.
 *
 * You are given an interface 'AdvancedArithmetic' which contains a method
 * signature 'int divisor_sum(int n)'. You need to write a class called
 * 'MyCalculator' which implements the interface.
 *
 * 'divisorSum' function just takes an integer as input and return the sum of
 * all its divisors. For example, divisors of 6 are 1, 2, 3 and 6, so
 * 'divisor_sum' should return 12. The value of 'n' will be at most 1000.
 *
 * Read the partially completed code in the editor and complete it. You just
 * need to write the 'MyCalculator' class only. Your class shouldn't be public.
 *
 * Sample Input
 *
 * 6
 *
 * Sample Output
 *
 * I implemented: AdvancedArithmetic
 * 12
 *
 * Explanation
 *
 * Divisors of 6 are 1, 2, 3 and 6. 1 + 2 + 3 + 6 = 12.
 */

import java.util.Scanner;

interface AdvancedArithmetic {

    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

   public int divisor_sum(int n) {
       // Numbers 1 and n itself are divisors of any n.
       int res = n == 1 ? 1 : 1 + n;

       // We only need to check until n / 2 because there will be no divisors of
       // n after this point, except n, previously added to the sum.
       for (int i = 2; i <= n / 2; i++) {
           if (n % i == 0) {
               res += i;
           }
       }
       return res;
   }
}

public class JavaInterface {

    /*
     * ImplementedInterfaceNames method takes an object and prints the name of
     * the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();

        for (int i = 0; i < theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }

    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.print("I implemented: ");
        ImplementedInterfaceNames(myCalculator);

        System.out.println(myCalculator.divisor_sum(n));
        in.close();
    }
}
