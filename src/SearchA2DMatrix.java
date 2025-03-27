/**
 *
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">74. Search a 2D Matrix</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> integer matrix <code>matrix</code> with the following two properties:</p>
 *
 * <ul>
 * 	<li>Each row is sorted in non-decreasing order.</li>
 * 	<li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 *
 * <p>Given an integer <code>target</code>, return <code>true</code> <em>if</em> <code>target</code> <em>is in</em> <code>matrix</code> <em>or</em> <code>false</code> <em>otherwise</em>.</p>
 *
 * <p>You must write a solution in <code>O(log(m * n))</code> time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;">
 * <pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg" style="width: 322px; height: 242px;">
 * <pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 100</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom) {
            int center = (top + bottom) / 2;
            int element = matrix[center][matrix[center].length - 1];
            if (element > target) {
                bottom = center;
            } else if (element < target) {
                top = center + 1;
            } else {
                return true;
            }
        }
        int left = 0;
        int right = matrix[top].length - 1;
        while (left < right) {
            int center = (left + right) / 2;
            if (matrix[top][center] > target) {
                right = center;
            } else if (matrix[top][center] < target) {
                left = center + 1;
            } else {
                return true;
            }
        }
        return matrix[top][left] == target;
    }

    public static void main(String[] args) throws Throwable {
        int[][] testCase1 = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {20, 30, 34, 60}
        };
        System.out.println(searchMatrix(testCase1, 1));
        System.out.println(searchMatrix(testCase1, 11));
        System.out.println(searchMatrix(testCase1, 60));

        System.out.println();

        int[][] testCase2 = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {20, 30, 34, 60},
                {70, 80, 90, 99}
        };
        for (int[] first : testCase2) {
            for(int second: first) {
                if (!searchMatrix(testCase2, second)) {
                    throw new Throwable("" + second);
                }
            }
        }
    }
}
