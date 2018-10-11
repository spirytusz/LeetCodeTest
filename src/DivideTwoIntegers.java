/**
 * Link: https://leetcode.com/problems/divide-two-integers/
 * Status: Have no idea
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
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        int result = 0;
        String binaryDivisor = Integer.toBinaryString(Math.abs(divisor));
        for (int i = binaryDivisor.length() - 1; i >= 0; i--) {
            if (binaryDivisor.charAt(i) == '1') {
                dividend = dividend >> (binaryDivisor.length() - i - 1);
            }
        }
        return dividend * (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? 1 : -1);
    }

    public static void main(String[] args) {

    }
}