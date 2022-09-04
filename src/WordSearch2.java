import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/word-search-ii/">212. Word Search II</a>
 * @see <a href="https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)">Backtracking + Trie</a>
 */
public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrieTree(words);
        boolean[][] memory = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                memory[i][j] = true;
                collectResult(board, root, i, j, memory, result);
                memory[i][j] = false;
            }
        }
        return result;
    }

    private void collectResult(char[][] board, TrieNode node, int i, int j, boolean[][] memory, List<String> result) {
        TrieNode nextNode = node.nodes[board[i][j] - 'a'];
        if (nextNode == null) {
            return;
        }

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }

        int[][] nextPositions = new int[][]{
                {i + 1, j},
                {i - 1, j},
                {i, j + 1},
                {i, j - 1}
        };
        for (int[] nextPos : nextPositions) {
            int nextI = nextPos[0];
            int nextJ = nextPos[1];
            if (inArea(nextI, board.length) && inArea(nextJ, board[nextI].length) && !memory[nextI][nextJ]) {
                memory[nextI][nextJ] = true;
                collectResult(board, nextNode, nextI, nextJ, memory, result);
                memory[nextI][nextJ] = false;
            }
        }
    }

    private boolean inArea(int position, int len) {
        return position < len && position >= 0;
    }

    private TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new TrieNode();
                }
                node = node.nodes[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    private static class TrieNode {
        String word;
        TrieNode[] nodes = new TrieNode[26];
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}
        };
        String[] words = new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        System.out.println(new WordSearch2().findWords(board, words));
    }
}
