/**
 * Link: https://leetcode.com/problems/sudoku-solver/
 * Status: AC
 * Reference: https://leetcode.com/problems/sudoku-solver/discuss/178878/Super-Simple-solution-in-Java
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * 1. Each of the digits 1-9 must occur exactly once in each row.
 * 2. Each of the digits 1-9 must occur exactly once in each column.
 * 3. Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * Note:
 * <p>
 * 1. The given board contain only digits 1-9 and the character '.'.
 * 2. You may assume that the given Sudoku puzzle will have a single unique solution.
 * 3. The given board size is always 9x9.
 */
public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        if (board != null) {
            sudokuSolver(board);
        }
    }

    private static boolean sudokuSolver(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidFulfilling(board, i, j, c)) {
                            board[i][j] = c;
                            if (sudokuSolver(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidFulfilling(char[][] board, int x, int y, char c) {
        int fromX = x - x % 3;
        int fromY = y - y % 3;
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == c || board[x][i] == c || board[fromX + i / 3][fromY + i % 3] == c) {
                return false;
            }
        }
        return true;
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
        test(board);
    }

    private static void test(char[][] board) {
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
