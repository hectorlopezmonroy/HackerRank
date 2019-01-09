/*
 * Objective
 * In this challenge, you'll work with arithmetic operators. Check out the
 * Tutorial tab for learning materials and an instructional video.
 *
 * Task
 * Given the meal price (base cost of a meal), tip percent (the percentage of
 * the meal price being added as tip), and tax percent (the percentage of the
 * meal being asked as tax) for a meal, find and print the meal's total cost.
 *
 * Note: Be sure to use precise values for your calculations, or you may end up
 * with an incorrectly rounded result!
 *
 * Input Format
 *
 * There are 3 lines of numeric input:
 * The first line has a double, 'mealCost' (the cost of the meal before tax and
 * tip).
 * The second line has an integer, 'tipPercent' (the percentage of 'mealCost'
 * being added as tip).
 * The third line has an integer, 'taxPercent' (the percentage of 'mealCost'
 * being added as tax).
 *
 * Output Format
 *
 * Print "The total meal cost is totalCost dollars.", where 'totalCost' is the
 * rounded integer result of the entire bill ('mealCost' added tax and tip).
 *
 * Sample Input
 *
 * 12.00
 * 20
 * 8
 *
 * Sample Output
 *
 * The total meal cost is 15 dollars.
 *
 * Explanation
 *
 * Given:
 * mealCost = 12, tipPercent = 20, taxPercent = 8
 *
 * Calculations:
 * tip = 12 * (20/100) = 2.4
 * tax = 12 * (8/100) = 0.96
 * totalCost = mealCost + tip + tax = 12 + 2.4 + 0.96 = 15.36
 * round(totalCost) = 15
 *
 * We round 'totalCost' to the nearest dollar (integer) and then print our
 * result:
 *
 *   The total meal cost is 15 dollars.
 */

import java.math.*;
import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double mealCost = in.nextDouble();  // original meal price
        int tipPercent = in.nextInt();      // tip percentage
        int taxPercent = in.nextInt();      // tax percentage
        int totalCost = 0;
        double tax = 0.0;
        double tip = 0.0;
        in.close();

        // Write your calculation code here.
        tax = mealCost * (taxPercent / 100.00);
        tip = mealCost * (tipPercent / 100.00);

        // Cast the result of the rounding operation to an int and save it as
        // totalCost
        totalCost = (int) Math.round(mealCost + tip + tax);

        // Print your result
        System.out.println("The total meal cost is " + totalCost + " dollars.");
    }
}
