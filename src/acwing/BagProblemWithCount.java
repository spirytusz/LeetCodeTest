package acwing;

import java.util.Scanner;

/**
 * <a href="https://www.acwing.com/problem/content/4/">多重背包问题</a>
 */
@SuppressWarnings("DuplicatedCode")
public class BagProblemWithCount {

    /**
     * @param n    物品种类数
     * @param maxV 最大容积
     * @param v    物品体积
     * @param w    物品价值
     * @param s    物品个数
     * @return     最大价值
     * <p>
     * ans[i][j] = max(ans[i - 1][j], ans[i - 1][j - v] + w, ans[i - 1][j - 2 * v] + 2 * w, ... , ans[i - 1][j - min(s, j / v) * v] + min(s, j / v) * v)
     */
    public int solve(int n, int maxV, int[] v, int[] w, int[] s) {
        int[][] ans = new int[n + 1][maxV + 1];
        for (int i = 1; i < ans.length; i++) {
            for (int j = 1; j < ans[i].length; j++) {
                int count = Math.min(s[i], j / v[i]);
                int max = ans[i - 1][j];
                for (int k = 0; k < count; k++) {
                    max = Math.max(max, ans[i - 1][j - (k + 1) * v[i]] + (k + 1) * w[i]);
                }
                ans[i][j] = max;
            }
        }
        return ans[n][maxV];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), maxV = scanner.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        int[] s = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }

        BagProblemWithCount bagProblemWithCount = new BagProblemWithCount();
        int ans = bagProblemWithCount.solve(n, maxV, v, w, s);
        System.out.println(ans);
    }
}
