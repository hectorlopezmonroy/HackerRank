/*
 * According to Wikipedia, a factory is simply an object that returns another
 * object from some other method call, which is assumed to be "new".
 *
 * In this problem, you are given an interface 'Food'. There are two classes
 * 'Pizza' and 'Cake' which implement the 'Food' interface, and they both
 * contain a method 'getType()'.
 *
 * The main function in the 'JavaFactoryPattern' class creates an instance of
 * the 'FoodFactory' class. The 'FoodFactory' class contains a method
 * 'getFood(String)' that returns a new instance of 'Pizza' or 'Cake' according
 * to its parameter.
 *
 * You are given the partially completed code in the editor. Please complete the
 * 'FoodFactory' class.
 *
 * Sample Input 0
 *
 * cake
 *
 * Sample Output 0
 *
 * The factory returned class Cake
 * Someone ordered a Dessert!
 *
 * Sample Input 1
 *
 * pizza
 *
 * Sample Output 1
 *
 * The factory returned class Pizza
 * Someone ordered a Fast Food!
 */

import java.security.*;
import java.util.Scanner;

interface Food {

    public String getType();
}

class Pizza implements Food {

    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {

    public Food getFood(String order) {
        Food res = order.equals("cake") ? new Cake() : new Pizza();
        return res;
    }
}

class Do_Not_Terminate {

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

public class JavaFactoryPattern {

    public static void main(String[] args) {
        Do_Not_Terminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            // Creating the factory
            FoodFactory foodFactory = new FoodFactory();

            // Factory instantiates an object
            Food food = foodFactory.getFood(in.nextLine());
            in.close();

            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccesful Termination!!");
        }
    }
}
