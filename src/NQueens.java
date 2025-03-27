import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-queens/description/">51. N-Queens</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>
 *
 * <p>Given an integer <code>n</code>, return <em>all distinct solutions to the <strong>n-queens puzzle</strong></em>. You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>Each solution contains a distinct board configuration of the n-queens' placement, where <code>'Q'</code> and <code>'.'</code> both indicate a queen and an empty space, respectively.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;">
 * <pre><strong>Input:</strong> n = 4
 * <strong>Output:</strong> [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * <strong>Explanation:</strong> There exist two distinct solutions to the 4-queens puzzle as shown above
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> [["Q"]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 9</code></li>
 * </ul>
 * </div>
 */
public class NQueens {

    private static final char QUEEN = 'Q';
    private static final char BLANK = '.';

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        char[][] nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], BLANK);
        }

        enumerate(nQueens, result, 0, n);

        return result;
    }

    private static boolean isValidPlace(char[][] nQueens, int row, int col, int n) {
        // same row
        for (int i = 0; i < n; i++) {
            if (nQueens[row][i] == QUEEN) {
                return false;
            }
        }

        // same column
        for (int i = 0; i < n; i++) {
            if (nQueens[i][col] == QUEEN) {
                return false;
            }
        }

        // left - diagonal
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (nQueens[row - i][col - i] == QUEEN) {
                return false;
            }
        }

        // right - diagonal
        for (int i = 1; row - i >= 0 && col + i < n; i++) {
            if (nQueens[row - i][col + i] == QUEEN) {
                return false;
            }
        }
        return true;
    }

    private static void enumerate(char[][] nQueens, List<List<String>> result, int layer, int n) {
        if (n == layer) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                item.add(new String(nQueens[i]));
            }
            result.add(item);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValidPlace(nQueens, layer, i, n)) {
                    nQueens[layer][i] = QUEEN;
                    enumerate(nQueens, result, layer + 1, n);
                    nQueens[layer][i] = BLANK;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (List<String> result : solveNQueens(4)) {
            for (String row : result) {
                System.out.println(row);
            }
            System.out.println();
            System.out.println();
        }
    }
}
