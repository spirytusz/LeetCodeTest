
/**
 * Link: https://leetcode.com/problems/powx-n/
 * Refer: https://leetcode.com/problems/powx-n/discuss/314203/clean-Java-Solution-using-fast-exponentiation-O(log-n)-time-complexity
 * Status: AC
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class PowXN {

    public static double myPow(double x, int n) throws InterruptedException {
        if (x == 1 || n == 0) {
            return 1;
        } else if (n > 0) {
            return fastPow(x, n);
        } else {
            return fastPow(1 / x, Math.abs(n));
        }
    }

    private static double fastPow(double x, int n) throws InterruptedException {
        System.out.println("x = " + x + "\tn = " + n);
        Thread.sleep(200);
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double result = fastPow(x, Math.abs(n) / 2);
            return result * result;
        } else {
            double result = fastPow(x, (Math.abs(n) - 1) / 2);
            return x * result * result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(myPow(2.00000, 6));
    }
}
