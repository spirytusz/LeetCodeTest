
/**
 * Link: https://leetcode.com/problems/unique-paths/
 * Status: AC
 *
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Example1:
 * ![example](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i = 0;i<m - 1;i++) {
            for (int j = 1; j < n; j++) {
                result[j] = result[j] + result[j - 1];
            }
        }
        return result[result.length - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        for (int n = 1; n <= 10; n++) {
            System.out.println(String.format("f(%d, %d) = %d     f(%d, %d) = %d", m, n, uniquePaths(m, n), m + 1, n, uniquePaths(m + 1, n)));
        }
    }
}
