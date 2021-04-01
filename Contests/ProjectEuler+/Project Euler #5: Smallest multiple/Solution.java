/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible (divisible with
 * no remainder) by all of the numbers from 1 to N?
 *
 * Input Format
 *
 * First line contains 'T' that denotes the number of test cases. This is
 * followed by 'T' lines, each containing an integer, 'N'.
 *
 * Constraints
 *
 * 1 <= T <= 10
 *
 * 1 <= N <= 40
 *
 * Output Format
 *
 * Print the required answer for each test case.
 *
 * Sample Input
 *
 * 2
 * 3
 * 10
 *
 * Sample Output
 *
 * 6
 * 2520
 *
 * Explanation
 *
 * You can check 6 is divisible by each of {1, 2, 3}, giving quotient of
 * {6, 3, 2} respectively.
 *
 * You can check 2520 is divisible by each of {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * giving quotient of {2520, 1260, 840, 630, 504, 420, 360, 315, 280, 252}
 * respectively.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public static boolean isPrime(int n) {
		boolean res = true;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				res = false;	
				break;	
			}
		}
		return res;
	}

	public static Integer getSmallestMultiple(int n) {
		int res = 1;

		for (int i = 2; i <= n; i++) {
			if (res % i != 0) {
				if (isPrime(i)) {
					res = res * i;
				} else {
					res = res * (i / (res % i));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			System.out.println(getSmallestMultiple(n));
		}
	}
}
