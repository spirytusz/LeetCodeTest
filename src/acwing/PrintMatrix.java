package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/39/">40. 顺时针打印矩阵</a>
 */
public class PrintMatrix {

    public int[] printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[m * n];
        int x = 0;
        int y = 0;
        int p = 0;

        while (m > 0 || n > 0) {
            for (int j = 0; j < n - 1 && p < ret.length; j++) {
                ret[p++] = matrix[x][y + j];
            }
            for (int i = 0; i < m - 1 && p < ret.length; i++) {
                ret[p++] = matrix[x + i][y + n - 1];
            }
            for (int j = 0; j < n - 1 && p < ret.length; j++) {
                ret[p++] = matrix[x + m - 1][y + n - 1 - j];
            }
            for (int i = 0; i < m - 1 && p < ret.length; i++) {
                ret[p++] = matrix[x + m - 1 - i][y];
            }

            m -= 2;
            n -= 2;
            x++;
            y++;
        }

        if (m == n) {
            ret[p] = matrix[x - 1][y - 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3, 4, 5}
        };
        int[][] matrix2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix3 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        for (int num : new PrintMatrix().printMatrix(matrix1)) {
            System.out.print(num + "\t");
        }
        System.out.println();

        for (int num : new PrintMatrix().printMatrix(matrix2)) {
            System.out.print(num + "\t");
        }
        System.out.println();

        for (int num : new PrintMatrix().printMatrix(matrix3)) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}
