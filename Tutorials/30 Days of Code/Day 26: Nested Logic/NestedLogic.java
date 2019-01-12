/*
 * Objective
 * Today's challenge puts your understanding of nested conditional statements to
 * the test. You already have the knowledge to complete this challenge, but
 * check out the Tutorial tab for a video on testing!
 *
 * Task
 * Your local library needs your help! Given the expected and actual return
 * dates for a library book, create a program that calculates the fine (if any).
 * The fee structure is as follows:
 *
 *   1. If the book is returned on or before the expected return date, no fine
 *      will be charged (i.e.: fine = 0).
 *
 *   2. If the book is returned after the expected return 'day' but still within
 *      the same calendar month and year as the expected return date,
 *      fine = 15 Hackos * (the number of days late).
 *
 *   3. If the book is returned after the expected return 'month' but still
 *      within the same calendar year as the expected return date, the
 *      fine = 500 Hackos * (the number of months late).
 *
 *   4. If the book is returned after the calendar 'year' in which it was
 *      expected, there is a fixed fine of 10000 Hackos.
 *
 * Input Format
 *
 * The first line contains 3 space-separated integers denoting the respective
 * 'day', 'month', and 'year' on which the book was 'actually' returned.
 * The second line contains 3 space-separated integers denoting the respective
 * 'day', 'month', and 'year' on which the book was 'expected' to be returned
 * (due date).
 *
 * Constraints
 *
 * 1 <= D <= 31
 *
 * 1 <= M <= 12
 *
 * 1 <= Y <= 3000
 *
 * It is guaranteed that the dates will be valid Gregorian calendar dates.
 *
 * Output Format
 *
 * Print a single integer denoting the library fine for the book received as
 * input.
 *
 * Sample Input
 *
 * 9 6 2015
 * 6 6 2015
 *
 * Sample Output
 *
 * 45
 *
 * Explanation
 *
 * Given the following return dates:
 *
 * Actual: D_a = 9, M_a = 6, Y_a = 2015
 * Expected: D_e = 6, M_e = 6, Y_e = 2015
 *
 * Because Y_e = Y_a, we know it is less than a year late.
 * Because M_e = M_a, we know it is less than a month late.
 * Because D_e < D_a, we know that it was returned late (but still within the
 * same month and year).
 * Per the library's fee structure, we know that our fine will be
 * 15 Hackos * (# days late). We then print the result of
 * 15 * (D_a - D_e) = 15 * (9 - 6) = 45 as our output.
 */

import java.util.Scanner;

class Date {

    public int day;
    public int year;
    public int month;

    Date(String[] dateArray) {
       this.day = Integer.valueOf(dateArray[0]);
       this.month = Integer.valueOf(dateArray[1]);
       this.year = Integer.valueOf(dateArray[2]);
    }
}

class BookDates {

    public Date actualDate;
    public Date expectedDate;

    BookDates(Date actualDate, Date expectedDate) {
        this.actualDate = actualDate;
        this.expectedDate = expectedDate;
    }
}

public class NestedLogic {

    public static void fine(BookDates dates) {
        int res = 0;

        if (dates.actualDate.year < dates.expectedDate.year) {
            ;
        } else if (dates.actualDate.year == dates.expectedDate.year) {
            if (dates.actualDate.month < dates.expectedDate.month) {
                ;
            } else if (dates.actualDate.month == dates.expectedDate.month) {
                if (dates.expectedDate.day < dates.actualDate.day) {
                    res = 15 * (dates.actualDate.day - dates.expectedDate.day);
                }
            } else {
                res = 500 * (dates.actualDate.month - dates.expectedDate.month);
            }
        } else {
            res = 10000;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Date actualDate = new Date(in.nextLine().split(" "));
        Date expectedDate = new Date(in.nextLine().split(" "));
        BookDates dates = new BookDates(actualDate, expectedDate);
        in.close();

        fine(dates);
    }
}
