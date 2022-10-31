package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/24/">25. 剪绳子</a>
 * <a href="https://www.acwing.com/solution/content/63930/">题解</a>
 */
public class MaxProductAfterCutting {
    /**
     * ret[i]为绳子长度为i时的解
     * 遍历0 ~ i，查看哪个地方剪断最大，设剪断点为j；
     * 剩余的长度 i - j 要决定是否再拆：
     * 1. 不拆  j * (i - j)
     * 2. 拆    j * ret[i - j]
     * ret[i] = Math.max(j * (i - j), j * ret[i - j])
     */
    public int maxProductAfterCutting_DP(int length) {
        if (length < 2) {
            return 0;
        }
        int[] ret = new int[length + 1];
        for (int i = 2; i < ret.length; i++) {
            for (int j = 0; j < i; j++) {
                ret[i] = Math.max(ret[i], Math.max((i - j) * j, j * ret[i - j]));
            }
        }
        return ret[length];
    }

    /**
     * 基本不等式可得每段应当尽量相等，可取最大值
     *
     * 设 f(x) = x ^ (n / x), x为拆分出来的数字, x ∈ R+
     * 求导得极大值点为 f(e)，f(2) < f(3)，则整数应为3。
     *
     * 当 length % 3 == 0时，ret = 3 ^ (length / 3)
     * 当 length % 3 == 1时，因为 3 * 1 < 4，所以 ret = 4 * 3 ^ ((length / 3) - 1)
     * 当 length % 3 == 2时，ret = 2 * 3 ^ (length / 3)
     */
    public int maxProductAfterCutting_Math(int length) {
        if (length <= 3) {
            return length - 1;
        }
        int m = length / 3;
        int n = length % 3;

        if (n == 0) {
            return (int) Math.pow(3, m);
        } else if (n == 1) {
            return (int) Math.pow(3, m - 1) * 4;
        } else {
            return 2 * (int) Math.pow(3, m);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductAfterCutting().maxProductAfterCutting_DP(19));
        System.out.println(new MaxProductAfterCutting().maxProductAfterCutting_Math(19));
    }
}
