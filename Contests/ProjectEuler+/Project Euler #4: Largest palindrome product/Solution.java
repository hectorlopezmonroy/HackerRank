/*
 * A palindromic number reads the same both ways. The smallest 6 digit palindrome
 * made from the product of two 3-digit numbers is 101101 = 143 * 707.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers which
 * is less than 'N'.
 *
 * Input Format
 *
 * First line contains 'T' that denotes the number of test cases.
 * This is followed by 'T' lines, each containing an integer, 'N'.
 *
 * Constraints
 *
 * 1 <= T <= 100
 * 101101 < N < 1000000
 *
 * Output Format
 *
 * Print the required answer for each test case in a new line.
 *
 * Sample Input
 *
 * 2
 * 101101
 * 800000
 *
 * Sample Output
 *
 * 101101
 * 793397
 *
 * Explanation
 *
 * 101101 is product of 143 and 707.
 * 793397 is product of 869 and 913.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isPalindrome(int n) {
        String number_to_string = Integer.toString(n);
        Integer len = number_to_string.length(); 
        boolean res = true;
        
        for (int i = 0; i < len / 2; i++) {
            if (number_to_string.charAt(i) != number_to_string.charAt(len - i - 1)) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static boolean isDivisibleByTwoThreeDigitNumbers(int n) {
        boolean res = false;
        
        for (int i = 100; i < 1000 ; i++) {
            if (n % i == 0) {
                int j = n / i;
                if (100 <= j && j <= 999) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
    
	public static int largestPalindrome(int n) {
        int res = n - 1;
         
        for (int i = res; 101101 <= i; i--) {
            if (isPalindrome(i) && isDivisibleByTwoThreeDigitNumbers(i)) {
                res = i;
                break;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
   
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(largestPalindrome(n));
        }
    }
}
