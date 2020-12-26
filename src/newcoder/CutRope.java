package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&&tqId=33257&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 解析：
 * 状态转移方程：
 * f(n, m) = max(1 * f(n - 1, m - 1), 2 * f(n - 2, m - 1), .. , [n - (m - 1)] * f([n - (m - 1)], m -1))
 *         = max(1 * f(n - 1, m - 1), 2 * f(n - 2, m - 1), .. , (n - m + 1) * f(n - m + 1, m - 1))
 */
public class CutRope {

    public int cutRope(int target) {
        int[][] result = new int[target][target];
        for (int n = 0; n < result.length; n++) {
            for (int m = 0; m <= n; m++) {
                if (m == 0) {
                    result[n][m] = n + 1;
                } else {
                    for (int i = 0; i < n - m + 1; i++) {
                        int currentResult = result[n][m];
                        int currentLoop = (i + 1) * result[n - i - 1][m - 1];
                        if (currentResult < currentLoop) {
                            result[n][m] = currentLoop;
                        }
                    }
                }
            }
        }
        int ret = 0;
        for (int i = 0;i<result.length;i++) {
            if (ret < result[target - 1][i]) {
                ret = result[target - 1][i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(8));
    }
}
