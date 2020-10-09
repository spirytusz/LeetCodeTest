/**
 * Link: https://leetcode.com/problems/divide-two-integers/
 * Status: AC
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * · Both dividend and divisor will be 32-bit signed integers.
 * · The divisor will never be 0.
 * · Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        long absDividend = abs(dividend);
        long absDivisor = abs(divisor);
        long start = 1;
        long end = absDividend;
        while (start < end) {
            long mid = (start + end) / 2;
            long midValue = Math.abs(absDividend) - Math.abs(mid * absDivisor);
            if (midValue == 0) {
                return (int) ((dividend < 0 || divisor < 0) ? -mid : mid);
            } else if (midValue > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int result = (int) Math.min(start, end);
        if (absDividend - result * absDivisor < 0) {
            result--;
        }
        return (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? result : -result;
    }

    private static long abs(int a) {
        return Math.abs((long) a);
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}