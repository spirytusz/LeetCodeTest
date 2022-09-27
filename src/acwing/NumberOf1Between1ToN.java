package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/description/51/">56. 从1到n整数中1出现的次数</a>
 * <a href="https://www.cnblogs.com/xuanxufeng/p/6854105.html">题解</a>
 */
public class NumberOf1Between1ToN {
    public int numberOf1Between1AndN_Solution(int n) {
        int ret = 0;
        for (long m = 1; m <= n; m *= 10 /* 枚举个位，十位，百位，千位 ... */) {
            int ab = (int) ((long) n / m);
            int abLastDigit = ab % 10;
            if (abLastDigit >= 2) {
                // 假设当前为百位，n = 3349，此时 abLastDigit = 3, ab = 33, m = 100
                // 情况有：
                //      100  ~  199
                //     1100  ~  1199
                //     2100  ~  2199
                //     3100  ~  3199
                // 共有 (ab / 10 + 1) * m = 400 种情况
                ret += (ab / 10 + 1) * m;
            } else if (abLastDigit == 1) {
                // 假设当前为百位，n = 3149，此时 abLastDigit = 1, ab = 31, m = 100, n % m = 49
                // 情况有:
                //       100  ~  199
                //      1100  ~  1199
                //      2100  ~  2199
                //      3100  ~  3149
                // 共有 (ab / 10) * m + n % m + 1 // 3100也是一种情况 种情况
                ret += (ab / 10) * m + n % m + 1;
            } else {
                // 假设当前为百位，n = 3049，此时 abLastDigit = 0, ab = 30, m = 100, n % m = 49
                // 情况有:
                //       100  ~  199
                //      1100  ~  1199
                //      2100  ~  2199
                // 共有 (ab / 10) * m 种情况
                ret += (ab / 10) * m;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1ToN().numberOf1Between1AndN_Solution(12));
        System.out.println(new NumberOf1Between1ToN().numberOf1Between1AndN_Solution(13));
    }
}
