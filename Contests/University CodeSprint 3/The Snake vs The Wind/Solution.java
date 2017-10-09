/*
 * A group of scientists is doing some experiments with a snake. They want to
 * measure its intelligence by observing the way it moves inside a specific
 * area. The scientists have inserted the snake inside a two-dimensional n * n
 * square. They have filled the area with n^2 mice (one in each small square of
 * the area) in order to motivate the snake to move. The scientists know that
 * the snake is very hungry so the snake will eat all of the mice. In order to
 * make things more difficult for the snake, they will apply a very strong
 * artificial wind blowing towards certain directions (north, south, west or
 * east) that usually disturbs the snake a lot.
 *
 * The scientists have seen in their previous experiments that the snake hates
 * the wind so much that it will try to do its best not to move in the opposite
 * direction of the wind because its eyes are very sensitive to the dust. AT ANY
 * INSTANT, the snake (GREEDILY) prefers to move in the same direction as the
 * wind, of if that is not possible, it would not be a problem even moving
 * perpendicularly to the wind. The snake is very hungry so if it can see that
 * the only possible way to eat more is to move in an opposite way to the
 * direction of the wind, it will sacrifice a bit its eyes for its stomach.
 *
 *                             s
 *                             |
 *                             v
 *                  (0, 0)  ..... (0, n - 1)
 *                     .               .
 *                     .               .
 *           e ->      .               .     <- w
 *                     .               .
 *                     .               .
 *                     .               .
 *                  (n-1, 0) .....(n-1, n-1)
 *
 *                             ^
 *                             |
 *                             n
 *
 * The snake can make only one move in a second and it can move only up, down,
 * right or left. Also, it cannot move in a place where it was before since we
 * are dealing with a very long snake. The scientists decided to put the snake
 * in one of the four corners of the area and they want you to give the movement
 * of the snake for each second of the journey.
 *
 * Note: For a given wind's direction and the initial position of the snake,
 * there exists only one unique path the snake will take to visit all the cells.
 *
 * Input Format
 *
 * In the first line, you will be given an integer n where n represents the
 * length and width of the area in which the snake will move. In the second
 * line, you will be given a single character (n, s, w, or e) which determines
 * the direction towards which the wind blows. In the third line, you will be
 * given the coordinates (x, y) of the corner where the snake will start the
 * journey. The upper-left corner has the coordinates (0,0) and the lower-right
 * corner has the coordinates (n - 1, n - 1).
 *
 * Constraints
 *
 * 2 <= n <= 60
 * The snake will always start the journey in one of the four corners of the
 * grid.
 *
 * Output Format
 *
 * Print the whole journey of the snake by outputting the time at which the
 * snake is found in each specific part of the area. Have a look at the sample
 * outputs for better understanding.
 *
 * Sample Input 0
 *
 * 2
 * e
 * 1 0
 *
 * Sample Output 0
 *
 * 4 3
 * 1 2
 *
 * Sample Input 1
 *
 * 4
 * n
 * 0 0
 *
 * Sample Output 1
 *
 * 1 2 3 4
 * 8 7 6 5
 * 9 10 11 12
 * 16 15 14 13
 */

import java.util.Scanner;

public class Solution {

    private int x;
    private int y;
    private int n;
    private char wind;
    private int[][] path;
    private int count = 0;
    private char direction;

    Solution(int x, int y, int n, char d) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.wind = d;
        this.path = new int[n][n];
    }

    private boolean isSafe(char direction) {
        boolean res = false;

        switch (direction) {
            case 'n':
                if (this.x > 0 && this.path[this.x - 1][this.y] == 0) {
                    res = true;
                }
                break;
            case 's':
                if (this.x < (this.n - 1) && this.path[this.x + 1][this.y] == 0) {
                    res = true;
                }
                break;
            case 'e':
                if (this.y < (this.n - 1) && this.path[this.x][this.y + 1] == 0) {
                    res = true;
                }
                break;
            case 'w':
                if (this.y > 0 && this.path[this.x][this.y - 1] == 0) {
                    res = true;
                }
                break;
            default:
                break;
        }
        return res;
    }

    private void chooseDirection() {
        if (this.wind == 'n') {
            if (this.isSafe(this.wind)) {
                this.direction = this.wind;
            } else {
                if (this.isSafe('e')) {
                    this.direction = 'e';
                } else if (this.isSafe('w')) {
                    this.direction = 'w';
                } else if (this.isSafe('s')) {
                    this.direction = 's';
                }
            }
        } else if (this.wind == 's') {
            if (this.isSafe(this.wind)) {
                this.direction = this.wind;
            } else {
                if (this.isSafe('e')) {
                    this.direction = 'e';
                } else if (this.isSafe('w')) {
                    this.direction = 'w';
                } else if (this.isSafe('n')) {
                    this.direction = 'n';
                }
            }
        } else if (this.wind == 'e') {
            if (this.isSafe(this.wind)) {
                this.direction = this.wind;
            } else {
                if (this.isSafe('n')) {
                    this.direction = 'n';
                } else if (this.isSafe('s')) {
                    this.direction = 's';
                } else if (this.isSafe('w')) {
                    this.direction = 'w';
                }
            }
        } else {
            if (this.isSafe(this.wind)) {
                this.direction = this.wind;
            } else {
                if (this.isSafe('n')) {
                    this.direction = 'n';
                } else if (this.isSafe('s')) {
                    this.direction = 's';
                } else if (this.isSafe('e')) {
                    this.direction = 'e';
                }
            }
        }
    }

    public void startPath() {

        this.count++;
        this.path[this.x][this.y] = this.count;
        while (this.count < Math.pow(n,2)){
            this.chooseDirection();
            nextStep();
        }
    }

    private void nextStep() {
        switch (this.direction) {
            case 'n':
                this.x--;
                break;
            case 's':
                this.x++;
                break;
            case 'e':
                this.y++;
                break;
            case 'w':
                this.y--;
                break;
            default:
                break;
        }
        this.count++;
        this.path[this.x][this.y] = this.count;
    }

    public void printPath() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (j < this.n - 1) {
                    System.out.print(this.path[i][j] + " ");
                } else {
                    System.out.println(this.path[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        Solution sol = new Solution(x, y, n, d);

        sol.startPath();
        sol.printPath();
    }
}
