/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">240. Search a 2D Matrix II</a>
 */
public class Search2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int column = 0;
        int row = matrix[column].length - 1;
        while (column < matrix.length && row >= 0) {
            int pointerValue = matrix[column][row];
            if (pointerValue == target) {
                return true;
            } else if (pointerValue > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new Search2DMatrix2().searchMatrix(matrix, 5));
    }
}
