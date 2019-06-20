import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/spiral-matrix/
 * Status: AC
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return integers;
        } else if (matrix.length == 1) {
            for (int j = 0; j < matrix[0].length; j++) {
                integers.add(matrix[0][j]);
            }
            return integers;
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                integers.add(matrix[i][0]);
            }
            return integers;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int size = rows * columns;
        int layer = 0;
        while (rows > 0 && columns > 0) {
            int i = layer;
            int j = layer;
            for (; j < columns - 1 && integers.size() < size; j++) {
                integers.add(matrix[i][j]);
            }
            for (; i < rows - 1 && integers.size() < size; i++) {
                integers.add(matrix[i][j]);
            }
            for (; j > layer && integers.size() < size; j--) {
                integers.add(matrix[i][j]);
            }
            for (; i > layer && integers.size() < size; i--) {
                integers.add(matrix[i][j]);
            }
            rows--;
            columns--;
            layer++;
        }
        if (matrix.length == matrix[0].length && (matrix.length - 1) % 2 == 0) {
            integers.add(matrix[(matrix.length - 1) >> 1][(matrix.length - 1) >> 1]);
        }
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                        /*{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}*/
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10}

                        /*{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12},
                        {13, 14, 15}*/

                        /*{1, 2, 3}*/
                        /*{1},
                        {2},
                        {3}*/
                        /*{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}*/
                }
        ));
    }
}
