import java.util.HashMap;

/**
 * Link: https://leetcode.com/problems/valid-sudoku/
 * Status: AC
 * <p>
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * <p>
 * Explanation:
 * Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * Note:
 * <p>
 * 1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 2. Only the filled cells need to be validated according to the mentioned rules.
 * 3. The given board contain only digits 1-9 and the character '.'.
 * 4.  The given board size is always 9x9.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        return linearCheck(board) && DFSCheck(board, 0, 2, 0, 2, new HashMap<>());
    }

    private static boolean isValidInIndex(char[][] board, int fromX, int toX, int fromY, int toY) {
        int[] memory = new int[10];
        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {

                if (board[i][j] != '.') {
                    if (memory[board[i][j] - 48] != 0)
                        return false;
                    memory[board[i][j] - 48]++;
                }
            }
        }
        return true;
    }

    private static boolean linearCheck(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidInIndex(board, i, i, 0, 8) || !isValidInIndex(board, 0, 8, i, i))
                return false;
        }
        return true;
    }

    private static boolean DFSCheck(char[][] board, int fromX, int toX, int fromY, int toY, HashMap<Integer, Integer> mapper) {
        if (toX < board.length && toY < board.length
                && !mapper.containsKey(fromX * 1000 + toX * 100 + fromY * 10 + toY)) {
            mapper.put(fromX * 1000 + toX * 100 + fromY * 10 + toY, 0);
            return isValidInIndex(board, fromX, toX, fromY, toY)
                    && DFSCheck(board, fromX + 3, toX + 3, fromY, toY, mapper)
                    && DFSCheck(board, fromX, toX, fromY + 3, toY + 3, mapper);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board1 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
