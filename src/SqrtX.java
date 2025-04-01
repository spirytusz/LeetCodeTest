
/**
 * <a href="https://leetcode.com/problems/sqrtx/description/">69. Sqrt(x)</a>
 * 
 * <p>Given a non-negative integer <code>x</code>, return <em>the square root of </em><code>x</code><em> rounded down to the nearest integer</em>. The returned integer should be <strong>non-negative</strong> as well.</p>
 * 
 * <p>You <strong>must not use</strong> any built-in exponent function or operator.</p>
 * 
 * <ul>
 * 	<li>For example, do not use <code>pow(x, 0.5)</code> in c++ or <code>x ** 0.5</code> in python.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> x = 4
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The square root of 4 is 2, so we return 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong> x = 8
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>

 */
public class SqrtX {


    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long pow = (long) mid * mid;
            if (pow == (long) x) {
                return mid;
            } else if (pow < (long) x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
