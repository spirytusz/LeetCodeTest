/**
 * Link: https://leetcode.com/problems/spiral-matrix-ii/
 * Status: AC
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{};
        }
        int[][] matrix = new int[n][n];
        int count = 1;
        int step = n - 1;
        int[] header = new int[]{0, 0};
        while (step > 0) {
            int i = header[0];
            int j = header[1];
            for (int num = 0; num < step && count < n * n; num++) {
                matrix[i][j++] = count++;
            }
            for (int num = 0; num < step && count < n * n; num++) {
                matrix[i++][j] = count++;
            }
            for (int num = 0; num < step && count < n * n; num++) {
                matrix[i][j--] = count++;
            }
            for (int num = 0; num < step && count < n * n; num++) {
                matrix[i--][j] = count++;
            }
            step -= 2;
            header[0]++;
            header[1]++;
        }
        if (n % 2 != 0) {
            matrix[header[0]][header[1]] = count;
        } else {
            matrix[header[0]][header[1] - 1] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] rsp = generateMatrix(3);
        for (int i = 0; i < rsp.length; i++) {
            for (int j = 0; j < rsp[i].length; j++) {
                System.out.print(rsp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
