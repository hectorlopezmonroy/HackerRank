/*
 * You are given a class 'CanYouAccess' and an inner class 'Inner.Private'. The
 * main method of class 'CanYouAccess' takes an integer 'num' as input. The
 * 'powerof2' in class 'Inner.Private' checks whether a number is a power of 2.
 * You have to call the method 'powerof2' of the class 'Inner.Private' from the
 * 'main' method of the class 'CanYouAccess'.
 *
 * Constraints
 *
 * 1 <= num <= 2^30
 *
 * Sample Input
 *
 * 8
 *
 * Sample Output
 *
 * 8 is power of 2
 * An instance of class: CanYouAccess.Inner.Private has been created
 */

import java.security.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class prevents exit(0).
 */
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {

        final SecurityManager securityManager = new SecurityManager() {

            @Override
            public void checkPermission(Permission permission) {

                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}

public class CanYouAccess {

    static class Inner {

        private class Private {

            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o = new Inner().new Private();

            System.out.println(num + " is " +
                               ((CanYouAccess.Inner.Private)o).powerof2(num));
            System.out.println("An instance of class: " +
                               o.getClass().getCanonicalName() +
                               " has been created");
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}
