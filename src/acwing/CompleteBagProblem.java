package acwing;

import java.util.Scanner;

/**
 * <a href="https://www.acwing.com/problem/content/description/3/">完全背包问题</a>
 * <a href="https://www.acwing.com/solution/content/1375/">题解</a>
 */
@SuppressWarnings("DuplicatedCode")
public class CompleteBagProblem {

    /**
     * @param n    物品个数
     * @param maxV 背包容量
     * @param v    物品体积
     * @param w    物品价值
     * @return 最大价值
     * <p>
     * 与01背包问题不同的是，完全背包问题每个物品可以选0次或多次。
     * 定义ans[i][j]为前i个物品下容积为j时的最大容积，则有状态转移方程：
     * <p>
     * ans[i][j] = max(ans[i - 1][j] // 选0次, ans[i - 1][j - v] + w // 选1次, ... , ans[i - 1][j - (j / v) * v] + (j / v) * w // 选 (j / v)次)
     * 三重循环，时间复杂度为O(n^3)
     * <p>
     * 令j = j - v，则状态转移方程为
     * ans[i][j - v] = max(ans[i - 1][j - v], ans[i - 1][(j - v) - v] + w, ... , ans[i - 1][(j - v) - (j - v / v) * v] + (j - v / v) * w)
     *               = max(ans[i - 1][j - v], ans[i - 1][j - 2 * v] + w, ..., ans[i - 1][(j - v) - (j - v / v) * v] + (j - v / v) * w)
     *               = max(..., ans[i - 1][j - v - ((j / v) * v - (v / v) * v)] + (j / v) * w - w)
     *               = max(..., ans[i - 1][j - v - ((j / v) * v - v)] +  (j / v) * w - w)
     *               = max(..., ans[i - 1][j - (j / v) * v] + (j / v) * w - w)
     *               = max(ans[i - 1][j - v] + w , ... , ans[i - 1][j - (j / v) * v] + (j / v) * w) + w[i]
     * <p>
     * 二式合并：
     * <p>
     * ans[i][j] = max(ans[i - 1][j], ans[i][j - v[i]] + w[i])
     */
    public int solve(int n, int maxV, int[] v, int[] w) {
        int[][] ans = new int[n + 1][maxV + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxV; j++) {
                if (j >= v[i]) {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - v[i]] + w[i]);
                } else {
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
        CompleteBagProblem completeBagProblem = new CompleteBagProblem();
        int ans = completeBagProblem.solve(n, maxV, v, w);
        System.out.println(ans);
    }
}
