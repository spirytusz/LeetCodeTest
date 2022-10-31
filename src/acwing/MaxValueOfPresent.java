package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/56/">60. 礼物的最大价值</a>
 */
public class MaxValueOfPresent {

    public int getMaxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] ans = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[i - 1].length; j++) {
                ans[i][j] = grid[i - 1][j - 1] + Math.max(ans[i - 1][j], ans[i][j - 1]);
            }
        }
        return ans[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 3, 1},
                {1, 7, 1},
                {4, 6, 1}
        };
        System.out.println(new MaxValueOfPresent().getMaxValue(grid));
    }
}
