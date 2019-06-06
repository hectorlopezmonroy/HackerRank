/*
 * You have been asked to help study the population of birds migrating across
 * the continent. Each type of bird you are interested in will be identified by
 * an integer value. Each time a particular kind of bird is spotted, its 'ID'
 * number will be added to your array of sightings. You would like to be able to
 * find out which type of bird is most common given a list of sightings. Your
 * task is to print the type of that bird and if two or more types of birds are
 * equally common, choose the type with the smallest 'ID' number.
 *
 * For example, assume your bird sightings are of types 'arr = [1, 1, 2, 2, 3]'.
 * There are two each of types '1' and '2', and one sighting of type '3'. Pick
 * the lower of the two types seen twice: type '1'.
 *
 * Function Description
 *
 * Complete the 'migratoryBirds' function in the editor below. It should return
 * the lowest type number of the most frequently sighted bird.
 *
 * 'migratoryBirds' has the following paramater(s):
 *
 *   * 'arr': an array of integers representing types of birds sighted.
 *
 * Input Format
 *
 * The first line contains an integer denoting 'n', the number of birds sighted
 * and reported in the array 'arr'.
 *
 * The second line describes 'arr' as 'n' space-separated integers representing
 * the type numbers of each bird sighted.
 *
 * Constraints
 *
 * 5 <= n <= 2 * 10^5
 *
 * It is guaranteed that each type is '1', '2', '3', '4',  or '5'.
 *
 * Output Format
 *
 * Print the type number of the most common bird; if two or more types of birds
 * are equally common, choose the type with the smallest ID number.
 *
 * Sample Input 0
 *
 * 6
 * 1 4 4 4 5 3
 *
 * Sample Output 0
 *
 * 4
 *
 * Explanation 0
 *
 * The different types of birds occur in the following frequencies:
 *
 *   * Type '1': '1' bird.
 *
 *   * Type '2': '0' birds.
 *
 *   * Type '3': '1' birds.
 *
 *   * Type '4': '3' birds.
 *
 *   * Type '5': '1' bird.
 *
 * The type number that occurs at the highest frequency is type '4', so we print
 * '4' as our answer.
 *
 * Sample Input 1
 *
 * 11
 * 1 2 3 4 5 4 3 2 1 3 4
 *
 * Sample Output 1
 *
 * 3
 *
 * Explanation 1
 *
 * The different types of birds occur in the following frequencies:
 *
 *   * Type '1': '2'
 *   * Type '2': '2'
 *   * Type '3': '3'
 *   * Type '4': '3'
 *   * Type '5': '1'
 */

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MigratoryBirds {

    static int migratoryBirds(List<Integer> arr) {
        int res = 0;
        int max = 0;
        int[] counts = new int[5];

        for (int i = 0; i < arr.size(); i++) {
            int bird = arr.get(i);

            // We update the count for the respective type of bird.
            counts[bird - 1]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (max < counts[i]) {
                // If we find a new maximum count for another type of bird,
                // we update it accordingly, and we also update the kind of bird
                // that is passed as result.
                max = counts[i];
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = in.nextInt();
        int result = 0;

        // Process input
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        in.close();

        result = migratoryBirds(arr);

        // Prints output
        System.out.println(result);
    }
}
