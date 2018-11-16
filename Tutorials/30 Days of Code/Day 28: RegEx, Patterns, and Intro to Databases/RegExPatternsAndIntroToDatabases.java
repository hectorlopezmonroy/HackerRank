/*
 * Objective
 * Today, we're working with regular expressions. Check out the Tutorial tab for
 * learning materials and an instructional video!
 *
 * Task
 * Consider a database table, 'Emails', which has the attributes 'First Name'
 * and 'Email ID'. Given 'N' rows of data simulating the 'Emails' table, print
 * an alphabetically-ordered list of people whose email address ends in
 * '@gmail.com'.
 *
 * Input Format
 *
 * The first line contains an integer, 'N', total number of rows in the table.
 * Each of the 'N' subsequent lines contains 2 space-separated strings denoting
 * a person's first name and email ID, respectively.
 *
 * Constraints
 *
 * 2 <= N <= 30
 *
 * Each of the first names consists of lower case letters [a - z] only.
 *
 * Each of the email IDs consists of lower case letters [a - z], @ and . only.
 *
 * The length of the first name is no longer than 20.
 *
 * The length of the email ID is no longer than 50.
 *
 * Output Format
 *
 * Print an alphabetically-ordered list of first names for every user with a
 * gmail account. Each name must be printed on a new line.
 *
 * Sample Input
 *
 * 6
 * riya riya@gmail.com
 * julia julia@julia.me
 * julia sjulia@gmail.com
 * julia julia@gmail.com
 * samantha samantha@gmail.com
 * tanya tanya@gmail.com
 *
 * Sample Output
 *
 * julia
 * julia
 * riya
 * samantha
 * tanya
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPatternsAndIntroToDatabases {

    public static void main(String[] args) {
        int N;
        String[] res;
        Scanner in = new Scanner(System.in);
        LinkedList<String> l = new LinkedList<>();

        N = in.nextInt();
        in.nextLine();

        // Process input
        while (N-- > 0) {
            String[] line = in.nextLine().split(" ");
            Pattern p = Pattern.compile(".+@gmail.com");
            Matcher m = p.matcher(line[1]);

            if (m.matches()) {
                l.add(line[0]);
            }
        }
        in.close();

        res = l.toArray(new String[0]);
        Arrays.sort(res);

        // Prints output
        for (String s : res) {
            System.out.println(s);
        }
    }
}
