/*
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 *
 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour
 * clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour
 * clock.
 *
 * Input Format
 *
 * A single string containing a time in 12-hour clock format (i.e.: hh:mm:ssAM
 * or hh:mm:ssPM), where 01 <= hh <= 12 ans 00 <= mm, ss <= 59.
 *
 * Output Format
 *
 * Convert and print the given time in 24-hour format, where 00 <= hh <= 23.
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

    public static String timeConversion(String s) {
        String res = "";

        if (s.substring(0, 2).equals("12") &&
            s.substring(s.length() - 2, s.length()).equals("AM")){
            res = "00" + s.substring(2, s.length() - 2);
        } else if (s.substring(0, 2).equals("12") &&
                   s.substring(s.length() - 2, s.length()).equals("PM")) {
            res = s.substring(0, s.length() - 2);
        } else {
            int hour = Integer.parseInt(s.substring(0, 2));
            if (s.substring(s.length() - 2, s.length()).equals("PM")) {
                res = Integer.toString((hour + 12) % 24)
                      + s.substring(2, s.length() - 2);
            } else {
                if (hour > 9) {
                    res = Integer.toString(hour)
                          + s.substring(2, s.length() - 2);
                } else {
                    res = "0" + Integer.toString(hour)
                          + s.substring(2, s.length() - 2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
