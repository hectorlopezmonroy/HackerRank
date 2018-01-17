/*
 * The Calendar class is an abstract class that provides methods for converting
 * between a specific instant in time and a set of calendar fields such as YEAR,
 * MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar
 * fields, such as getting the date of the next week.
 *
 * You are given a date. You just need to write the method, 'getDay', which
 * returns the 'day' on that date. To simplify your task, we have provided a
 * portion of the code in the editor.
 *
 * For example, if you are given the date August 14th 2017, the method should
 * return 'MONDAY' as the day on that date.
 *
 * Input Format
 *
 * A single line of input containing the space-separated month, day and year,
 * respectively, in MM DD YYYY format.
 *
 * Constraints
 *
 * 2000 < year < 3000
 *
 * Output Format
 *
 * Output the correct day in capital letters.
 *
 * Sample Input
 *
 * 08 05 2015
 *
 * Sample Output
 *
 * WEDNESDAY
 *
 * Explanation
 *
 * The day on August 5th was WEDNESDAY.
 */

import java.util.Scanner;
import java.util.Calendar;

public class JavaDateAndTime {

    private static String dayOfWeekIntToString(int dayOfWeek) {
        String res = "";

        switch (dayOfWeek) {
            case 1: res = "SUNDAY";
                    break;
            case 2: res = "MONDAY";
                    break;
            case 3: res = "TUESDAY";
                    break;
            case 4: res = "WEDNESDAY";
                    break;
            case 5: res = "THURSDAY";
                    break;
            case 6: res = "FRIDAY";
                    break;
            case 7: res = "SATURDAY";
                    break;
            default: res = "Invalid Month";
                     break;
        }
        return res;
    }

    public static String getDay(String day, String month, String year) {
        String res = "";
        Calendar myCal = Calendar.getInstance();

        myCal.set(Integer.valueOf(year),
                  Integer.valueOf(month) - 1,
                  Integer.valueOf(day));
        res = dayOfWeekIntToString(myCal.get(myCal.DAY_OF_WEEK));
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}
