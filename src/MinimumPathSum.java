/**
 * Link: https://leetcode.com/problems/minimum-path-sum/
 * Status: OK
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * ![exp1](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg)
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    result[i][j] = grid[i][j] + result[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    result[i][j] = grid[i][j] + result[i - 1][j];
                    continue;
                }
                result[i][j] = Math.min(result[i][j - 1], result[i - 1][j]) + grid[i][j];
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1}
        };
        System.out.println(minPathSum(grid));
    }
}
