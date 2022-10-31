package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/76/">80. 骰子的点数</a>
 * <a href="https://www.acwing.com/solution/content/852/">题解</a>
 */
public class NumberOfDice {
    /**
     * @param n 扔几次
     * @return 每个结果的组合个数
     * <p>
     * 扔i次，结果为j，可以从 第 i - 1次 扔 [j - 1, j - 2, ..., j - 6] 而来
     * <p>
     * ans[i][j] = ans[i - 1][j - 1] + ... + ans[i - 1][j - 6]
     */
    public int[] numberOfDice(int n) {
        int[][] ans = new int[n + 1][6 * n + 1];
        ans[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6 * n; j++) {
                for (int x = 1; x <= 6 && j >= x; x++) {
                    ans[i][j] += ans[i - 1][j - x];
                }
            }
        }
        int[] ret = new int[5 * n + 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] += ans[n][i + n];
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int n : new NumberOfDice().numberOfDice(2)) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
}
