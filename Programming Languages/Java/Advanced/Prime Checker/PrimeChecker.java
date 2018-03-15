/*
 * You are given a class 'PrimeChecker' and its 'main' method in the editor.
 * Your task is to create a class 'Prime'. The class 'Prime' should contain a
 * single method 'checkPrime'.
 *
 * The locked code in the editor will call the 'checkPrime' method with one or
 * more integer arguments. You should write the 'checkPrime' method in such a
 * way that the code prints only the prime numbers.
 *
 * Please read the code given in the editor carefully. Also please do not use
 * method overloading!
 *
 * Note: You may get a compile time error in this problem due to the statement
 * below:
 *
 *   BufferedReader br = new BufferedReader(new InputStreamReader(in));
 *
 * This was added intentionally, and you have to figure out a way to get rid of
 * the error.
 *
 * Input Format
 *
 * There are only five lines of input, each containing one integer.
 *
 * Output Format
 *
 * There will be only four lines of output. Each line contains only prime
 * numbers depending upon the parameters passed to 'checkPrime' in the 'main'
 * method of the class 'PrimeChecker'. In case there is no prime number, then a
 * blank line should be printed.
 *
 * Sample Input
 *
 * 2
 * 1
 * 3
 * 4
 * 5
 *
 * Sample Output
 *
 * 2
 * 2
 * 2 3
 * 2 3 5
 */

import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.io.InputStreamReader;
import static java.lang.System.in;

class Prime {

    public void checkPrime(int ... a) {
        String res = "";

        for (int i = 0; i < a.length; i++) {
           	boolean isPrime = true;

           	if (a[i] == 1 || (a[i] != 2 && a[i] % 2 == 0)) {
               isPrime = false;
		   	} else if (a[i] % 2 != 0) {
				// Now, we only check for the potential odd divisors of the
				// number
				for (int j = 3; j < a[i] / 2; j = j + 2) {
					if (a[i] % j == 0) {
						isPrime = false;
					}
				}
			}
			if (isPrime) {
                String prime = String.valueOf(a[i]);
                res = res.length() == 0 ? prime : res + " " + prime;
			}
        }
		System.out.println(res);
    }
}

public class PrimeChecker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();

            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);

			Method[] methods=Prime.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());
			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
