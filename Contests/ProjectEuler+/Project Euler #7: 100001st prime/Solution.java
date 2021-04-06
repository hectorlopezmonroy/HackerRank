/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11 and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the Nth prime number?
 *
 * Input Format
 *
 * First line contains 'T' that denotes the number of test cases. 
 * This is followed by 'T' lines, each containing an integer, 'N'.
 *
 * Constraints
 *
 * 1 <= T <= 10^3
 *
 * 1 <= N <= 10^4
 *
 * Output Format
 *
 * Print the required answer for each test case.
 *
 * Sample Input
 *
 * 2
 * 3
 * 6
 *
 * Sample Output
 *
 * 5
 * 13
 *
 * Explanation
 *
 * The first 10 prime numbers are {2, 3, 5, 7, 11, 13, 17, 19, 23, 29} we can
 *  see that 3rd prime number is 5 and 6th prime number is 13.
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

	public static int[] getPrimesUntil(int n) {
		int j = 2;
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			boolean notFound = true;
			while (notFound) {
				if (isPrime(j)) {
					res[i] = j;
					notFound = false;
				}
				j++;
			}
		}	
		return res;
	}

	public static void solution(int n, int[] test_cases) {
		int[] primes = getPrimesUntil(n);
		
		for (int i = 0; i < test_cases.length; i++) {
			System.out.println(primes[test_cases[i] - 1]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int max = 0;
		int t = in.nextInt();
		int[] test_cases = new int[t];

		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			test_cases[i] = n;
			if (max < n) {
				max = n;
			}
		}
		solution(max, test_cases);
	}
}
