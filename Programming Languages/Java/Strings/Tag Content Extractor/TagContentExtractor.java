/*
 * In a tag-based language like 'XML' or 'HTML', contents are enclosed between a
 * 'start tag' and 'end tag' like '<tag>contents</tag>'. Note that the
 * corresponding 'end tag' starts with a '/'.
 *
 * Given a string of text in a tag-based language, parse this text and retrieve
 * the contents enclosed within sequences of well-organized tags meeting the
 * following criterion:
 *
 *   1. The name of the 'start' and 'end' tags must be the same. The HTML code
 *      '<h1>Hello World</h2>' is 'not valid', because the text starts with an
 *      'h1' tag and ends with a non-matching 'h2' tag.
 *
 *   2. Tags can be nested, but content between nested tags is considered 'not
 *      valid'. For example, in '<h1><a>contents</a>invalid</h1>', 'contents' is
 *      'valid' but 'invalid' is 'not valid'.
 *
 *   3. Tags can consist of any printable characters.
 *
 * Input Format
 *
 * The first line of input contains a single integer, 'N' (the number of lines).
 *
 * The 'N' subsequent lines each contain a line of text.
 *
 * Constraints
 *
 * 1 <= N <= 100
 *
 * * Each line contains a maximum of '10^4' printable characters.
 *
 * * The total number of characters in all test cases will not exceed '10^6'.
 *
 * Output Format
 *
 * For each line, print the content enclosed within valid tags.
 *
 * If a line contains multiple instances of valid content, print out each
 * instance of valid content on a new line; if no valid content is found, print
 * "None".
 *
 * Sample Input
 *
 * 4
 * <h1>Nayeem loves counseling</h1>
 * <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
 * <Amee>safat codes like a ninja</amee>
 * <SA premium>Imtiaz has a secret crush</SA premium>
 *
 * Sample Output
 *
 * Nayeem loves counseling
 * Sanjay has no watch
 * So wait for a while
 * None
 * Imtiaz has a secret crush
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

    public static void main(String[] args) {
        LinkedList<String> res = new LinkedList<>();
        String regex = "<(.+)>([^<]+)</\\1>";
        Pattern p = Pattern.compile(regex);
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        // Process input
        while (testCases > 0) {
            boolean matchFound = false;
            String input = in.nextLine();
            Matcher m = p.matcher(input);

            while (m.find()) {
                res.add(m.group(2));
                matchFound = true;
            }
            if (!matchFound) {
                res.add("None");
            }
            testCases--;
        }
        in.close();

        // Prints output as requested.
        for (String s : res) {
            System.out.println(s);
        }
    }
}
