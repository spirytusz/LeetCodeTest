public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() <= 0) {
            return false;
        }
        boolean[][] memory = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                memory[i][j] = true;
                if (isPathExist(board, word, i, j, 0, memory)) {
                    return true;
                }
                memory[i][j] = false;
            }
        }
        return false;
    }

    private boolean isPathExist(char[][] board, String word, int boardPositionX, int boardPositionY, int wordIndex, boolean[][] memory) {
        if (board[boardPositionX][boardPositionY] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex + 1 == word.length()) {
            return true;
        }
        if (inArea(boardPositionX + 1, board.length) && inArea(boardPositionY, board[boardPositionX].length) && !hasAccess(boardPositionX + 1, boardPositionY, memory)) {
            memory[boardPositionX + 1][boardPositionY] = true;
            if (isPathExist(board, word, boardPositionX + 1, boardPositionY, wordIndex + 1, memory)) {
                return true;
            }
            memory[boardPositionX + 1][boardPositionY] = false;
        }
        if (inArea(boardPositionX - 1, board.length) && inArea(boardPositionY, board[boardPositionX].length) && !hasAccess(boardPositionX - 1, boardPositionY, memory)) {
            memory[boardPositionX - 1][boardPositionY] = true;
            if (isPathExist(board, word, boardPositionX - 1, boardPositionY, wordIndex + 1, memory)) {
                return true;
            }
            memory[boardPositionX - 1][boardPositionY] = false;
        }
        if (inArea(boardPositionX, board.length) && inArea(boardPositionY + 1, board[boardPositionX].length) && !hasAccess(boardPositionX, boardPositionY + 1, memory)) {
            memory[boardPositionX][boardPositionY + 1] = true;
            if (isPathExist(board, word, boardPositionX, boardPositionY + 1, wordIndex + 1, memory)) {
                return true;
            }
            memory[boardPositionX][boardPositionY + 1] = false;
        }
        if (inArea(boardPositionX, board.length) && inArea(boardPositionY - 1, board[boardPositionX].length) && !hasAccess(boardPositionX, boardPositionY - 1, memory)) {
            memory[boardPositionX][boardPositionY - 1] = true;
            if (isPathExist(board, word, boardPositionX, boardPositionY - 1, wordIndex + 1, memory)) {
                return true;
            }
            memory[boardPositionX][boardPositionY - 1] = false;
        }
        return false;
    }

    private boolean inArea(int position, int len) {
        return position < len && position >= 0;
    }

    private boolean hasAccess(int i, int j, boolean[][] memory) {
        return memory[i][j];
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));
    }
}
