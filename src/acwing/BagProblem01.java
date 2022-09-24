package acwing;

import java.util.Scanner;

/**
 * <a href="https://www.acwing.com/problem/content/description/2/">01背包问题</a>
 * <a href="https://www.acwing.com/solution/content/1374/">题解</a>
 */
public class BagProblem01 {

    /**
     * @param n     物品个数
     * @param maxV  背包容量
     * @param v     物品体积
     * @param w     物品价值
     * @return 最大价值
     * <p>
     * ans[i][j]代表前i个物品下，容量为j时的最大价值
     * 在第i个物品时，可以选择装或不装，所以才叫做01；
     * 选出装和不装的最大值，所以状态转移方程：
     * <p>
     * ans[i][j] = max(ans[i - 1][j] // 不装, ans[i - 1][j - v[i]] + w[i] // 装)
     */
    public int solve(int n, int maxV, int[] v, int[] w) {
        int[][] ans = new int[n + 1][maxV + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxV; j++) {
                if (j >= v[i]) {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i - 1][j - v[i]] + w[i]);
                }
                else {
                    ans[i][j] = ans[i - 1][j];
                }
            }
        }
        return ans[n][maxV];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), maxV = scanner.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        BagProblem01 bagProblem01 = new BagProblem01();
        int ans = bagProblem01.solve(n, maxV, v, w);
        System.out.println(ans);
    }
}
