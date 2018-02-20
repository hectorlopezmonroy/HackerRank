/*
 * Comparators are used to compare two objects. In this challenge, you'll create
 * a comparator and use it to sort an array.
 *
 * The 'Player' class is provided for you in your editor. It has 2 fields: a
 * 'name' String and a 'score' integer.
 *
 * Given an array of 'n Player' objects, write a comparator that sorts them in
 * order of decreasing score; if 2 or more players have the same score, sort
 * those players alphabetically by name. To do this, you must create a 'Checker'
 * class that implements the 'Comparator' interface, then write an
 * 'int compare(Player a, Player b)' method implementing the
 * Comparator.compare(T o1, T o2) method.
 *
 * Input Format
 *
 * Input from stdin is handled by the locked stub code in the JavaComparator
 * class.
 *
 * The first line contains an integer, 'n', denoting the number of players.
 * Each of the 'n' subsequent lines contains a player's 'name' and 'score',
 * respectively.
 *
 * Constraints
 *
 * 0 <= 'score' <= 1000
 *
 * 2 players can have the same name.
 *
 * Player names consist of lowercase English letters.
 *
 * Output Format
 *
 * You are not responsible for printing any output to stdout. The locked stub
 * code in 'JavaComparator' will create a 'Checker' object, use it to sort the
 * 'Player' array, and print each sorted element.
 *
 * Sample Input
 *
 * 5
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 *
 * Sample Output
 *
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {
        int res = 0;

        if (a.score == b.score) {
            res = a.name.compareTo(b.name);
        } else {
            res = Integer.compare(b.score, a.score);
        }
        return res;
    }
}

public class JavaComparator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Player[] player = new Player[n];
        Checker checker = new Checker();

        // Initializes players input
        for (int i = 0; i < n; i++) {
            player[i] = new Player(in.next(), in.nextInt());
        }
        in.close();

        // Sorts the array as requested
        Arrays.sort(player, checker);
        // Prints the resulting output
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
