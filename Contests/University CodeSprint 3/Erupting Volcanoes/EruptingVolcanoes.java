/*
 * According to recent research, most active volcanoes are located near the
 * islands of the Pacific Ocean. Scientists know the effects of the volcanic
 * lava and they want to measure the maximum effect of lava on a specific area.
 *
 * It is difficult for them to analyze the effects on only some islands so they
 * decided to conduct the experiments on an n * n active volcanic area so that
 * the effects of multiple volcanoes may add up. They know that the lava of a
 * volcano has a lot of effect on the places that it touches.
 *
 * According to their studies, the lava has a maximum effect in the place of the
 * volcanic eruption, and this effect seems to decrease the further it gets from
 * the eruption place. More specifically, for a volcano located in a cell (x, y)
 * with power w, first it affects the cell (x, y) with power w, then it affects
 * yet-unaffected cells adjacent to recently affected cells with power equal to
 * the last power decreased by 1, and continues this process until the power
 * becomes 0. Please refer to the below example for the illustration of this
 * process:
 *                  w = 3
 *                  (x,y) = (3,3)
 *
 *                         0000000
 *                         0111110
 *                         0122210
 *                         0123210
 *                         0122210
 *                         0111110
 *                         0000000
 *
 * Given the size of the study area and the coordinates of the erupting
 * volcanoes, find the maximum total effect value of the lava across all cells
 * in the experiment's area.
 *
 * Input Format
 *
 * In the first line, you will be given an integer n which represents the
 * dimension of the square study area. The upper-left corner has the coordinates
 * (0,0) and the bottom-right corner has the coordinates (n -1, n - 1). In the
 * next line, you will be given an integer an integer m which represents the
 * number of the active volcanoes in the study area. In the following m lines
 * you will be given three integers, x, y, and w where x and y are the
 * coordinates of each erupting volcano and w is the power of its lava.
 *
 * Note: x denotes the row number and y denotes the column number.
 *
 * Constraints
 *
 * 5 <= n <= 300
 * 1 <= m <= 300
 * 0 <= x,y <= n - 1
 * 1 <= w <= 100
 * The locations of the volcanoes need not be distinct.
 *
 * Output Format
 *
 * Print a single line containing a single integer denoting the maximum effect
 * of the lava coming from all volcanoes inside the study area that is being
 * analyzed by the scientists.
 *
 * Sample Input 0
 *
 * 10
 * 1
 * 4 5 6
 *
 * Sample Output 0
 *
 * 6
 *
 * Explanation 0
 *
 * 1 2 2 2 2 2 2 2 2 2
 * 1 2 3 3 3 3 3 3 3 2
 * 1 2 3 4 4 4 4 4 3 2
 * 1 2 3 4 5 5 5 4 3 2
 * 1 2 3 4 5 6 5 4 3 2
 * 1 2 3 4 5 5 5 4 3 2
 * 1 2 3 4 4 4 4 4 3 2
 * 1 2 3 3 3 3 3 3 3 2
 * 1 2 2 2 2 2 2 2 2 2
 * 1 1 1 1 1 1 1 1 1 1
 *
 * Sample Input 1
 *
 * 10
 * 2
 * 3 3 3
 * 7 7 4
 *
 * Sample Output 1
 *
 * 4
 *
 * 0 0 0 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0 0 0 0
 * 0 1 2 2 2 1 0 0 0 0
 * 0 1 2 3 2 1 0 0 0 0
 * 0 1 2 2 3 2 1 1 1 1
 * 0 1 1 1 2 3 2 2 2 2
 * 0 0 0 0 1 2 3 3 3 2
 * 0 0 0 0 1 2 3 4 3 2
 * 0 0 0 0 1 2 3 3 3 2
 * 0 0 0 0 1 2 2 2 2 2
 */

import java.util.Scanner;

public class EruptingVolcanoes {

    private int n = 0;
    private int max = 0;
    private int[][] region;

    public EruptingVolcanoes(int n) {
        this.n = n;
        this.region = new int[n][n];
    }

    public void updateDamagedRegion(int x, int y, int w) {
        for (int i = w; i > 0; i--) {
            updateSquare(x, y, i, w - i);
        }
    }

    private void updateSquare(int x, int y, int w, int radius) {

        if (radius == 0){
            updateCell(x, y, w);
        } else {
            for (int i = x - radius; i <= x + radius; i++) {
                int j0 = y - radius;
                int j1 = y + radius;
                updateCell(i, j0, w);
                updateCell(i, j1, w);
            }
            for (int j = y - radius + 1; j < y + radius; j++) {
                int i0 = x - radius;
                int i1 = x + radius;
                updateCell(i0, j, w);
                updateCell(i1, j, w);
            }
        }
    }

    private void updateCell(int x, int y, int w) {
        if (0 <= x && x < n) {
            if (0 <= y && y < n) {
                if (this.region[x][y] + w > this.max) {
                    this.max = this.region[x][y] + w;
                }
                this.region[x][y] = this.region[x][y] + w;
            }
        }
    }

    public int getMaxDamage() {
        return this.max;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
        EruptingVolcanoes pacificOcean = new EruptingVolcanoes(n);

		for(int a0 = 0; a0 < m; a0++){
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();
            pacificOcean.updateDamagedRegion(x, y, w);
		}
		in.close();
        System.out.println(pacificOcean.getMaxDamage());
	}
}
