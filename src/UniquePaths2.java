/**
 * Link: https://leetcode.com/problems/unique-paths-ii/
 * Status: AC
 *
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Example 1:
 * ![exp1](https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg)
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * <p>
 * Example 2:
 * ![exp2](https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg)
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        result[0][0] = obstacleGrid[0][0] != 1 ? 1 : 0;
        for (int i = 1; i < result.length; i++) {
            result[i][0] = obstacleGrid[i][0] != 1 ? result[i - 1][0] : 0;
        }
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = obstacleGrid[0][i] != 1 ? result[0][i - 1] : 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                result[i][j] = obstacleGrid[i][j] != 1 ? result[i - 1][j] + result[i][j - 1] : 0;
            }
        }
        return result[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {1, 1}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
