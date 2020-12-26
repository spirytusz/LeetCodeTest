package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11216&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如:
 * [ a  b  c  e ]
 * [ s  f  c  s ]
 * [ a  d  e  e ]
 * <p>
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean hasPath = hasPathInternal(matrix, i, j, rows, cols, 0, str, new boolean[rows * cols]);
                if (hasPath) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathInternal(char[] matrix, int i, int j, int rows, int cols, int index, char[] str, boolean[] accessed) {
        if (index == str.length) {
            return true;
        } else if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        } else if (!hasAccess(accessed, i, j, cols) &&  access(matrix, i, j, cols) == str[index]) {
            markAsAccess(accessed, true, i, j, cols);
            if (hasPathInternal(matrix, i - 1, j, rows, cols, index + 1, str, accessed)) return true;
            if (hasPathInternal(matrix, i, j - 1, rows, cols, index + 1, str, accessed)) return true;
            if (hasPathInternal(matrix, i + 1, j, rows, cols, index + 1, str, accessed)) return true;
            if (hasPathInternal(matrix, i, j + 1, rows, cols, index + 1, str, accessed)) return true;
            markAsAccess(accessed, false, i, j, cols);
            return false;
        } else {
            return false;
        }
    }

    private char access(char[] matrix, int i, int j, int cols) {
        return matrix[i * cols + j];
    }

    private boolean hasAccess(boolean[] accessed, int i, int j, int cols) {
        return accessed[i * cols + j];
    }

    private void markAsAccess(boolean[] accessed, boolean access, int i, int j, int cols) {
        accessed[i * cols + j] = access;
    }

    public static void main(String[] args) {
        System.out.println(new HasPath().hasPath("ABCGSFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
    }
}
