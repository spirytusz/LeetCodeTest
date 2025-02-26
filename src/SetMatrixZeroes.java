/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked">73. Set Matrix Zeroes</a>
 *
 * <p>Given an <code>m x n</code> integer matrix <code>matrix</code>, if an element is <code>0</code>, set its entire row and column to <code>0</code>&#39;s.</p>
 *
 * <p>You must do it <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg" style="width: 450px; height: 169px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * <strong>Output:</strong> [[1,0,1],[0,0,0],[1,0,1]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg" style="width: 450px; height: 137px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * <strong>Output:</strong> [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[0].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 200</code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= matrix[i][j] &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * 	<li>A straightforward solution using <code>O(mn)</code> space is probably a bad idea.</li>
 * 	<li>A simple improvement uses <code>O(m + n)</code> space, but still not the best solution.</li>
 * 	<li>Could you devise a constant space solution?</li>
 * </ul>
 */
public class SetMatrixZeroes {


    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        printMatrix(matrix);
    }

    private static void testCase2() {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int num : line) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
