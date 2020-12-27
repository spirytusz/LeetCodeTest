package newcoder;

import java.util.ArrayList;

/**
 * Link: https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&&tqId=11172&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ZigZagPrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }
        } else {
            int colStep = matrix[0].length - 1;
            int rowStep = matrix.length - 1;
            int pCol = 0;
            int pRow = 0;
            while (result.size() < matrix.length * matrix[0].length) {
                int i = 0;
                int j = 0;
                while (j < colStep) {
                    result.add(matrix[pRow + i][pCol + j++]);
                }
                while (i < rowStep) {
                    result.add(matrix[pRow + i++][pCol + j]);
                }
                while (j > 0) {
                    result.add(matrix[pRow + i][pCol + j--]);
                }
                while (i > 0) {
                    result.add(matrix[pRow + i--][pCol + j]);
                }
                pRow++;
                pCol++;
                rowStep -= 2;
                colStep -= 2;
                System.out.printf("pRow = %d, pCol = %d\n", pRow, pCol);
                System.out.printf("rowStep = %d, colStep = %d\n", rowStep, colStep);
                if (rowStep == 0 && colStep == 0) {
                    result.add(matrix[pRow][pCol]);
                    break;
                } else if (rowStep == 0) {
                    while (colStep-- >= 0) {
                        result.add(matrix[pRow][pCol++]);
                    }
                    break;
                } else if (colStep == 0){
                    while (rowStep-- >= 0) {
                        result.add(matrix[pRow++][pCol]);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                /*{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}*/
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(new ZigZagPrintMatrix().printMatrix(matrix));
    }
}
