/*
 * Given a time in '12'-hour AM/PM format, convert it to military (24-hour)
 * time.
 *
 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour
 * clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour
 * clock.
 *
 * Function Description
 *
 * Complete the 'timeConversion' function in the editor below. It should return
 * a new string representing the input time in 24 hour format.
 *
 * 'timeConversion' has the following parameter(s):
 *
 *   * 's': a string representing time in '12' hour format.
 *
 * Input Format
 *
 * A single string 's' containing a time in '12'-hour clock format
 * (i.e.: 'hh:mm:ssAM' or 'hh:mm:ssPM'), where '01 <= hh <= 12' and
 * '00 <= mm, ss <= 59'.
 *
 * Constraints
 *
 * * All input times are valid.
 *
 * Output Format
 *
 * Convert and print the given time in '24'-hour format, where '00 <= hh <= 23'.
 *
 * Sample Input
 *
 * 07:05:45PM
 *
 * Sample Output
 *
 * 19:05:45
 */

import java.util.Scanner;

public class TimeConversion {

    static String timeConversion(String s) {
        String res = "";

        if (s.substring(0, 2).equals("12") &&
            s.substring(s.length() - 2, s.length()).equals("AM")){
            // String 's' denotes midnight on a 12-hour format
            res = "00" + s.substring(2, s.length() - 2);

        } else if (s.substring(0, 2).equals("12") &&
                   s.substring(s.length() - 2, s.length()).equals("PM")) {
            // String 's' denotes noon on a 12-hour format
            res = s.substring(0, s.length() - 2);

        } else {
            // String 's' is neither midnight nor noon on a 12-hour format
            int hour = Integer.parseInt(s.substring(0, 2));

            if (s.substring(s.length() - 2, s.length()).equals("PM")) {
                // String 's' denotes an afternoon hour on a 12-hour format
                res = Integer.toString((hour + 12) % 24)
                      + s.substring(2, s.length() - 2);

            } else {
                // String 's' denotes a morning hour on a 12-hour format
                res = s.substring(0, s.length() - 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s;
        String result;
        Scanner in = new Scanner(System.in);

        // Process input
        s = in.next();
        in.close();

        result = timeConversion(s);

        // Prints output
        System.out.println(result);
    }
}
