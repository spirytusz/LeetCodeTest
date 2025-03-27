import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> <code>grid</code> where each cell can have one of three values:</p>
 *
 * <ul>
 * 	<li><code>0</code> representing an empty cell,</li>
 * 	<li><code>1</code> representing a fresh orange, or</li>
 * 	<li><code>2</code> representing a rotten orange.</li>
 * </ul>
 *
 * <p>Every minute, any fresh orange that is <strong>4-directionally adjacent</strong> to a rotten orange becomes rotten.</p>
 *
 * <p>Return <em>the minimum number of minutes that must elapse until no cell has a fresh orange</em>. If <em>this is impossible, return</em> <code>-1</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/02/16/oranges.png" style="width: 650px; height: 137px;">
 * <pre><strong>Input:</strong> grid = [[2,1,1],[1,1,0],[0,1,1]]
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> grid = [[2,1,1],[0,1,1],[1,0,1]]
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> grid = [[0,2]]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> Since there are already no fresh oranges at minute 0, the answer is just 0.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == grid.length</code></li>
 * 	<li><code>n == grid[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 10</code></li>
 * 	<li><code>grid[i][j]</code> is <code>0</code>, <code>1</code>, or <code>2</code>.</li>
 * </ul>
 * </div>
 */
public class RottingOranges {

    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public static int orangesRotting(int[][] grid) {
        int round = 0;
        int[] counting = countingTypes(grid);
        int rottenCount = counting[ROTTEN];
        int freshCount = counting[FRESH];
        if (rottenCount == 0 && freshCount != 0) {
            return -1;
        }
        while (true) {
            spread(grid);
            int[] countingAfterSpread = countingTypes(grid);
            int rottenCountAfterSpread = countingAfterSpread[ROTTEN];
            int freshCountAfterSpread = countingAfterSpread[FRESH];
            if (rottenCountAfterSpread == rottenCount) {
                if (freshCountAfterSpread == 0) {
                    return round;
                } else {
                    return -1;
                }
            }
            round++;
            rottenCount = rottenCountAfterSpread;
        }
    }

    private static int[] countingTypes(int[][] grid) {
        int[] result = new int[3];
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == EMPTY) {
                    result[EMPTY]++;
                } else if (cell == FRESH) {
                    result[FRESH]++;
                } else {
                    result[ROTTEN]++;
                }
            }
        }
        return result;
    }

    private static void spread(int[][] grid) {
        List<int[]> willRotten = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cell = grid[i][j];
                if (cell == FRESH || cell == EMPTY) {
                    continue;
                }

                if (i - 1 >= 0 && grid[i - 1][j] == FRESH) {
                    willRotten.add(new int[]{i - 1, j});
                }
                if (i + 1 < grid.length && grid[i + 1][j] == FRESH) {
                    willRotten.add(new int[]{i + 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == FRESH) {
                    willRotten.add(new int[]{i, j - 1});
                }
                if (j + 1 < grid[i].length && grid[i][j + 1] == FRESH) {
                    willRotten.add(new int[]{i, j + 1});
                }
            }
        }

        for (int[] pos : willRotten) {
            grid[pos[0]][pos[1]] = ROTTEN;
        }
    }

    public static void main(String[] args) {
        int[][] testCase1 = new int[][]{
                {ROTTEN, FRESH, FRESH},
                {EMPTY, FRESH, FRESH},
                {FRESH, EMPTY, FRESH}
        };
        System.out.println(orangesRotting(testCase1));

        int[][] testCase2 = new int[][]{
                {ROTTEN, FRESH, FRESH},
                {FRESH, FRESH, EMPTY},
                {EMPTY, FRESH, FRESH}
        };
        System.out.println(orangesRotting(testCase2));

        int[][] testCase3 = new int[][]{
                {EMPTY}
        };
        System.out.println(orangesRotting(testCase3));

        int[][] testCase4 = new int[][]{
                {FRESH}
        };
        System.out.println(orangesRotting(testCase4));
    }
}
